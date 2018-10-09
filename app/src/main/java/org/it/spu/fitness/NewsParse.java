package org.it.spu.fitness;

public class NewsParse {
    public String title;
    public String date;
    public String description;
    private String url_photo;

    NewsParse(String title, String date, String description, String url_photo) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.url_photo = url_photo;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }
}
