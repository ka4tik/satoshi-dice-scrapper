package com.satoshidice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    ExecutorService executorService = Executors.newFixedThreadPool(30);

    long start = 2997619;
    start-=145000;
    int times = 1000000;
    for (int i = 0; i < times; i++) {
      long id = start - i;
      executorService.submit(() -> {
        if (!diceResultRepository.existsById(id)) {
          Result betDetails = diceClient.getBetDetails(id);
          if (betDetails.status == 200) {
            diceResultRepository.save(betDetails.payload);
          } else if (betDetails.status == 404) {
            betDetails.payload = Payload.builder().id(id).build();
            diceResultRepository.save(betDetails.payload);
          }
        }
      });
    }
    System.out.println("done");

  }
}
