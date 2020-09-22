package com.hazelcast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazelcast.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
