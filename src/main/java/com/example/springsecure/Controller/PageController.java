package com.example.springsecure.Controller;

import com.example.springsecure.Model.Employee;
import com.example.springsecure.Repository.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private EmployeeRepository employeeRepository;
    private final SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();


    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin"; // Return the view name for the admin dashboard page
    }

    @GetMapping("/public")
    public String publicHome() {
        return "public"; // Return the view name for the public home page
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "error"; // Return the view name for the public home page
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/logout")
    String logout() {
        return "logout";
    }
    @GetMapping("/affectation")
    String affectation() {
        return "affectation";
    }

    @GetMapping("/list_employees")
    public String list(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "list_employees";
    }

    @PostMapping("/logout")
    public String performLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        logoutHandler.logout(request, response, authentication);
        return "redirect:/login"; // Redirect to home page or any other page after logout
    }
}
