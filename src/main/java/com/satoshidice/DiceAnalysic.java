package com.satoshidice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiceAnalysic {


  @Autowired
  private DiceResultRepository diceResultRepository;

  @PostConstruct
  public void analyse() {

    int start = 163943;
    int count = 0;
    int valid = 0;
    Map<Integer, Integer> counts = new HashMap<>();
    for (int i = start; i < start + 1000000; i++) {
      Optional<Payload> roll = diceResultRepository.findById((long) i);
      if (roll.isPresent()) {
//        valid++;
        if (roll.get().roll != null && roll.get().roll < 32000) {
          count++;
        } else {
          valid++;
          counts.putIfAbsent(count, 0);
          counts.put(count, counts.get(count) + 1);
//          System.out.println(count);
          count = 0;
        }
      }
      if (i % 1000 == 0) {
        System.out.println(counts);
      }
    }
    System.out.println(valid);
  }
}
