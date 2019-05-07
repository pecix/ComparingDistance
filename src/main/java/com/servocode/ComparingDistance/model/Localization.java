package com.servocode.ComparingDistance.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Localization {

    private String name;
    private Coordinates coordinates;

}
