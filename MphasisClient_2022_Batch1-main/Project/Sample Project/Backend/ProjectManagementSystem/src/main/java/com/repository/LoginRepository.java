package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

	@Query("select ll from Login ll where ll.emailid = :emailid and ll.password = :password and typeofuser=:typeofuser")
public Login checkLoginDetails(@Param("emailid") String emailId, @Param("password") String pass,@Param("typeofuser") String typeOfUser);
	
}
