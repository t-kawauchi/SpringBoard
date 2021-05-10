package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ThreadDataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String name;
	private String message;
	public ThreadDataEntity() {
		
	}
	public ThreadDataEntity(String title, String name, String message) {
		this.title = title;
		this.name = name;
		this.message = message;
	}
}
