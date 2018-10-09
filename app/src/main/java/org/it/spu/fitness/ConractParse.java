package org.it.spu.fitness;


public class ConractParse {
    public String caption;
    public String country;
    private String indexCity;
    private String City;
    private String street;
    private String num_b;
    public String phone1;
    private String phine2;
    public String email;

    ConractParse(String caption,
                 String country,
                 String indexCity,
                 String City,
                 String street,
                 String num_b,
                 String phone1,
                 String phone2,
                 String email) {
        this.caption = caption;
        this.country = country;
        this.indexCity = indexCity;
        this.City = City;
        this.street = street;
        this.num_b = num_b;
        this.phone1 = phone1;
        this.phine2 = phone2;
        this.email = email;
    }

    public String getCaption() {
        return caption;
    }

    public String getCountry() {
        return country;
    }

    public String getIndexCity() {
        return indexCity;
    }

    public String getStreet() {
        return street;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhine2() {
        return phine2;
    }

    public String getNum_b() {
        return num_b;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNum_b(String num_b) {
        this.num_b = num_b;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public void setPhine2(String phine2) {
        this.phine2 = phine2;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return City;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIndexCity(String indexCity) {
        this.indexCity = indexCity;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        City = city;
    }

}
