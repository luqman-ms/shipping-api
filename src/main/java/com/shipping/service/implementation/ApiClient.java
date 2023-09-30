package com.shipping.service.implementation;

import com.shipping.service.dto.CourierRateDto;

public interface ApiClient {
    CourierRateDto fetchData(String url);
}
