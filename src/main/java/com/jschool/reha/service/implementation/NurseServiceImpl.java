package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.MedStaffDAO;
import com.jschool.reha.entity.MedStaff;
import com.jschool.reha.service.interfaces.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class NurseServiceImpl implements NurseService {

    @Autowired
    MedStaffDAO medStaffDAO;

    @Override
    public MedStaff findNurseForEvent(LocalDateTime time) {
        List<MedStaff> nurses=medStaffDAO.getAllNurses();
        //TODO Possibly add working schdules and return nurse based on them
        return nurses.get(new Random(LocalTime.now().getSecond()).nextInt(nurses.size()));
    }
}
