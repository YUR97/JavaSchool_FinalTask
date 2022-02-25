package ru.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.example.demo.model.*;
import ru.example.demo.repo.*;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class MyApp {

    ClientRepository clientRepository;
    ContractRepository contractRepository;
    OptionRepository optionRepository;
    RoleRepository roleRepository;
    TariffRepository tariffRepository;

    @Autowired
    public MyApp(ClientRepository clientRepository, ContractRepository contractRepository,
                 OptionRepository optionRepository, RoleRepository roleRepository, TariffRepository tariffRepository) {
        this.clientRepository = clientRepository;
        this.contractRepository = contractRepository;
        this.optionRepository = optionRepository;
        this.roleRepository = roleRepository;
        this.tariffRepository = tariffRepository;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MyApp.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    @PostConstruct
    public void start() {
        List<Client> clients = clientRepository.findAll();
        List<Role> roles = roleRepository.findAll();
        List<Tariff> tariffs = tariffRepository.findAll();
        List<Option> options = optionRepository.findAll();
        List<Contract> contracts = contractRepository.findAll();

        System.out.println("-------------------------------------------");
        clients.forEach(System.out::println);
        System.out.println("-------------------------------------------");
        roles.forEach(System.out::println);
        System.out.println("-------------------------------------------");
        tariffs.forEach(System.out::println);
        System.out.println("-------------------------------------------");
        options.forEach(System.out::println);
        System.out.println("-------------------------------------------");
        contracts.forEach(System.out::println);
        System.out.println("-------------------------------------------");
    }

}
