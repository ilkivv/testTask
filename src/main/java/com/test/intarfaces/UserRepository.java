package com.test.intarfaces;

import com.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findDistinctByFullNameContainingOrCars_StateNumberContaining(String fullName, String stateNumber);

}
