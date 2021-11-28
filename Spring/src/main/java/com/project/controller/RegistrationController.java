package com.project.controller;

import com.project.model.credential.RegistrationForm;
import com.project.model.credential.User;
import com.project.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
@Slf4j
public class RegistrationController {
  private final UserService userService;

  @Autowired
  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<?> registration(@RequestBody RegistrationForm form){
    User user = userService.regNewUserFromRegistrationForm(form);
    log.info(user.toString());
    return ResponseEntity.ok(user);

  }
}
