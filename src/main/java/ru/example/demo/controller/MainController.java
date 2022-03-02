package ru.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.example.demo.model.Client;
import ru.example.demo.service.ClientService;

@Controller
public class MainController {

    private ClientService clientService;

    @Autowired
    public MainController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/home")
    public String hello(Authentication authentication, Model model) {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        Client client = clientService.getByEmail(user.getUsername());
        model.addAttribute("client", client);
        if (client.getRole().getName().contains("ADMIN")) {
            return "homeAdmin";
        } else {
            return "homeClient";
        }
    }

}
