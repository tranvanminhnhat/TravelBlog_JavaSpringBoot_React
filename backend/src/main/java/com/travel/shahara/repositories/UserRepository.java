package com.travel.shahara.repositories;

import com.travel.shahara.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUsersByUsername(String username);
}
