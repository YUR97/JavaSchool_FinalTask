package ru.example.demo.repo;

import ru.example.demo.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository extends JpaRepository <Tariff, Integer>{
}