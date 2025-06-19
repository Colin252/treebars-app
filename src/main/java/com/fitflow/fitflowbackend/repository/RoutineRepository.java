package com.fitflow.fitflowbackend.repository;

import com.fitflow.fitflowbackend.entity.Routine;
import com.fitflow.fitflowbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findByUser(User user);
}
