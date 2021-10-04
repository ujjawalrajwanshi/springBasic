package com.example.FirstMiniProject.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.FirstMiniProject.data.UserCred;

@Component
public interface Userdatabase extends CrudRepository<UserCred, String> {
	
	@Query(value="select password from User_Cred user where user.username = :username", nativeQuery=true)
	public String findByIdUserName(@Param("username") String UserName);
}
