package com.emmy.otpservicce.service;

import com.emmy.otpservicce.Entity.OneTimePassword;
import com.emmy.otpservicce.repository.OneTimePasswordRepository;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

  private final Long expiryInterval = 5L * 60 * 1000;

  OneTimePasswordRepository oneTimePasswordRepository;

  OTPHelperService oneTimePasswordHelpService;

  @Autowired
  public OTPService(OneTimePasswordRepository oneTimePasswordRepository) {
    this.oneTimePasswordRepository = oneTimePasswordRepository;
  }

  public OneTimePassword returnOneTimePassword() {
    OneTimePassword oneTimePassword = new OneTimePassword();

    oneTimePassword.setOtp(OTPHelperService.createRandomOneTimePassword().get());
    oneTimePassword.setExpiryDate(new Date(System.currentTimeMillis() + expiryInterval));

    oneTimePasswordRepository.save(oneTimePassword);

    return oneTimePassword;
  }

}
