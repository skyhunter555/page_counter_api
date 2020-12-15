package ru.syntez.page.counter.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PageCounterApiMain {

    public static void main(String[] args) {
        SpringApplication.run(PageCounterApiMain.class, args);
    }
}
