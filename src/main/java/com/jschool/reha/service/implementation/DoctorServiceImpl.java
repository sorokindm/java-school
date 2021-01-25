package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.*;
import com.jschool.reha.dto.AssignmentDto;
import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.dto.PatientDto;
import com.jschool.reha.dto.TreatmentDto;
import com.jschool.reha.dto.helpers.*;
import com.jschool.reha.entity.*;
import com.jschool.reha.enums.MedEventStatus;
import com.jschool.reha.service.helpers.MedEventCalendar;
import com.jschool.reha.service.interfaces.DoctorService;
import com.jschool.reha.service.interfaces.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    PatientDAO patientDAO;

    @Autowired
    MedStaffDAO medStaffDAO;

    @Autowired
    TreatmentDAO treatmentDAO;

    @Autowired
    AssignmentDAO assignmentDAO;

    @Autowired
    MedEventDAO medEventDAO;

    @Autowired
    PatternDAO patternDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MedEventCalendar medEventCalendar;

    @Autowired
    NurseService nurseService;

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

        Pattern pattern=patternDAO.addNewPattern(PatternEntityDtoHelper.dtoToEntity(assignmentDto.getPattern()));
        assignmentEntity.setPattern(pattern);
        assignmentDAO.addNewAssignment(assignmentEntity);

        generateMedEvents(assignmentEntity);
    }

    @Override
    public void generateMedEvents(Assignment assignment) {
        int counter=assignment.getQuantity();
        List<LocalDateTime> eventsTime=medEventCalendar.getTimeForEvents(counter,assignment.getPattern(),
                assignment.getAssignmentStartDate().atTime(LocalTime.of(0,0)));
        for (int i=0;i<counter;i++){
            MedEvent medEvent=new MedEvent();
            medEvent.setAssignment(assignment);
            medEvent.setStarts(eventsTime.get(i));
            medEvent.setStatus(MedEventStatus.SCHEDULED);
            medEvent.setPatient(assignment.getTreatment().getPatient());
            medEvent.setNurse(nurseService.findNurseForEvent(eventsTime.get(i)));

            medEventDAO.addNewMedEvent(medEvent);
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
    public void editTreatment(TreatmentDto treatmentDto) {
        Treatment treatment=treatmentDAO.findTreatmentById(treatmentDto.getIdTreatment());
        treatment.setDiagnosis(treatmentDto.getDiagnosis());
        treatment.setOpenedComments(treatmentDto.getOpenedComments());
        treatmentDAO.update(treatment);
    }

    @Override
    public void closeTreatment(TreatmentDto treatmentDto) {
        Treatment treatment=treatmentDAO.findTreatmentById(treatmentDto.getIdTreatment());
        treatment.setDiagnosis(treatmentDto.getDiagnosis());
        treatment.setOpenedComments(treatmentDto.getOpenedComments());
        treatment.setTreatmentClosed(LocalDate.now());
        treatment.setClosedComments(treatmentDto.getClosedComments());
        treatmentDAO.update(treatment);

        for(Assignment assignment:treatment.getAssignments()) {
            if (assignment.getAssignmentEndDate()==null) {
                assignment.setClosedComments("Treatment closed");
                assignment.setAssignmentEndDate(LocalDate.now());
                closeAssignment(AssignmentEntityDtoHelper.entityToDto(assignment));
            }
        }
    }

    @Override
    public void closeAssignment(AssignmentDto assignmentDto) {
        Assignment assignment=assignmentDAO.getAssignmentById(assignmentDto.getIdAssignment());
        assignment.setClosedComments(assignmentDto.getClosedComments());
        assignment.setAssignmentEndDate(assignmentDto.getAssignmentEndDate());
        assignmentDAO.update(assignment);

        for(MedEvent medEvent:assignment.getMedEvents()) {
             {
                medEvent.setClosedComments("Assignment closed");
                medEvent.setStatus(MedEventStatus.CANCELED);

                closeMedEvent(MedEventEntityDtoHelper.entityToDto(medEvent));
            }
        }
    }

    @Override
    public void closeMedEvent(MedEventDto medEventDto) {
        MedEvent medEvent=medEventDAO.getMedEventById(medEventDto.getIdMedEvent());
        if (medEvent.getStatus()==MedEventStatus.SCHEDULED||medEvent.getStatus()==MedEventStatus.PENDING) {
            medEvent.setStatus(medEventDto.getStatus());
            medEvent.setClosedComments(medEventDto.getClosedComments());

            medEventDAO.update(medEvent);
        }
    }


    @Override
    public List<MedEventDto> getAllMedEventsForAssignment(int assignmentId) {
        ArrayList<MedEventDto> medEventDtos=new ArrayList<>();
        List<MedEvent> medEvents=medEventDAO.getAllMedEventsForAssignment(assignmentId);
        for (MedEvent medEvent:medEvents) {
            medEventDtos.add(MedEventEntityDtoHelper.entityToDto(medEvent));
        }
        return medEventDtos;
    }

}
