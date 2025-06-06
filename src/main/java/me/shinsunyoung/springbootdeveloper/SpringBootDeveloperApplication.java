package me.shinsunyoung.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootDeveloperApplication {
  public static void main(String[] args){
    SpringApplication.run(SpringBootDeveloperApplication.class, args);
  }
}
