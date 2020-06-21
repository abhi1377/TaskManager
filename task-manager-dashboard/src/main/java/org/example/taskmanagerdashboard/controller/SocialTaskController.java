package org.example.taskmanagerdashboard.controller;

import org.example.taskmanagerdashboard.model.SocialTask;
import org.example.taskmanagerdashboard.service.SocialTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SocialTaskController {
    private SocialTaskService socialTaskService;
    @Autowired
    public SocialTaskController(SocialTaskService socialTaskService) {
        this.socialTaskService = socialTaskService;
    }
    @GetMapping(value = {"/socialTasks"},produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SocialTask>> getAllSocialTasks()
    {
        return ResponseEntity.status(HttpStatus.OK).body(socialTaskService.findAllSocialTasks());
    }
    @GetMapping(value = "/socialTasks/{socialTaskId}",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<SocialTask>> getSocialTasksById(@PathVariable("socialTaskId") int Id){
        return ResponseEntity.status(HttpStatus.OK).body(socialTaskService.findSocialTaskById(Id));
    }
    @PostMapping("/socialTasks")
    public ResponseEntity<SocialTask> createSocialTask(@Valid @RequestBody SocialTask socialTask)
    {

        return ResponseEntity.status(HttpStatus.OK).body(socialTaskService.createAndUpdateSocialTask(socialTask));
    }
    @PutMapping("/socialTasks")
    public ResponseEntity<SocialTask> updateSocialTask(@Valid @RequestBody SocialTask socialTask)
    {
        return ResponseEntity.status(HttpStatus.OK).body(socialTaskService.createAndUpdateSocialTask(socialTask));
    }
    @DeleteMapping("/socialTasks")
    public ResponseEntity<String> deleteSocialTask(@RequestBody SocialTask socialTask)
    {
        socialTaskService.deleteSocialTask(socialTask);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }
    @DeleteMapping("/socialTasks/{taskId}")
    public ResponseEntity<String> deleteSocialTaskById(@PathVariable("taskId") int Id)
    {
        socialTaskService.deleteSocialTaskById(Id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }
}

