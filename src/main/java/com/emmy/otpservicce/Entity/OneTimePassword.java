package com.emmy.otpservicce.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class OneTimePassword {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NonNull
  private Long id;

  @NonNull
  private Integer otp;

  @NonNull
  private Date expiryDate;


}
