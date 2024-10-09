package com.railway.tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainResponse {

    private String status;
    private String message;
    private String timestamp;
    private List<Train> data;
}
