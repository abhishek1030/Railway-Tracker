package com.railway.tracker.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.railway.tracker.model.Train;
import com.railway.tracker.model.TrainRequest;
import com.railway.tracker.model.TrainResponse;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/trainService")
public class TrainsServiceController {


    @GetMapping("/getTrainsBetweenStations")
    public ResponseEntity<List<Train>> getTrainsBetweenStations(@RequestBody TrainRequest trainRequest) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://irctc1.p.rapidapi.com/api/v3/trainBetweenStations?fromStationCode=pnbe&toStationCode=NDLS&dateOfJourney=2023-04-30"))
                .header("X-RapidAPI-Key", "56c205287emsh42cdac40ef4ced2p195110jsn17fddc1245d0")
                .header("X-RapidAPI-Host", "irctc1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TrainResponse trainsInfo = objectMapper.readValue(response.body(), TrainResponse.class);
        return null;
    }
}
