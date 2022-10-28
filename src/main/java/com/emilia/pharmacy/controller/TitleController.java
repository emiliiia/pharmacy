package com.emilia.pharmacy.controller;
/*
  @author emilia
  @project pharmacy
  @className TitleController
  @version 1.0.0
  @since 29.06.2022
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class TitleController {

    @GetMapping("/home")
    public String titleOfWork() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/static/home.html")));
    }

   @RequestMapping("/login")
    public String login() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/static/login.html")));
    }

    @GetMapping("/titleOfWork")
    public String docOfWork() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/static/index.html")));
    }

}
