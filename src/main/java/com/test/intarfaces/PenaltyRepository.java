package com.test.intarfaces;

import com.test.entities.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {

    @Query(nativeQuery = true, value = "SELECT pen.*, COUNT(cp.penalty_id) as count_penalty FROM `car_penalties` cp INNER JOIN `penalties` as pen WHERE pen.id = cp.penalty_id GROUP BY (cp.penalty_id) ORDER BY count_penalty DESC LIMIT 5")
    List<Penalty> rating();
}
