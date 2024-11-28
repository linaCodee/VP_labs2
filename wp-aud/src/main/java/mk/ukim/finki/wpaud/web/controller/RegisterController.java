package mk.ukim.finki.wpaud.web.controller;

import mk.ukim.finki.wpaud.model.exception.InvalidArgumentException;
import mk.ukim.finki.wpaud.model.exception.InvalidUserCredentialsException;
import mk.ukim.finki.wpaud.model.exception.PasswordsDoNotMatchException;
import mk.ukim.finki.wpaud.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping
    public String getRegister(@RequestParam(required = false) String error, Model model){
        if (error!=null && !error.isEmpty()){
            model.addAttribute("hasErrors",true);
            model.addAttribute("error",error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           @RequestParam String name,
                           @RequestParam String surname){
        try {
            this.authService.register(username, password, repeatPassword, name, surname);
            return "redirect:/login";
        } catch (PasswordsDoNotMatchException | InvalidArgumentException err){
            return "redirect:/register?error="+err.getMessage();
        }
    }
}
