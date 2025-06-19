package com.fitflow.fitflowbackend.controller;

import com.fitflow.fitflowbackend.entity.Routine;
import com.fitflow.fitflowbackend.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/routines")
@CrossOrigin(origins = "http://localhost:3000")
public class RoutineController {

    @Autowired
    private RoutineService routineService;

    @PostMapping
    public ResponseEntity<Routine> createRoutine(@RequestBody Routine routine, Principal principal) {
        Routine saved = routineService.createRoutine(routine, principal.getName());
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Routine>> getRoutines(Principal principal) {
        List<Routine> routines = routineService.getRoutinesByUserEmail(principal.getName());
        return ResponseEntity.ok(routines);
    }
}
