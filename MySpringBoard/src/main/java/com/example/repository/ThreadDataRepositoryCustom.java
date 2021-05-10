package com.example.repository;

import java.util.List;

import com.example.entity.ThreadDataEntity;

public interface ThreadDataRepositoryCustom {
public List<ThreadDataEntity> search(String search);
}
