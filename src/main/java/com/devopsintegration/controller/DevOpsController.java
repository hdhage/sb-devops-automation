package com.devopsintegration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevOpsController {

    @GetMapping("/devops/message")
    public ResponseEntity<?> getEmployeeByID() {
        return new ResponseEntity<>("API call working well", HttpStatus.OK);
    }

}
