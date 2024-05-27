package org.example.opprojectjava.controller;

import org.example.opprojectjava.service.JsonFileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class JsonFileController {

    @Autowired
    private JsonFileReaderService jsonFileReaderService;





    /*

        https://spring.io/guides/gs/rest-service-cors#global-cors-configuration
        this website will help you configure @CrossOrigin at controller level or global

     */

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/json/{fileName}")
    public ResponseEntity<List<Map<String, Object>>> getJsonFile(@PathVariable String fileName, @RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin) {

//        fechaInicio = "2024-04-08";
//        fechaFin = "2024-04-20";

        try {

            List<Map<String, Object>> jsonData = jsonFileReaderService.readJsonFile(fileName, fechaInicio, fechaFin);
            return ResponseEntity.ok(jsonData);

        } catch (IOException e) {
            return ResponseEntity.status(500).body(List.of(Map.of("error", "File not found or cannot be read")));
        }
    }


}