package br.com.tqi.creditanalysis.entities;

import java.util.List;
import java.util.Objects;

public class Client {
    
    private Long id;

    private String name;

    private String email;

    private String cpf;

    private String rg;

    private Double income;

    private String password;

    private Address address;

    private List<Loan> loans;


    public Client() {
    }

    public Client(Long id, String name, String email, String cpf, String rg, Double income, String password, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.income = income;
        this.password = password;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Double getIncome() {
        return this.income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Loan> getLoans() {
        return this.loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public Client id(Long id) {
        setId(id);
        return this;
    }

    public Client name(String name) {
        setName(name);
        return this;
    }

    public Client email(String email) {
        setEmail(email);
        return this;
    }

    public Client cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Client rg(String rg) {
        setRg(rg);
        return this;
    }

    public Client income(Double income) {
        setIncome(income);
        return this;
    }

    public Client password(String password) {
        setPassword(password);
        return this;
    }

    public Client address(Address address) {
        setAddress(address);
        return this;
    }

    public Client loans(List<Loan> loans) {
        setLoans(loans);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(email, client.email) && Objects.equals(cpf, client.cpf) && Objects.equals(rg, client.rg) && Objects.equals(income, client.income) && Objects.equals(password, client.password) && Objects.equals(address, client.address) && Objects.equals(loans, client.loans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, cpf, rg, income, password, address, loans);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", rg='" + getRg() + "'" +
            ", income='" + getIncome() + "'" +
            ", password='" + getPassword() + "'" +
            ", address='" + getAddress() + "'" +
            ", loans='" + getLoans() + "'" +
            "}";
    }

   
}
