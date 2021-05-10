package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CommentDataEntity;
import com.example.repository.CommentDataRepositoty;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDataRepositoty cdr;

	@Override
	public boolean resister() {
		
		return false;
	}

	@Override
	public List<CommentDataEntity> getAllComment() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
