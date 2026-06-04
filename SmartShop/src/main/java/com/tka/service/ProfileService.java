package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.repo.ProfileRepo;

@Service
public class ProfileService {

	@Autowired
	ProfileRepo profileRepo;
	
}
