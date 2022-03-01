package ru.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.demo.model.Client;
import ru.example.demo.service.ClientService;

import java.util.List;

@Controller
@RequestMapping
public class MainController {

    private ClientService clientService;

    @Autowired
    public MainController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String showAll(Model model) {
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "viewAll";
    }

    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "viewOne";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("client") Client client, @PathVariable("id") int id) {
        clientService.update(id, client);
        return "redirect:/clients";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("client") Client client) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
