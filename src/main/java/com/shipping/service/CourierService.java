package com.shipping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipping.service.dto.CourierRate;
import com.shipping.service.implementation.CourierServiceImpl;

@Service
public class CourierService {

    @Autowired
    private CourierServiceImpl courierServiceImpl;

    public CourierRate getShippingRate(String requestParameter) {
        return courierServiceImpl.getShippingRate(requestParameter);
    }
}
