package model;

import java.time.LocalDateTime;

public class PawnshopContract {
    private int id;
    private int price;
    private LocalDateTime contractDate;
    private String note;
    private Customer customer;
    private Phone phone;
    private Laptop laptop;
    private Motorbike motorbike;

    public PawnshopContract(int id, int price, LocalDateTime contractDate, String note, Customer customer, Phone phone) {
        this.id = id;
        this.price = price;
        this.contractDate = contractDate;
        this.note = note;
        this.customer = customer;
        this.phone = phone;
    }

    public PawnshopContract(int id, int price, LocalDateTime contractDate, String note, Customer customer, Laptop laptop) {
        this.id = id;
        this.price = price;
        this.contractDate = contractDate;
        this.note = note;
        this.customer = customer;
        this.laptop = laptop;
    }

    public PawnshopContract(int id, int price, LocalDateTime contractDate, String note, Customer customer, Motorbike motorbike) {
        this.id = id;
        this.price = price;
        this.contractDate = contractDate;
        this.note = note;
        this.customer = customer;
        this.motorbike = motorbike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDateTime contractDate) {
        this.contractDate = contractDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Motorbike getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motorbike motorbike) {
        this.motorbike = motorbike;
    }

    @Override
    public String toString() {
        return "PawnshopContract{" +
                "id=" + id +
                ", price=" + price +
                ", contractDate=" + contractDate +
                ", note='" + note + '\'' +
                ", customer=" + customer +
                ", phone=" + phone +
                ", laptop=" + laptop.toString() +
                ", motorbike=" + motorbike +
                '}';
    }
}
