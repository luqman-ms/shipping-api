package com.shipping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shipping.service.dto.CourierRateDto;
import com.shipping.service.implementation.JntServiceImpl;

@Service
public class JntService {

    @Autowired
    private JntServiceImpl jntServiceImpl;
    
    @Cacheable("jntShippingRate")
    public CourierRateDto getShippingRate() {
        return jntServiceImpl.fetchData("https://www.jtexpress.my/shipping-rates");
    }
}
