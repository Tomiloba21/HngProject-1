package dev.lobzter.hngproject1.controller;


import dev.lobzter.hngproject1.entity.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class GetController {
    private final WebClient webClient = WebClient.builder().baseUrl("http://numbersapi.com/").build();

    @GetMapping("/classify-number")
    @ResponseStatus(HttpStatus.OK)
    public Model getApi(@RequestParam int number){

        Model model = new Model(number);
        model.setNumber(number);
        model.setIs_prime(number);
        model.setDigit_sum(number);
        model.setFun_fact(webClient
                .get()
                .uri(number + "" + "/math")
                .retrieve()
                .bodyToMono(String.class)
                .block()
        );

        return model;

    }



    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> badRequest(){
        return Map.of(
                "number", "alphabet",
                "error", true
        );
    }
}
