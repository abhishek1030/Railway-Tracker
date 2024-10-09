package com.railway.tracker.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.railway.tracker.model.Train;
import com.railway.tracker.model.TrainRequest;
import com.railway.tracker.model.TrainResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class TrainServiceImpl implements  TrainService{

    @Value("${api_url}")
    private String api_url;

    @Value("${api_host}")
    private String api_host;

    @Value("${api_key}")
    private String api_key;

    @Override
    public List<Train> getTrainBetweenStations(TrainRequest trainRequest) throws IOException, InterruptedException {
        String apiURL=api_url.concat("fromStationCode=").concat(trainRequest.getFromStation())
                .concat("&toStationCode=").concat(trainRequest.getToStation())
                .concat("&dateOfJourney=").concat(trainRequest.getDate());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiURL))
                .header("X-RapidAPI-Key",  api_key)
                .header("X-RapidAPI-Host", api_host)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TrainResponse trainsInfo = objectMapper.readValue(response.body(), TrainResponse.class);

        return trainsInfo.getData();
    }
}
