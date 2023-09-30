package com.shipping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shipping.service.dto.CourierRateDto;
import com.shipping.service.implementation.CityLinkServiceImpl;

@Service
public class CityLinkService {

    @Autowired
    private CityLinkServiceImpl cityLinkServiceImpl;

    @Cacheable("cityLinkShippingRate")
    public CourierRateDto getShippingRate() {
        return cityLinkServiceImpl.fetchData("https://www.jtexpress.my/shipping-rates");
    }
}
