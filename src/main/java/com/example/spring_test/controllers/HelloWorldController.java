package com.example.spring_test.controllers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }
    @RequestMapping("/esp")
    public String spanish() {
        return "Hola Mundo";
    }

    @RequestMapping("/lucky")
    public String luckyYou(@RequestParam String param, @RequestParam(defaultValue = "ayy") String firstname, @RequestParam(defaultValue = "lmao") String lastname) {
        if (param == null) {
            return "Parametern är null";
        }
        String name = firstname + " " + lastname;
        if (param.equalsIgnoreCase("animal")) {
            return name + ", ditt lyckodjur är " + randomAnimal();
        } else if (param.equalsIgnoreCase("number")) {
            return name + ", ditt lyckonummer är " + randomNumber();
        } else {
            return "Parametern är fel, går bara med animal eller number";
        }
    }

    @RequestMapping("/luckyPath/{param}")
    public String luckyYouPath(@PathVariable String param) {
        if (param == null) {
            return "Parametern är null";
        }
        if (param.equalsIgnoreCase("animal")) {
            return "Ditt lyckodjur är " + randomAnimal();
        } else if (param.equalsIgnoreCase("number")) {
            return "Ditt lyckonummer är " + randomNumber();
        } else {
            return "Parametern är fel, går bara med animal eller number";
        }
    }
    @RequestMapping("/luckyHTML")
    public String luckyYouHTML(@RequestParam String param) {
        if (param == null) {
            return "Parametern är null";
        }
        if (param.equalsIgnoreCase("animal")) {
            return "<h1>Ditt lyckodjur är " + randomAnimal() + "</h1>";
        } else if (param.equalsIgnoreCase("number")) {
            return "<h1>Ditt lyckonummer är " + randomNumber() + "</h1>";
        } else {
            return "Parametern är fel, går bara med animal eller number";
        }
    }

    @RequestMapping("/list")
    public String unluckyYou(@RequestParam List<String> unlucky) {
        List<String> numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");
        numbers.add("9");
        numbers.add("10");

        numbers.removeIf(unlucky::contains);
        return "Dina möjliga tursnummer är " + numbers;
    }

    @RequestMapping(value = "/kompis", produces = "application/JSON")
    public Kompis oneKompisJSON() {
        return new Kompis(1, "Pål Pålsson", "Gatugatsvägen 1", "123-456 78 90");
    }

    public int randomNumber() {
        Random rand = new Random();
        return (rand.nextInt(10) + 1);
    }

    public String randomAnimal() {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Katt");
        animals.add("Hund");
        animals.add("Spindel");
        animals.add("Skata");
        Random random = new Random();
        return animals.get(random.nextInt(4));
    }
}