package com.plannerapp.myplannerproject.web;

import com.plannerapp.myplannerproject.model.binding.OrderAddBindingModel;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import org.hibernate.metamodel.mapping.Bindable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {
    @GetMapping("/order")
    public String order(){
        return "order-add";

    }

    @PostMapping("/order")
    public String orderConfirm(@Valid OrderAddBindingModel orderAddBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("orderAddBindingModel",orderAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel",bindingResult);

            return "redirect:order";
        }

        return "redirect:/";
    }


    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel(){
        return new OrderAddBindingModel();
    }
}



