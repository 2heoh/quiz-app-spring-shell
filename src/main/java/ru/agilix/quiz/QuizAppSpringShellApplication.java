package ru.agilix.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.agilix.quiz.configs.AppConfig;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class QuizAppSpringShellApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizAppSpringShellApplication.class, args);
    }

}
