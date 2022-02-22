package models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OPTIONS")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "payment")
    private String payment;
    @Column(name = "connection_price")
    private String connection_price;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TARIFS_OPTIONS",
            joinColumns = @JoinColumn(name = "id_option"),
            inverseJoinColumns = @JoinColumn(name = "id_tarif"))
    private Set<Tarif> tarifs;
    @ManyToMany(mappedBy = "options", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    public Option(){}

    public Option(String name, String payment, String connection_price) {
        this.name = name;
        this.payment = payment;
        this.connection_price = connection_price;
        tarifs = new HashSet<>();
        contracts = new HashSet<>();
    }

    public void addTarif(Tarif tarif){ tarifs.add(tarif); }
    public void removeTarif(Tarif tarif){
        tarifs.remove(tarif);
    }

    public void addContract(Contract contract){ contracts.add(contract); }
    public void removeContract(Contract contract){ contracts.remove(contract); }

    public void setContracts(Set<Contract> contracts) { this.contracts = contracts; }
    public void setTarifs(Set<Tarif> tarifs) {
        this.tarifs = tarifs;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public void setConnection_price(String connection_price) {
        this.connection_price = connection_price;
    }

    public Set<Contract> getContracts() { return contracts; }
    public Set<Tarif> getTarifs() {
        return tarifs;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPayment() {
        return payment;
    }
    public String getConnection_price() {
        return connection_price;
    }

}
