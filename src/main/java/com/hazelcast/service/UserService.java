package com.hazelcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hazelcast.enumarations.ExceptionEnum;
import com.hazelcast.exception.ErrorResponseException;
import com.hazelcast.exception.Response;
import com.hazelcast.model.User;
import com.hazelcast.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Cacheable("users")
	public List<User> findAll() {
		
		return repository.findAll();
	}
	
	@Cacheable("users")
	public User findById(Long id) {
		
		return repository.findById(id).orElseThrow(() -> new ErrorResponseException(
				Response.builder()
				.code(ExceptionEnum.NOT_FOUND.getId())
				.description(ExceptionEnum.NOT_FOUND.getDescription())
				.message(ExceptionEnum.NOT_FOUND.getDescription()).build(),
		HttpStatus.NOT_FOUND));
	}
	
	@CacheEvict(value = "users", allEntries = true)
	public User save(User user) {
		return repository.save(user);
	}
	
	@CachePut(value = "users")
	public User update(Long id, User user) {
		user.setId(id);
		return repository.save(user);
	}

}
