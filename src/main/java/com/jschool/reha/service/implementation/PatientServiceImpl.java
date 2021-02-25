package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.MedEventDAO;
import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.dto.helpers.MedEventEntityDtoHelper;
import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.service.interfaces.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger logger = LogManager.getLogger();

    MedEventDAO medEventDAO;

    public PatientServiceImpl(MedEventDAO medEventDAO) {
        this.medEventDAO = medEventDAO;
    }

    @Override
    public List<MedEventDto> getAllActiveMedEventsForGivenPatient(int patientId) {

        List<MedEvent> medEvents=medEventDAO.getAllMedEventsForPatient(patientId);
        ArrayList<MedEventDto> dtos=new ArrayList<>();
        for (MedEvent medEvent:medEvents) {
            dtos.add(MedEventEntityDtoHelper.entityToDto(medEvent));
        }
        return dtos;
    }
}
