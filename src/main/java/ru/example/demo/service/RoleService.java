package ru.example.demo.service;

import org.springframework.stereotype.Service;
import ru.example.demo.model.Role;
import ru.example.demo.repo.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleByName(String name){
        return roleRepository.findRoleByName(name);
    }

}
