package br.com.tqi.creditanalysis.entities;

import java.util.Objects;

public class Installment {

    private Long id;

    private Double value;

    private String date;


    public Installment() {
    }

    public Installment(Long id, Double value, String date) {
        this.id = id;
        this.value = value;
        this.date = date;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Installment id(Long id) {
        setId(id);
        return this;
    }

    public Installment value(Double value) {
        setValue(value);
        return this;
    }

    public Installment date(String date) {
        setDate(date);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Installment)) {
            return false;
        }
        Installment installment = (Installment) o;
        return Objects.equals(id, installment.id) && Objects.equals(value, installment.value) && Objects.equals(date, installment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, date);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", value='" + getValue() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }


}
