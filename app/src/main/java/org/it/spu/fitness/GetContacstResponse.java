package org.it.spu.fitness;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetContacstResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("caption")
        @Expose
        private String caption;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("indexCity")
        @Expose
        private String indexCity;
        @SerializedName("street")
        @Expose
        private String street;
        @SerializedName("building")
        @Expose
        private String building;
        @SerializedName("contacts")
        @Expose
        private List<Contact> contacts = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getIndexCity() {
            return indexCity;
        }

        public void setIndexCity(String indexCity) {
            this.indexCity = indexCity;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public List<Contact> getContacts() {
            return contacts;
        }

        public void setContacts(List<Contact> contacts) {
            this.contacts = contacts;
        }

    }

    public class ContactType {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public class Contact {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("contactType")
        @Expose
        private ContactType contactType;
        @SerializedName("data")
        @Expose
        private String data;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public ContactType getContactType() {
            return contactType;
        }

        public void setContactType(ContactType contactType) {
            this.contactType = contactType;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

    }
}
