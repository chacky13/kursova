package com.example.kursova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActionController {
    @GetMapping
    public String getRole(){
        return "get-role";
    }
    @GetMapping("/get-action")
    public String getAction(){return "get-action";}
    @GetMapping("/get-actionstud")
    public String getActionStud(){return "get-actionstud";}
}