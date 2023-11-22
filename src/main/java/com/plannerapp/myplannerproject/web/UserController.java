package com.plannerapp.myplannerproject.web;


import com.plannerapp.myplannerproject.model.binding.UserLoginBindingModel;
import com.plannerapp.myplannerproject.model.binding.UserRegisterBindingModel;
import com.plannerapp.myplannerproject.model.service.UserServiceModel;
import com.plannerapp.myplannerproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }


    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {


            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);


            return "redirect:register";


        }

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }


    @GetMapping("/login")
    public String login(Model model) {
         if(!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "login";

    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService.findByUserNameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }

        httpSession.setAttribute("user", userServiceModel);

        return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();

        return "redirect:/";
    }


    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }


    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }
}

