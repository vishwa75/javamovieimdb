package com.datasetimdb.imdbDataset;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



@Service
public class MovieServiceImplementation implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImplementation(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieTable> getAllMovie() {

        return movieRepository.findAll();
    }

    @Override
    public MovieTable getMovieById(long id) {
        if (movieRepository.findById(id).isPresent()) {
            MovieTable movie = movieRepository.findById(id).get();
            return movie;
        } else {
            throw new RuntimeException(id + "not fount");
        }
    }

    @Override
    public MovieTable updateMovieById(MovieDTO movieDTO, long id) {
        if (movieRepository.findById(id).isPresent()) {
            MovieTable movie = movieRepository.findById(id).get();
            movie.setTitle(movieDTO.getTitle());
            movie.setDirector(movieDTO.getDirector());
            movie.setStars(movieDTO.getStars());
            movie.setImdbRating(movieDTO.getImdbRating());
            movie.setCategory(movieDTO.getCategory());
            movie.setDuration(movieDTO.getDuration());
            movie.setCensorBoardRating(movieDTO.getCensorBoardRating());
            movie.setReleaseYear(movie.getReleaseYear());
            return movieRepository.save(movie);
        } else {
            throw new RuntimeException(id + "not fount");
        }
    }

    @Override
    public List<MovieTable> getyearandcount() {
//        MovieTable yearcount = new MovieTable();
        return movieRepository.getyearandcount();
    }

    @Override
    public List<Movie2DTO> getmoviebyyear(int year) {
        List<MovieTable> movieTable = movieRepository.getmoviebyyear(year);


        List<Movie2DTO> movie = new ArrayList<>();
        System.out.println(movieTable);
        for (MovieTable mov : movieTable) {
            Movie2DTO movie2DTO = new Movie2DTO();
            movie2DTO.setId(mov.getId());
            movie2DTO.setTitle(mov.getTitle());
            movie.add(movie2DTO);
        }
//        for(Object[] movieTable: moviei )
        //        movieDTO.setId(movieTable.get(0).getId());
//        movieDTO.setTitle(movieTable.get(0).);
//        movieTable.forEach(l -> {
//           movieDTO.setId(); 
//        });
//            for(int i =0 ;i<=movieTable.forEach();)

        return movie;
    }

    @Override
    public MovieTable feel_lucky() {
        return movieRepository.feel_lucky();
    }

    @Override
    public ByteArrayInputStream export(List<MovieTable> movieTables) {
        System.out.println("working");
        String[] HEADERs = { "id","title","director","stars","imdbRating","category","duration","censorBoardRating","releaseYear"};
        //List<MovieTable> movieTables = movieRepository.findAll();

        try (Workbook wb = new XSSFWorkbook();) {
            System.out.println("sheetcreated***********");
            Sheet sheet1 = wb.createSheet("new sheet");;

            Row headerRow = sheet1.createRow(0);

            for (int i = 0; i < HEADERs.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(HEADERs[i]);
            }
            // Creating data rows for each contact
            for (int i = 0; i < movieTables.size(); i++) {
                Row dataRow = sheet1.createRow(i + 1);
                dataRow.createCell(0).setCellValue(movieTables.get(i).getId());
                dataRow.createCell(1).setCellValue(movieTables.get(i).getTitle());
                dataRow.createCell(2).setCellValue(movieTables.get(i).getDirector());
                dataRow.createCell(3).setCellValue(movieTables.get(i).getStars());
                dataRow.createCell(4).setCellValue(movieTables.get(i).getImdbRating());
                dataRow.createCell(5).setCellValue(movieTables.get(i).getCategory());
                dataRow.createCell(6).setCellValue(movieTables.get(i).getDuration());
                dataRow.createCell(7).setCellValue(movieTables.get(i).getCensorBoardRating());
                dataRow.createCell(8).setCellValue(movieTables.get(i).getReleaseYear());
            }

            // Making size of column auto resize to fit with data
            sheet1.autoSizeColumn(0);
            sheet1.autoSizeColumn(1);
            sheet1.autoSizeColumn(2);
            sheet1.autoSizeColumn(3);
            sheet1.autoSizeColumn(4);
            sheet1.autoSizeColumn(5);
            sheet1.autoSizeColumn(6);
            sheet1.autoSizeColumn(7);
            sheet1.autoSizeColumn(8);


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            wb.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (Exception e) {
            System.out.println("&&&&&&&&&&&&&&DOCATCH&&&&&&&&&&&&&");
            e.printStackTrace();
            return null;


        }

    }
}
