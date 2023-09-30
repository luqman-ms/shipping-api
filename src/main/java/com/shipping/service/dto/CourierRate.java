package com.shipping.service.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CourierRate {

    private Integer courierName;
    private String rate;
    private Date modifiedDate;
}
