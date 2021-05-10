package com.example.validation;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class NameForm {
	@NotBlank
	String name;
}
