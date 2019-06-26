package ru.example.democlient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DemoClientApplication {

    public static void main(String[] args){

        View view = new View();
        view.setGui();
        view.start();

    }
}

