package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.ThreadDataEntity;

@Repository
public class ThreadDataRepositoryCustomImpl implements ThreadDataRepositoryCustom {
	@Autowired
	EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ThreadDataEntity> search(String search) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM THREAD_DATA_ENTITY WHERE title LIKE ? ORDER BY id DESC");
		Query query = manager.createNativeQuery(sql.toString(), ThreadDataEntity.class);
		query.setParameter(1, "%" + search + "%");

		return query.getResultList();
	}

}
