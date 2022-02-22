package models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TARIFS")
public class Tarif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @ManyToMany(mappedBy = "tarifs", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Option> options;
    @OneToMany(mappedBy = "tarif", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contract> contracts;

    public Tarif(){}

    public Tarif(String name, String price) {
        this.name = name;
        this.price = price;
        options = new HashSet<>();
        contracts = new HashSet<>();
    }

    public void addOption(Option option){ options.add(option); }
    public void removeOption(Option option){
        options.remove(option);
    }

    public void addContract(Contract contract){
        contract.setTarif(this);
        contracts.add(contract);
    }
    public void removeContract(Contract contract){ contracts.remove(contract); }

    public void setContracts(Set<Contract> contracts) { this.contracts = contracts; }
    public void setOptions(Set<Option> options) {
        this.options = options;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public Set<Contract> getContracts() { return contracts; }
    public Set<Option> getOptions() {
        return options;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }

}
