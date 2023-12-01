package com.plannerapp.myplannerproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TermsAndConditionsController {
    @GetMapping("/terms-and-conditions")
    public String termsAndConditions(){

        return "terms-and-conditions";
    }
}
