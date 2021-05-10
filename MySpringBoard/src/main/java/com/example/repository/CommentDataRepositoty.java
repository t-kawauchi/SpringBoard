package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CommentDataEntity;

public interface CommentDataRepositoty extends JpaRepository<CommentDataEntity,Integer>{
	
}
