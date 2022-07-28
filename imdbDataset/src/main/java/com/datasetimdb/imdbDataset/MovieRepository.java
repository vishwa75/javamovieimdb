package com.datasetimdb.imdbDataset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieTable,Long> {

    @Query(value = "SELECT m.id,m.title,m.director,m.stars,m.category,m.duration,m.censor_board_rating,m.imdb_rating,m.release_year" +
            " FROM imdb_data_set m ORDER BY m.release_year limit 10"
            , nativeQuery = true)
    public List<MovieTable> getyearandcount();

    @Query(value = "SELECT * FROM imdb_data_set m WHERE m.release_year = :year", nativeQuery = true)
    public List<MovieTable> getmoviebyyear(int year);

    @Query(value = "select * from imdb_data_set order by rand() limit 1", nativeQuery = true)
    public MovieTable feel_lucky();
}
