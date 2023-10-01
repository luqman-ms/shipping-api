package com.shipping.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shipping.service.dto.CourierRateDto;
import com.shipping.service.implementation.PosLajuServiceImpl;

@Service
public class PosLajuService {

    private static final Logger logger = LoggerFactory.getLogger(PosLajuService.class);

    @Autowired
    private PosLajuServiceImpl posLajuServiceImpl;

    @Cacheable("posLajuShippingRate")
    public CourierRateDto getShippingRate() {

        logger.info("----getShippingRate----");

        CourierRateDto result = null;
        String url = "https://www.pos.com.my/send/ratecalculator";
        
        try{
            result = posLajuServiceImpl.fetchData(url);
        } catch (Exception e) {
            
            logger.error("Error fetch data from " + url);

            //dummy data
            result = new CourierRateDto();
            result.setCourierName("poslaju");
            result.setRate("10");
            
            logger.warn("Return dummy data");    
        }

        return result;
    }
}
