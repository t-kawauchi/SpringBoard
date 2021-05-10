package com.example.validation;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SearchForm {
	@NotBlank
	String search;
}
