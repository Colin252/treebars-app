package com.fitflow.fitflowbackend.service;

import com.fitflow.fitflowbackend.entity.Routine;
import com.fitflow.fitflowbackend.entity.User;
import com.fitflow.fitflowbackend.repository.RoutineRepository;
import com.fitflow.fitflowbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private UserRepository userRepository;

    public Routine createRoutine(Routine routine, String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        routine.setUser(user);
        return routineRepository.save(routine);
    }

    public List<Routine> getRoutinesByUserEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return routineRepository.findByUser(user);
    }
}
