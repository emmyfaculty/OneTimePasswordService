package com.emmy.otpservicce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OTPHelperServiceTest {

	@Test
	@DisplayName("Should return a random number with length 6")
	void createRandomOneTimePasswordShouldReturnRandomNumberWithLength6() {
		Supplier<Integer> randomNumber = OTPHelperService.createRandomOneTimePassword();
		Integer result = randomNumber.get();
		assertEquals(6, result.toString().length());
	}
}