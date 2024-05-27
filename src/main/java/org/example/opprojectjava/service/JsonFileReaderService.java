package org.example.opprojectjava.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.opprojectjava.entity.Dato;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JsonFileReaderService {

    public List<Map<String, Object>> readJsonFile(String fileName, String startDate, String endDate) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();


        InputStream inputStream = getClass().getResourceAsStream("/" + fileName);

        if (inputStream == null) {
            throw new IOException("File not found: " + fileName);
        }

//  return objectMapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>() {});

        Dato [] datos = deserializacionJsonFile(inputStream );
        datos = dateFilter(datos, startDate, endDate);
        String str = serializacionJsonString(datos);
        return objectMapper.readValue(str, new TypeReference<List<Map<String, Object>>>() {});

    }

    public Dato[] deserializacionJsonFile ( InputStream inputStream ) throws IOException {

        Dato [] datos;
        ObjectMapper mapper = new ObjectMapper();
        datos = mapper.readValue(inputStream, Dato[].class );
        return datos;

    }

    public String serializacionJsonString (Dato [] datos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(datos);

    }

    public Dato [] dateFilter(Dato [] datos, String start, String end){

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        ArrayList<Dato> list = new ArrayList<>();

        for (Dato dato : datos) {
            String date = dato.getTiempoReciboBgts();
            int index = date.indexOf(" ");
            date = date.substring(0, index);
            LocalDate localDate = LocalDate.parse(date);

            if ( (localDate.isEqual(startDate) || localDate.isEqual(endDate))|| (localDate.isBefore(endDate) && localDate.isAfter(startDate)))
                list.add(dato);
        }

        return list.toArray(new Dato[0]);
    }


}