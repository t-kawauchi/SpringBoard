package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ThreadDataEntity;
@Repository
public interface ThreadDataRepository  extends JpaRepository<ThreadDataEntity, Integer>{

}
