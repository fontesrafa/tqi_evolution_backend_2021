package br.com.tqi.creditanalysis.entities;

import java.util.List;
import java.util.Objects;

public class Loan {

    private Long id;

    private Double amount;

    private Client client;

    List<Installment> installments;


    public Loan() {
    }

    public Loan(Long id, Double amount, Client client, List<Installment> installments) {
        this.id = id;
        this.amount = amount;
        this.client = client;
        this.installments = installments;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Installment> getInstallments() {
        return this.installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }

    public Loan id(Long id) {
        setId(id);
        return this;
    }

    public Loan amount(Double amount) {
        setAmount(amount);
        return this;
    }

    public Loan client(Client client) {
        setClient(client);
        return this;
    }

    public Loan installments(List<Installment> installments) {
        setInstallments(installments);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Loan)) {
            return false;
        }
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id) && Objects.equals(amount, loan.amount) && Objects.equals(client, loan.client) && Objects.equals(installments, loan.installments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, client, installments);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", amount='" + getAmount() + "'" +
            ", client='" + getClient() + "'" +
            ", installments='" + getInstallments() + "'" +
            "}";
    }

}
