package com.shipping.service.implementation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shipping.service.dto.CourierRateDto;

@Service
public class JntServiceImpl implements ApiClient {
    private final RestTemplate restTemplate;

    public JntServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public CourierRateDto fetchData(String url) {
        return restTemplate.getForObject(url, CourierRateDto.class);
    }
}
