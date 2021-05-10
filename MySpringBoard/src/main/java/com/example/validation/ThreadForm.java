package com.example.validation;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ThreadForm {
	@NotBlank
	String title;
	@NotBlank
	String message;
}
