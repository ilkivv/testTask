package com.test.intarfaces;

import com.test.entities.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {

  //  List<Penalty> countByCars
}
