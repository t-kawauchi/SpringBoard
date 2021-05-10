package com.example.service;

import java.util.List;

import com.example.entity.CommentDataEntity;

public interface CommentService {
	public boolean resister();
	public List<CommentDataEntity> getAllComment();
}
