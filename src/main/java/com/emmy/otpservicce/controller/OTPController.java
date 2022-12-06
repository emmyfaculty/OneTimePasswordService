package com.emmy.otpservicce.controller;

import com.emmy.otpservicce.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/otp")
public class OTPController {


  private final OTPService otpService;
  @Autowired
  public OTPController(OTPService otpService) {
    this.otpService = otpService;
  }


  @GetMapping("/create")
  @ResponseBody
  private Object getOneTimePassword() {
    try {
      return ResponseEntity.ok(otpService.returnOneTimePassword());
    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST);
    }
  }
}
