package com.shipping.service.implementation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shipping.service.dto.CourierRateDto;

@Service
public class PosLajuServiceImpl implements ApiClient {
    private final RestTemplate restTemplate;

    public PosLajuServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public CourierRateDto fetchData(String url) {
        return restTemplate.getForObject(url, CourierRateDto.class);
    }
}
