//package com.datasetimdb.imdbDataset;
//
////import com.ibm.icu.impl.Row;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//public class Excelhelper {
//    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//    static String[] HEADERs = { "id","title","director","stars","imdbRating","category","duration"
//    ,"censorBoardRating","releaseYear"};
//    static String SHEET = "imdblist";
//
//    public static ByteArrayInputStream tutorialsToExcel(List<MovieTable> movieTables) {
//
//        try (Workbook workbook = new XSSFWorkbook();
//             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
//            Sheet sheet = workbook.createSheet(SHEET);
//
//            // Header
//            Row headerRow = (Row) sheet.createRow(0);
//
//            for (int col = 0; col < HEADERs.length; col++) {
//                Cell cell = headerRow.createCell(col);
//                cell.setCellValue(HEADERs[col]);
//            }
//
//            int rowIdx = 1;
//            for (MovieTable movtbl : movieTables) {
//                Row row = sheet.createRow(rowIdx++);
//
//                //row.createCell(0).setCellValue(tutorial.getId());
//                //row.createCell(1).setCellValue(tutorial.getTitle());
//                //row.createCell(2).setCellValue(tutorial.getDescription());
//                //row.createCell(3).setCellValue(tutorial.isPublished());
//
//                row.createCell(0).setCellValue(movtbl.getId());
//                row.createCell(1).setCellValue(movtbl.getTitle());
//                row.createCell(2).setCellValue(movtbl.getDirector());
//                row.createCell(3).setCellValue(movtbl.getStars());
//                row.createCell(4).setCellValue(movtbl.getImdbRating());
//                row.createCell(5).setCellValue(movtbl.getCategory());
//                row.createCell(6).setCellValue(movtbl.getDuration());
//                row.createCell(7).setCellValue(movtbl.getCensorBoardRating());
//                row.createCell(8).setCellValue(movtbl.getReleaseYear());
//            }
//
//            workbook.write(out);
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (IOException e) {
//            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
//        }
//    }
//}
//
