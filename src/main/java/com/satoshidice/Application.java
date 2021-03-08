package com.satoshidice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
@EnableFeignClients(basePackages = "com.satoshidice")

public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
