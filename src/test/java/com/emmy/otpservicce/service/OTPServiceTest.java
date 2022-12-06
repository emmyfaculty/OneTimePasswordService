package com.emmy.otpservicce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.emmy.otpservicce.Entity.OneTimePassword;
import com.emmy.otpservicce.repository.OneTimePasswordRepository;
import java.sql.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OTPServiceTest {

	@Mock
	OneTimePasswordRepository oneTimePasswordRepository;

	@InjectMocks
	OTPService otpService;

	@Test
	@DisplayName("Should save the onetimepassword object in the database")
	void returnOneTimePasswordShouldSaveTheOneTimePasswordObjectInDatabase() {
		OneTimePassword oneTimePassword = new OneTimePassword();
		oneTimePassword.setOtp(123456);
		oneTimePassword.setExpiryDate(new Date(System.currentTimeMillis() + 5L * 60 * 1000));

		when(oneTimePasswordRepository.save(any())).thenReturn(oneTimePassword);

		assertEquals(oneTimePassword, otpService.returnOneTimePassword());
	}

	@Test
	@DisplayName("Should return a onetimepassword object with a random otp and an expiry date")
	void returnOneTimePasswordShouldReturnOneTimePasswordObjectWithRandomOTPAndExpiryDate() {
		OneTimePassword oneTimePassword = new OneTimePassword();
		oneTimePassword.setOtp(123456);
		oneTimePassword.setExpiryDate(new Date(System.currentTimeMillis() + 5L * 60 * 1000));

		when(oneTimePasswordRepository.save(any())).thenReturn(oneTimePassword);

		OneTimePassword result = otpService.returnOneTimePassword();

		assertEquals(oneTimePassword, result);
	}
}