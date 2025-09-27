package com.mizan.user_dashboard_api.controller;

import com.mizan.user_dashboard_api.entity.Project;
import com.mizan.user_dashboard_api.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/team/{teamId}")
    public ResponseEntity<Project> create(@PathVariable String teamId, @RequestBody Project project) {
        try {
            Project created = projectService.create(teamId, project);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(@PathVariable String id) {
        try {
            Project project = projectService.getById(id);
            return ResponseEntity.ok(project);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<Project>> getByTeam(@PathVariable String teamId) {
        List<Project> projects = projectService.getByTeamId(teamId);
        if (projects.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(projects);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable String id, @RequestBody Project project) {
        try {
            Project updated = projectService.update(id, project);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
