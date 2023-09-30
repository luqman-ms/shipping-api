package com.shipping.service.implementation;

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
        return restTemplate.getForObject(url, CourierRateDto.class);
    }
}
