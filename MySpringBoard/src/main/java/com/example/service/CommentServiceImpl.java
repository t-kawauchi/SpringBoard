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
	public boolean resister(int threadNumber,String message, String name) {
		CommentDataEntity cd=new CommentDataEntity(threadNumber,message,name);
		cdr.save(cd);
		cdr.flush();
		return false;
	}

	@Override
	public List<CommentDataEntity> getAllComment(int threadNumber) {
		List<CommentDataEntity> list =cdr.findAll();
		return list;
	}	
}
