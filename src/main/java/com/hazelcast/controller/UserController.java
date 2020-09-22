package com.hazelcast.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hazelcast.model.User;
import com.hazelcast.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1")
@Api(tags = "User Controller")
public class UserController {
	
	@Autowired
	private UserService service;
    
    @ApiOperation(value = "Find user", notes = "Find user applying path parameter", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 200, message = "User search request successfully executed", response = User.class),
			@ApiResponse(code = 404, message = "The request resource was not found") })
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
    	return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Find user by id", notes = "Find user applying path parameter", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 200, message = "User search request successfully executed", response = User.class),
			@ApiResponse(code = 404, message = "The request resource was not found") })
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "The id to be searched. ", allowableValues = "range[1, infinity]", required = true, dataType = "long", paramType = "path", example = "1"),
    })
    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
    	return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
    
    
    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody @Valid User user, UriComponentsBuilder uri) {
    	user = service.save(user);
    	
    	return ResponseEntity.created(
    			uri.path("/users/{id}").buildAndExpand(user.getId()).toUri()).body(user);
    }
    
    @PutMapping("/users/{id}")
    public User create(@PathVariable Long id, @RequestBody @Valid User user) {
    	
    	return service.update(id, user);
    }
    
}
