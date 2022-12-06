package com.emmy.otpservicce.repository;

import com.emmy.otpservicce.Entity.OneTimePassword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OneTimePasswordRepository extends JpaRepository<OneTimePassword, Long> {
}



