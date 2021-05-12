package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CommentDataEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int threadNumber;
private String message;
private String name;

public CommentDataEntity(){}
public CommentDataEntity(int threadNumber,String message,String name) {
	this.threadNumber=threadNumber;
	this.message=message;
	this.name=name;
}
}
