package com.shipping.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shipping.service.dto.CourierRateDto;
import com.shipping.service.implementation.CityLinkServiceImpl;

@Service
public class CityLinkService {

    private static final Logger logger = LoggerFactory.getLogger(CityLinkService.class);

    @Autowired
    private CityLinkServiceImpl cityLinkServiceImpl;

    @Cacheable("cityLinkShippingRate")
    public CourierRateDto getShippingRate() {

        logger.info("----getShippingRate----");

        CourierRateDto result = null;
        String url = "https://www.citylinkexpress.com/calculator/";
        
        try{
            result = cityLinkServiceImpl.fetchData(url);
        } catch (Exception e) {

            logger.error("Error fetch data from " + url);

            //dummy data
            result = new CourierRateDto();
            result.setCourierName("citylink");
            result.setRate("10");
            
            logger.warn("Return dummy data");  
        }

        return result;
    }
}
