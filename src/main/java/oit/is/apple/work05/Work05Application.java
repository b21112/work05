package oit.is.apple.work05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Work05Application {

  public static void main(String[] args) {
    SpringApplication.run(Work05Application.class, args);
  }

}
