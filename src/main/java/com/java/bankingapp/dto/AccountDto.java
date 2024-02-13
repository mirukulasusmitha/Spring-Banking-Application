package com.java.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class AccountDto {

	private Long id;
	private String accountHolderName;
	private Double balance;

}
