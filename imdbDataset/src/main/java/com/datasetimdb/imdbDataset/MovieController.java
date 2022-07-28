package com.datasetimdb.imdbDataset;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/allmovie")
    public List<MovieTable> getAllMovie() {
        return movieService.getAllMovie();
    }

    @GetMapping("/moviebyid/{id}")
    private ResponseEntity<MovieTable> getMovieById(@PathVariable("id") long id) {
        return new ResponseEntity<MovieTable>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @PutMapping("/updatemoviebyid/{id}")
    public ResponseEntity<MovieTable> updateMovieById(@PathVariable("id") long id, @RequestBody MovieDTO movieDTO) {
        return new ResponseEntity<MovieTable>(movieService.updateMovieById(movieDTO, id), HttpStatus.OK);
    }

    @GetMapping("/yearandcount")
    public List<MovieTable> getyearandcount() {
        return movieService.getyearandcount();
    }

    @GetMapping("/moviebyyear/{year}")
    public List<Movie2DTO> getmoviebyyear(@PathVariable("year") int year) {
        return movieService.getmoviebyyear(year);
    }

    @GetMapping("iamfeellucky")
    public ResponseEntity<MovieTable> feel_lucky() {
        return new ResponseEntity<MovieTable>(movieService.feel_lucky(), HttpStatus.OK);
    }

    @GetMapping("/downloadExcelFile")
    public void downloadExcelFile(HttpServletResponse response) throws IOException {
        List<MovieTable> movieTables = movieRepository.findAll();
        ByteArrayInputStream byteArrayInputStream = movieService.export(movieTables);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=imdb.xls");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }
}
