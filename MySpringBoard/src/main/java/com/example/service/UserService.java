package com.example.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public boolean register();
	public boolean auth();
}
