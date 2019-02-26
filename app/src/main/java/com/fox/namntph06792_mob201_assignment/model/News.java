package com.fox.namntph06792_mob201_assignment.model;

public class News {

    public String title;
    public String description;
    public String pubDate;
    public String link;
    public String imageLink;

    public News(String title, String description, String pubDate, String link) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
    }

    public News(String title,String imageLink){
        this.title = title;
        this.imageLink = imageLink;
    }

    public News(){}
}
