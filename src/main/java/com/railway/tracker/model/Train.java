package com.railway.tracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Train {

    private int train_number;
    private String train_name;
    private String from;
    private String to;
    private String from_station_name;
    private String to_station_name;
    private boolean isSpecial;
    private String train_date;
    private String train_type;
}
