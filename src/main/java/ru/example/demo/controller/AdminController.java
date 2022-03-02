package ru.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.demo.model.Client;
import ru.example.demo.model.Role;
import ru.example.demo.service.ClientService;
import ru.example.demo.service.RoleService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private ClientService clientService;
    private RoleService roleService;

    @Autowired
    public AdminController(ClientService clientService, RoleService roleService) {
        this.clientService = clientService;
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "viewAll";
    }

    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "viewOneAdmin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "editAdmin";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("client") Client client, @PathVariable("id") int id) {
        clientService.update(id, client);
        return "redirect:/admin/all";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("client") Client client) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("client") Client client, @RequestParam(name = "role_name") String role) {
        Role newRole = roleService.getRoleByName(role);
        client.setRole(newRole);
        clientService.save(client);
        return "redirect:/admin/all";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        clientService.delete(id);
        return "redirect:/admin/all";
    }
}
