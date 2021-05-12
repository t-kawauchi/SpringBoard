package com.example.service;

import java.util.List;

import com.example.entity.CommentDataEntity;

public interface CommentService {
	public boolean resister(int threadNumber,String message,String name);
	public List<CommentDataEntity> getAllComment(int threadNumber);
}
