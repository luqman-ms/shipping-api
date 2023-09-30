package com.shipping.service.dto;

import lombok.Data;

@Data
public class CombineCourierRateDto {

    private CourierRateDto jntRate;
    private CourierRateDto cityLinkRate;
    private CourierRateDto posLajuRate;
}
