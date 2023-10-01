package com.shipping.service.implementation;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.shipping.service.dto.CourierRateDto;

@Component
public class CityLinkServiceImpl implements ApiClient {
    private final RestTemplate restTemplate;

    public CityLinkServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public CourierRateDto fetchData(String url) {
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        
        CourierRateDto result = new CourierRateDto();
        result.setCourierName((String) response.get("courierName"));
        result.setRate((String) response.get("rate"));
        return result;
    }
}
