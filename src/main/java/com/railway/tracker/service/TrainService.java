package com.railway.tracker.service;

import com.railway.tracker.model.Train;
import com.railway.tracker.model.TrainRequest;
import java.io.IOException;
import java.util.List;

public interface TrainService {

    List<Train> getTrainBetweenStations(TrainRequest trainRequest) throws IOException, InterruptedException;
}
