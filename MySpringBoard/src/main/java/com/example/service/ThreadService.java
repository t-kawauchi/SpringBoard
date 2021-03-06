package com.example.service;

import java.util.List;

import com.example.entity.ThreadDataEntity;
import com.example.validation.ThreadForm;


public interface ThreadService {
	public int resisterAndGetThreadNumber(ThreadForm tf,String name);
	public List<ThreadDataEntity> getAllThread();
	public List<ThreadDataEntity> search(String search);
}
