package com.jschool.reha.service;

import com.jschool.reha.dao.*;
import com.jschool.reha.entity.*;
import com.jschool.reha.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void addNewPatient(Patient patient) {
        patient.getUser().setEnabled(true);
        patient.getUser().setCreateTime(LocalDateTime.now());
        patient.getUser().setRole(Role.ROLE_PATIENT);
        userDAO.addNewUser(patient.getUser());
        patientDAO.addNewPatient(patient);
    }

    @Override
    public void addNewTreatment(Treatment treatment) {
        treatment.setTreatmentOpened(LocalDate.now());
        treatment.setPatient(patientDAO.getPatientById(1));
        treatment.setDoctor(medStaffDAO.getMedStaffById(2));
        treatmentDAO.addNewTreatment(treatment);
    }

    @Override
    public void addNewAssignment(Assignment assignment) {
        assignment.setAssignmentStartDate(LocalDate.now());
        assignment.setDosage("1 pill");
        assignment.setName("Happy pills");
        assignment.setTreatment(treatmentDAO.getTreatmentById(1));
        assignmentDAO.addNewAssignment(assignment);

        MedEvent medEvent = new MedEvent();
        medEvent.setPatient(patientDAO.getPatientById(1));
        medEvent.setAssignment(assignmentDAO.getAssignmentById(assignment.getIdAssignment()));
        medEvent.setNurse(medStaffDAO.getMedStaffById(2));
        medEvent.setStatus(MedEventStatus.PENDING);
        medEvent.setStarts(LocalDateTime.now());

        addNewMedEvent(medEvent);
    }

    @Override
    public void addNewMedEvent(MedEvent medEvent) {
        medEventDAO.addNewMedEvent(medEvent);
    }

}
