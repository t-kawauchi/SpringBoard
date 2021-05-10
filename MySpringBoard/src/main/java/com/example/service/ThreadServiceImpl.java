package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ThreadDataEntity;
import com.example.repository.ThreadDataRepository;
import com.example.repository.ThreadDataRepositoryCustom;
import com.example.validation.ThreadForm;

@Service
public class ThreadServiceImpl implements ThreadService {
	@Autowired
	ThreadDataRepository tr;
	@Autowired
	ThreadDataRepositoryCustom trc;
	
	@Override
	public boolean resister(ThreadForm tf,String name) {
		try {
				ThreadDataEntity tde=new ThreadDataEntity(tf.getTitle(),name,tf.getMessage());
				tr.save(tde);
				tr.flush();
		}catch(Exception e) {
			return false;
		}
				return true;
	}

	@Override
	public List<ThreadDataEntity> getAllThread() {
		List<ThreadDataEntity> list = tr.findAll();
		return list;
	}

	@Override
	public List<ThreadDataEntity> search(String search) {
		List<ThreadDataEntity> list=trc.search(search);
		return list;
	}

}
