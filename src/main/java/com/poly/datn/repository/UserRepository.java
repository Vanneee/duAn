package com.poly.datn.repository;

import com.poly.datn.dto.ProductDto;
import com.poly.datn.dto.UserDto;
import com.poly.datn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("""
         from User where username = :u
    """)
    Optional<User> getByUser(@Param("u") String username);


    @Query(""" 
    from User where email = :u 
    """)
    Optional<User> getByEmail(@Param("u") String email);

    @Query("select new com.poly.datn.dto.UserDto(c) from User c where c.status = 'onKH' or c.status='offKH' order by c.Id DESC ")
    List<UserDto> getAll();


    @Query("select new com.poly.datn.dto.UserDto(c) from User c where c.status = :status   order by c.Id desc ")
    List<UserDto> tkStatus(String status);

}




