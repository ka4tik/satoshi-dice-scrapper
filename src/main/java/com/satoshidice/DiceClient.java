package com.satoshidice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "dice-service-client", url = "https://satoshidice.com")
public interface DiceClient {

  @GetMapping("/api/game")
  Result getBetDetails(@RequestParam("id") long id);
}
