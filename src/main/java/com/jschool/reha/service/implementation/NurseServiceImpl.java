package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.MedEventDAO;
import com.jschool.reha.dao.interfaces.MedStaffDAO;
import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.dto.helpers.MedEventEntityDtoHelper;
import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.entity.MedStaff;
import com.jschool.reha.service.interfaces.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class NurseServiceImpl implements NurseService {

    @Autowired
    MedStaffDAO medStaffDAO;

    @Autowired
    MedEventDAO medEventDAO;

    @Override
    public MedStaff findNurseForEvent(LocalDateTime time) {
        List<MedStaff> nurses = medStaffDAO.getAllNurses();
        //TODO Possibly add working schdules and return nurse based on them
        return nurses.get(new Random(LocalTime.now().getSecond()).nextInt(nurses.size()));
    }

    @Override
    public List<MedEventDto> findMedEventsForNurse(int idMedStaff) {
        List<MedEvent> medEvents = medStaffDAO.findMedStaffById(idMedStaff).getMedEventsList();
        ArrayList<MedEventDto> dtos = new ArrayList<>();
        for (MedEvent medEvent : medEvents) {

            dtos.add(MedEventEntityDtoHelper.entityToDto(medEvent));
        }
        return dtos;
    }

    @Override
    public MedEventDto getMedEventById(int idMedEvent) {
        return MedEventEntityDtoHelper.entityToDto(medEventDAO.getMedEventById(idMedEvent));
    }
}
