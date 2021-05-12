package com.example.validation;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class CommentForm {
@NotBlank
String message;
}
