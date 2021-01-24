package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.*;
import com.jschool.reha.dto.AssignmentDto;
import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.dto.PatientDto;
import com.jschool.reha.dto.TreatmentDto;
import com.jschool.reha.dto.helpers.AssignmentEntityDtoHelper;
import com.jschool.reha.dto.helpers.PatientEntityDtoHelper;
import com.jschool.reha.dto.helpers.PatternEntityDtoHelper;
import com.jschool.reha.dto.helpers.TreatmentEntityDtoHelper;
import com.jschool.reha.entity.Assignment;
import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.entity.Patient;
import com.jschool.reha.entity.Treatment;
import com.jschool.reha.service.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
    PasswordEncoder passwordEncoder;

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
        assignmentEntity.setPattern(PatternEntityDtoHelper.dtoToEntity(assignmentDto.getPattern()));
        assignmentEntity.setTreatment(treatmentDAO.findTreatmentById(assignmentDto.getIdAssignment()));
        assignmentDAO.addNewAssignment(assignmentEntity);

        generateMedEvents(assignmentEntity);
    }

    public void generateMedEvents(Assignment assignment) {
        //TODO add medEvents generation from assignment
    }

    @Override
    public void addNewMedEvent(MedEventDto medEventDto) {
        MedEvent medEventEntity = new MedEvent();
        medEventEntity.setStarts(medEventDto.getStarts());
        medEventEntity.setAssignment(medEventDto.getAssignment());
        medEventEntity.setNurse(medEventDto.getNurse());
        medEventEntity.setPatient(medEventDto.getPatient());
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

}
