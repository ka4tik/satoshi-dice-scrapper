package com.satoshidice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiceResultRepository extends JpaRepository<Payload, Long> {

}
