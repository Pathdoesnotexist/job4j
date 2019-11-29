package ru.job4j.stream;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = city.hashCode();
        result = prime * result + street.hashCode();
        result = prime * result + home;
        result = prime * result + apartment;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return  (this.city.equals(address.getCity()) && this.street.equals(address.getStreet())
                && this.home == address.getHome() && this.apartment == address.getApartment());
    }


    @Override
    public String toString() {
        return "Город: " + city + " Улица: " + street + " Дом: " + home + " Квартира: " + apartment;
    }
}