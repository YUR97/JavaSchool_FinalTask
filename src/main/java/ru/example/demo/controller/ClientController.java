package ru.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.demo.model.Client;
import ru.example.demo.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "viewOneClient";
    }

}
