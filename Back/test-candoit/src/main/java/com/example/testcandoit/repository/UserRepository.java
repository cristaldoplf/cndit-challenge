package com.example.testcandoit.repository;

import com.example.testcandoit.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE email = ?1")
    Optional<User> findByEmail(String email);

//    @Query(value = "UPDATE user SET email = 1? WHERE id =2?",nativeQuery = true)
//    Optional<User> updateUser(String email,Integer id);

    boolean existsByEmail(String email);
}
