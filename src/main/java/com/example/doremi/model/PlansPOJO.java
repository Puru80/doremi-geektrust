package com.example.doremi.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlansPOJO {

    private String name;
    private int months;

}
