package ru.example.demo.model.DTO;

import java.util.HashSet;
import java.util.Set;

public class TariffDTO {

    private String name;
    private String payment;
    private Set<OptionDTO> optionsDTO;


    public TariffDTO() {
        optionsDTO = new HashSet<>();
    }

    public TariffDTO(String name, String payment) {
        this.name = name;
        this.payment = payment;
        optionsDTO = new HashSet<>();
    }

    public void addOptionDTO(OptionDTO optionDTO){
        optionsDTO.add(optionDTO);
    }

    public void removeOptionDTO(OptionDTO optionDTO){
        optionsDTO.remove(optionDTO);
    }

    public String getName() {
        return name;
    }

    public String getPayment() {
        return payment;
    }

    public Set<OptionDTO> getOptionsDTO() {
        return optionsDTO;
    }

    public void setOptionsDTO(Set<OptionDTO> optionsDTO) {
        this.optionsDTO = optionsDTO;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

}
