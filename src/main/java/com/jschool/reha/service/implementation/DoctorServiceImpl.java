package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.*;
import com.jschool.reha.dto.*;
import com.jschool.reha.entity.Assignment;
import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.entity.Treatment;
import com.jschool.reha.enums.MedEventStatus;
import com.jschool.reha.service.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        treatmentEntity.setPatient(patientDAO.getPatientById(1));
        treatmentEntity.setDoctor(medStaffDAO.getMedStaffById(2));
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
        assignmentEntity.setPattern(assignmentDto.getPattern());
        assignmentEntity.setTreatment(treatmentDAO.findTreatmentById(1));
        assignmentDAO.addNewAssignment(assignmentEntity);

        MedEventDto medEventDto = new MedEventDto();
        medEventDto.setPatient(patientDAO.getPatientById(1));
        medEventDto.setAssignment(assignmentDAO.getAssignmentById(assignmentEntity.getIdAssignment()));
        medEventDto.setNurse(medStaffDAO.getMedStaffById(2));
        medEventDto.setStatus(MedEventStatus.PENDING);
        medEventDto.setStarts(LocalDateTime.now());

        addNewMedEvent(medEventDto);
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

}
