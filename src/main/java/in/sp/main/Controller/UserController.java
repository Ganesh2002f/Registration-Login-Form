package in.sp.main.Controller;

import in.sp.main.Entity.User;
import in.sp.main.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Display the registration form
    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    // Handle registration
    @PostMapping("/register")
    public String register(User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    // Display the login form
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // Redirect to home after login (Spring Security handles actual login)
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Home Page!");
        return "home"; // Renders home.html page
    }
}