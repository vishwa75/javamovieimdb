package com.datasetimdb.imdbDataset;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public interface MovieService {
    List<MovieTable> getAllMovie();
    MovieTable getMovieById(long id);
    MovieTable updateMovieById(MovieDTO movieDTO, long id);

    List<MovieTable> getyearandcount();

    List<Movie2DTO> getmoviebyyear(int year);

    MovieTable feel_lucky();

//    List<MovieTable> getExcel();
 ByteArrayInputStream export (List<MovieTable> movieTables);


}
