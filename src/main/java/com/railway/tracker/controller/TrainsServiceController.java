package com.railway.tracker.controller;


import com.railway.tracker.model.Train;
import com.railway.tracker.model.TrainRequest;
import com.railway.tracker.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/trainService")
public class TrainsServiceController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/getTrainsBetweenStations")
    public ResponseEntity<List<Train>> getTrainsBetweenStations(@RequestBody TrainRequest trainRequest) throws IOException, InterruptedException {
        return new ResponseEntity<>(trainService.getTrainBetweenStations(trainRequest), HttpStatus.OK);
    }
}
