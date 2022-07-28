package com.datasetimdb.imdbDataset;

import javax.persistence.Column;
import javax.persistence.Id;

public class MovieDTO {
    private Long id;
    private String  title;
    private String director;
    private String stars;
    private float imdbRating;
    private String category;
    private String duration;
    private String censorBoardRating;
    private int releaseYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCensorBoardRating() {
        return censorBoardRating;
    }

    public void setCensorBoardRating(String censorBoardRating) {
        this.censorBoardRating = censorBoardRating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public MovieDTO() {
    }

    public MovieDTO(Long id, String title, String director, String stars, float imdbRating, String category, String duration, String censorBoardRating, int releaseYear) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.stars = stars;
        this.imdbRating = imdbRating;
        this.category = category;
        this.duration = duration;
        this.censorBoardRating = censorBoardRating;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", stars='" + stars + '\'' +
                ", imdbRating=" + imdbRating +
                ", category='" + category + '\'' +
                ", duration='" + duration + '\'' +
                ", censorBoardRating='" + censorBoardRating + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
