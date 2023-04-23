package com.railway.tracker.model;

import lombok.Data;

import java.util.List;

@Data
public class TrainResponse {

    private String status;
    private String message;
    private String timestamp;
    private List<Train> data;
}
