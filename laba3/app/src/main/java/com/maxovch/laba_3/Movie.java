package com.maxovch.laba_3;

public class Movie {
    private int poster;
    private String name;
    private String country;
    private double rating;
    private String description;
    private String genre;

    public Movie(int poster, String name, String country, double rating, String description,
                 String genre) {
        this.poster = poster;
        this.name = name;
        this.country = country;
        this.rating = rating;
        this.description = description;
        this.genre = genre;
    }

    public int getPoster() {
        return poster;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }
}
