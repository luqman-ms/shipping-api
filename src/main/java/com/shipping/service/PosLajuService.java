package com.shipping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shipping.service.dto.CourierRateDto;
import com.shipping.service.implementation.PosLajuServiceImpl;

@Service
public class PosLajuService {

    @Autowired
    private PosLajuServiceImpl posLajuServiceImpl;

    @Cacheable("posLajuShippingRate")
    public CourierRateDto getShippingRate() {
        return posLajuServiceImpl.fetchData("https://www.pos.com.my/send/ratecalculator");
    }
}
