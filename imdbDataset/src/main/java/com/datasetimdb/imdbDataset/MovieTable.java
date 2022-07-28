package com.datasetimdb.imdbDataset;

import javax.persistence.*;

@Entity
@Table(name = "imdb_data_set")
public class MovieTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String  title;
    @Column(name = "director")
    private String director;
    @Column(name = "stars")
    private String stars;
    @Column(name = "imdb_rating")
    private float imdbRating;
    @Column(name = "category")
    private String category;
    @Column(name = "duration")
    private String duration;
    @Column(name = "censorBoardRating")
    private String censorBoardRating;
    @Column(name = "release_year")
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

    public MovieTable(Long id, String title, String director, String stars,
                      float imdbRating, String category, String duration,
                      String censorBoardRating, int releaseYear) {
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

    public MovieTable() {

    }

    @Override
    public String toString() {
        return "Movietable{" +
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
