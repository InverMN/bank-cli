package me.inver;

public class Client implements Model {
    private String name;
    private String surname;
    private String address;
    private final int id;

    private static int idCounter = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client(String name, String surname, String address) {
        this.id = Client.idCounter++;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
