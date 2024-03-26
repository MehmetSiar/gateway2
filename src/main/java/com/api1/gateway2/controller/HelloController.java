package com.api1.gateway2.controller;

import com.api1.gateway2.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/ismet")
    public String getKasarIsmet(@RequestHeader("name") String name, @RequestHeader("surname") String surname) {
        return name + ":" + surname;
    }

    @GetMapping("/ismet2")
    public String getKasarIsmet2(@RequestBody User user , @RequestHeader(value = "userName" , required = false) String userName  , @RequestHeader(value = "password",required = false) String password) {
        return user.getName() + ":" + user.getSurname().concat(userName + ": " + password);
    }

    @GetMapping("/umut")
    public String getKasarUmur() {
        return "Umut";
    }
}
