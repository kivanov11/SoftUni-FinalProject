package com.plannerapp.myplannerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorRightsController {
    @GetMapping("/author-rights")
    public String authorRights(){

        return "author-rights";
    }
}

