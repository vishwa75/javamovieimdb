package com.datasetimdb.imdbDataset;

public class Movie2DTO {
    private Long id;
    private String title;

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

    public Movie2DTO() {
    }

    public Movie2DTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
