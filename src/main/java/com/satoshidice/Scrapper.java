package com.satoshidice;

import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Scrapper {

  private final DiceClient diceClient;

  private final DiceResultRepository diceResultRepository;


  @PostConstruct
  public void run() {
    long start = 2997619;
    int times = 1000;
    for (int i = 0; i < times; i++) {
      long id = start - i;
      if (diceResultRepository.findById(id).isEmpty()) {
        Result betDetails = diceClient.getBetDetails(id);
        if (betDetails.status == 200) {
          diceResultRepository.save(betDetails.payload);
        }
      }
    }

  }
}
