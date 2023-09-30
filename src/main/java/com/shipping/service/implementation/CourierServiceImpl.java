package com.shipping.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shipping.repository.CourierRepository;
import com.shipping.service.dto.CourierRate;

@Service
public class CourierServiceImpl {

    @Autowired
    private CourierRepository courierRepository;

    @Cacheable("courierRate")
    public CourierRate getShippingRate(String requestParameter) {
        // Retrieve data from the database using the repository
        return new CourierRate(); //repository.findByRequestParameter(requestParameter);
    }
}
