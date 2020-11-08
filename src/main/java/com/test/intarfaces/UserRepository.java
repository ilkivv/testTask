package com.test.intarfaces;

import com.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findDistinctByFullNameContainingOrCars_StateNumberContaining(String fullName, String stateNumber);

}
