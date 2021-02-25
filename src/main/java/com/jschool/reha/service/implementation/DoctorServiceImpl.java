package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.*;
import com.jschool.reha.dto.AssignmentDto;
import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.dto.PatientDto;
import com.jschool.reha.dto.TreatmentDto;
import com.jschool.reha.dto.helpers.*;
import com.jschool.reha.entity.*;
import com.jschool.reha.enums.MedEventStatus;
import com.jschool.reha.jms.JMSUpdateComponent;
import com.jschool.reha.jms.MedEventEntityToRestDtoHelper;
import com.jschool.reha.service.helpers.MedEventCalendar;
import com.jschool.reha.service.interfaces.DoctorService;
import com.jschool.reha.service.interfaces.NurseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private static final Logger logger = LogManager.getLogger();

    UserDAO userDAO;

    PatientDAO patientDAO;

    MedStaffDAO medStaffDAO;

    TreatmentDAO treatmentDAO;

    AssignmentDAO assignmentDAO;

    MedEventDAO medEventDAO;

    PatternDAO patternDAO;

    PasswordEncoder passwordEncoder;

    MedEventCalendar medEventCalendar;

    NurseService nurseService;

    JMSUpdateComponent jms;

    public DoctorServiceImpl(UserDAO userDAO, PatientDAO patientDAO, MedStaffDAO medStaffDAO,
                             TreatmentDAO treatmentDAO, AssignmentDAO assignmentDAO,
                             MedEventDAO medEventDAO, PatternDAO patternDAO, PasswordEncoder passwordEncoder,
                             MedEventCalendar medEventCalendar, NurseService nurseService, JMSUpdateComponent jms) {
        this.userDAO = userDAO;
        this.patientDAO = patientDAO;
        this.medStaffDAO = medStaffDAO;
        this.treatmentDAO = treatmentDAO;
        this.assignmentDAO = assignmentDAO;
        this.medEventDAO = medEventDAO;
        this.patternDAO = patternDAO;
        this.passwordEncoder = passwordEncoder;
        this.medEventCalendar = medEventCalendar;
        this.nurseService = nurseService;
        this.jms = jms;
    }

    @Override
    public void addNewTreatment(TreatmentDto treatmentDto) {
        Treatment treatmentEntity = new Treatment();
        treatmentEntity.setOpenedComments(treatmentDto.getOpenedComments());
        treatmentEntity.setDiagnosis(treatmentDto.getDiagnosis());
        treatmentEntity.setTreatmentOpened(LocalDate.now());
        treatmentEntity.setPatient(patientDAO.findPatientById(treatmentDto.getPatient().getIdPatient()));
        treatmentEntity.setDoctor(medStaffDAO.findMedStaffById(treatmentDto.getDoctor().getIdMedStaff()));
        treatmentDAO.addNewTreatment(treatmentEntity);
    }

    @Override
    public void addNewAssignment(AssignmentDto assignmentDto) {
        Assignment assignmentEntity = new Assignment();
        assignmentEntity.setAssignmentStartDate(LocalDate.now());
        assignmentEntity.setDosage(assignmentDto.getDosage());
        assignmentEntity.setName(assignmentDto.getName());
        assignmentEntity.setType(assignmentDto.getType());
        assignmentEntity.setQuantity(assignmentDto.getQuantity());
        assignmentEntity.setTreatment(treatmentDAO.findTreatmentById(assignmentDto.getTreatment().getIdTreatment()));

        Pattern pattern = patternDAO.addNewPattern(PatternEntityDtoHelper.dtoToEntity(assignmentDto.getPattern()));
        assignmentEntity.setPattern(pattern);
        assignmentDAO.addNewAssignment(assignmentEntity);

        this.generateMedEventsForNewAssingment(assignmentEntity);
    }

    @Override
    public void generateMedEventsForNewAssingment(Assignment assignment) {
        logger.info("Generating events for assignement for " + assignment.getQuantity() + " weeks");
        List<LocalDateTime> eventsTime = medEventCalendar.getTimeForEvents(assignment.getQuantity() * 7, assignment.getPattern(),
                assignment.getAssignmentStartDate().atTime(LocalTime.of(0, 0)));
        for (LocalDateTime time : eventsTime) {
            MedEvent medEvent = new MedEvent();
            medEvent.setAssignment(assignment);
            medEvent.setStarts(time);
            medEvent.setStatus(MedEventStatus.SCHEDULED);
            medEvent.setPatient(assignment.getTreatment().getPatient());
            medEvent.setNurse(nurseService.findNurseForEvent(time));

            medEventDAO.addNewMedEvent(medEvent);
            if (medEvent.getStarts().toLocalDate().isEqual(LocalDate.now())) {
                jms.newMedEventMessage(MedEventEntityToRestDtoHelper.entityToDto(medEvent));
            }
        }
    }

    @Override
    public void addNewMedEvent(MedEventDto medEventDto) {
        MedEvent medEventEntity = new MedEvent();
        medEventEntity.setStarts(medEventDto.getStarts());
        medEventEntity.setAssignment(assignmentDAO.getAssignmentById(medEventDto.getAssignment().getIdAssignment()));
        medEventEntity.setNurse(medStaffDAO.findMedStaffById(medEventDto.getNurse().getIdMedStaff()));
        medEventEntity.setPatient(patientDAO.findPatientById(medEventDto.getPatient().getIdPatient()));
        medEventEntity.setStatus(medEventDto.getStatus());
        medEventDAO.addNewMedEvent(medEventEntity);
    }

    @Override
    public List<TreatmentDto> getAllTreatments() {
        ArrayList<TreatmentDto> treatmentDtos = new ArrayList<>();
        List<Treatment> treatments = treatmentDAO.findAllTreatments();
        for (Treatment treatment : treatments) {
            treatmentDtos.add(TreatmentEntityDtoHelper.entityToDto(treatment));
        }
        return treatmentDtos;
    }

    @Override
    public List<TreatmentDto> getTreatmentsForDoctorId(int id) {
        ArrayList<TreatmentDto> treatmentDtos = new ArrayList<>();
        List<Treatment> treatments = treatmentDAO.findAllTreatments();
        for (Treatment treatment : treatments) {
            treatmentDtos.add(TreatmentEntityDtoHelper.entityToDto(treatment));
        }
        return treatmentDtos;
    }

    @Override
    public TreatmentDto getTreatmentById(int idTreatment) {
        return TreatmentEntityDtoHelper.entityToDto(treatmentDAO.findTreatmentById(idTreatment));
    }

    @Override
    public List<PatientDto> getAllPatients() {
        ArrayList<PatientDto> patientDtos = new ArrayList<>();
        List<Patient> patients = patientDAO.getAllPatients();
        for (Patient patient : patients) {
            patientDtos.add(PatientEntityDtoHelper.entityToDto(patient));
        }
        return patientDtos;
    }

    @Override
    public List<AssignmentDto> getAssignmentsForTreatment(int treatmentId) {
        ArrayList<AssignmentDto> assignmentDtos = new ArrayList<>();
        List<Assignment> assignments = assignmentDAO.getAssignmentsForTreatment(treatmentId);
        for (Assignment assignment : assignments) {
            assignmentDtos.add(AssignmentEntityDtoHelper.entityToDto(assignment));
        }
        return assignmentDtos;
    }

    @Override
    public AssignmentDto getAssignmentById(int idAssignment) {
        return AssignmentEntityDtoHelper.entityToDto(assignmentDAO.getAssignmentById(idAssignment));
    }

    @Override
    public void editTreatment(TreatmentDto treatmentDto) {
        logger.info("editing treatment with id:" + treatmentDto.getIdTreatment());
        Treatment treatment = treatmentDAO.findTreatmentById(treatmentDto.getIdTreatment());
        treatment.setDiagnosis(treatmentDto.getDiagnosis());
        treatment.setOpenedComments(treatmentDto.getOpenedComments());
        treatmentDAO.update(treatment);
    }

    @Override
    public void closeTreatment(TreatmentDto treatmentDto) {
        logger.info("closing treatment with id" + treatmentDto.getIdTreatment());
        Treatment treatment = treatmentDAO.findTreatmentById(treatmentDto.getIdTreatment());
        treatment.setDiagnosis(treatmentDto.getDiagnosis());
        treatment.setOpenedComments(treatmentDto.getOpenedComments());
        treatment.setTreatmentClosed(LocalDate.now());
        treatment.setClosedComments(treatmentDto.getClosedComments());
        treatmentDAO.update(treatment);

        for (Assignment assignment : treatment.getAssignments()) {
            if (assignment.getAssignmentEndDate() == null) {
                assignment.setClosedComments("Treatment closed");
                assignment.setAssignmentEndDate(LocalDate.now());
                closeAssignment(AssignmentEntityDtoHelper.entityToDto(assignment));
            }
        }
    }

    @Override
    public void editAssignment(AssignmentDto assignmentDto) {
        logger.info("editing treatment with id:" + assignmentDto.getIdAssignment());
        Assignment assignment = assignmentDAO.getAssignmentById(assignmentDto.getIdAssignment());
        int prevQuantity = assignment.getQuantity();
        Pattern prevPattern = assignment.getPattern();
        Pattern newPattern = PatternEntityDtoHelper.dtoToEntity(assignmentDto.getPattern());
        if (!newPattern.equals(prevPattern)) patternDAO.addNewPattern(newPattern);
        assignment.setDosage(assignmentDto.getDosage());
        assignment.setPattern(newPattern);
        assignment.setQuantity(assignmentDto.getQuantity());

        assignmentDAO.update(assignment);

        alterMedEventsOnAssignmentEdit(assignment, prevQuantity, prevPattern);

    }

    @Override
    public void closeAssignment(AssignmentDto assignmentDto) {
        logger.info("closing assignment with id" + assignmentDto.getIdAssignment());
        Assignment assignment = assignmentDAO.getAssignmentById(assignmentDto.getIdAssignment());
        assignment.setClosedComments(assignmentDto.getClosedComments());
        assignment.setAssignmentEndDate(assignmentDto.getAssignmentEndDate());
        assignmentDAO.update(assignment);

        for (MedEvent medEvent : assignment.getMedEvents()) {
            {
                medEvent.setClosedComments("Assignment closed");
                medEvent.setStatus(MedEventStatus.CANCELED);

                closeMedEvent(MedEventEntityDtoHelper.entityToDto(medEvent));
            }
        }
    }

    @Override
    public void closeMedEvent(MedEventDto medEventDto) {
        logger.info("closing medEvent with id" + medEventDto.getIdMedEvent());
        MedEvent medEvent = medEventDAO.getMedEventById(medEventDto.getIdMedEvent());
        if (medEvent.getStatus() == MedEventStatus.SCHEDULED || medEvent.getStatus() == MedEventStatus.PENDING) {
            medEvent.setStatus(medEventDto.getStatus());
            medEvent.setClosedComments(medEventDto.getClosedComments());

            medEventDAO.update(medEvent);
        }
        if (medEvent.getStarts().toLocalDate().isEqual(LocalDate.now())) {
            jms.closedMedEventMessage(medEvent.getIdMedEvent(), medEvent.getStatus());
        }
    }


    @Override
    public List<MedEventDto> getAllMedEventsForAssignment(int assignmentId) {
        ArrayList<MedEventDto> medEventDtos = new ArrayList<>();
        List<MedEvent> medEvents = medEventDAO.getAllMedEventsForAssignment(assignmentId);
        for (MedEvent medEvent : medEvents) {
            medEventDtos.add(MedEventEntityDtoHelper.entityToDto(medEvent));
        }
        return medEventDtos;
    }

    /**
     * Changes existing or adds new MedEvents upon assignment Edit
     *
     * @param assignment   - edited assignment
     * @param prevQuantity - prev Quantity
     */
    private void alterMedEventsOnAssignmentEdit(Assignment assignment, int prevQuantity, Pattern prevPattern) {
        int diff = assignment.getQuantity() - prevQuantity;
        boolean patternChanged = !PatternEntityDtoHelper.isSamePattern(assignment.getPattern(), prevPattern);

        //check if nothing changed
        if (diff == 0 && !patternChanged) return;

        //cancel events on shortening assignment length
        if (diff < 0) {
            LocalDate closeAfter = assignment.getAssignmentStartDate().plusWeeks(assignment.getQuantity());
            for (MedEvent medEvent : assignment.getMedEvents()) {
                if (medEvent.getStarts().toLocalDate().isAfter(closeAfter)) {
                    if (medEvent.getStatus() != MedEventStatus.CANCELED || medEvent.getStatus() != MedEventStatus.DONE) {
                        medEvent.setClosedComments("Assignment edited");
                        medEvent.setStatus(MedEventStatus.CANCELED);
                        closeMedEvent(MedEventEntityDtoHelper.entityToDto(medEvent));
                    }
                }
            }
        }

        //cancel all events after now if pattern changed
        if (patternChanged) {
            LocalDateTime closeAfter = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            for (MedEvent medEvent : assignment.getMedEvents()) {
                if (medEvent.getStarts().isAfter(closeAfter)) {
                    if (medEvent.getStatus() != MedEventStatus.CANCELED || medEvent.getStatus() != MedEventStatus.DONE) {
                        medEvent.setClosedComments("Assignment edited");
                        medEvent.setStatus(MedEventStatus.CANCELED);
                        closeMedEvent(MedEventEntityDtoHelper.entityToDto(medEvent));
                    }
                }
            }
        }


        LocalDateTime genStart = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1);
        LocalDateTime genEnd = assignment.getAssignmentStartDate().plusWeeks(assignment.getQuantity()).atTime(0, 0);
        int daysBetween = (int) ChronoUnit.DAYS.between(genStart, genEnd);
        List<LocalDateTime> eventsTime = medEventCalendar.getTimeForEvents(daysBetween, assignment.getPattern(),
                genStart.withHour(0));
        for (LocalDateTime time : eventsTime) {
            MedEvent medEvent = new MedEvent();
            medEvent.setAssignment(assignment);
            medEvent.setStarts(time);
            medEvent.setStatus(MedEventStatus.SCHEDULED);
            medEvent.setPatient(assignment.getTreatment().getPatient());
            medEvent.setNurse(nurseService.findNurseForEvent(time));

            medEventDAO.addNewMedEvent(medEvent);
            if (medEvent.getStarts().toLocalDate().isEqual(LocalDate.now())) {
                jms.newMedEventMessage(MedEventEntityToRestDtoHelper.entityToDto(medEvent));
            }

        }

    }

}
