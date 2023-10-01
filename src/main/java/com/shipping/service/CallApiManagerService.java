package com.shipping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipping.service.dto.CourierRateDto;

@Service
public class CallApiManagerService {

    private static final Logger logger = LoggerFactory.getLogger(CallApiManagerService.class);

    @Autowired
    private JntService jntService;

    @Autowired
    private CityLinkService cityLinkService;

    @Autowired
    private PosLajuService posLajuService;

    public List<CourierRateDto> getAllAgencyShippingRate() throws InterruptedException, ExecutionException {

        logger.info("----getAllAgencyShippingRate----");

        // call api jnt task
        CompletableFuture<CourierRateDto> callJntApi = CompletableFuture
                .supplyAsync(() -> jntService.getShippingRate());

        // call api city link task
        CompletableFuture<CourierRateDto> callCityLinkApi = CompletableFuture
                .supplyAsync(() -> cityLinkService.getShippingRate());

        // call api pos laju task
        CompletableFuture<CourierRateDto> callPosLajuApi = CompletableFuture
                .supplyAsync(() -> posLajuService.getShippingRate());

        // combine the results with async api call
        CompletableFuture<List<CourierRateDto>> combinedFuture = CompletableFuture
                .allOf(callJntApi, callCityLinkApi, callPosLajuApi)
                .thenApplyAsync(voidResult -> {
                    List<CourierRateDto> combinedResult = new ArrayList<CourierRateDto>();
                    combinedResult.add(callJntApi.join());
                    combinedResult.add(callCityLinkApi.join());
                    combinedResult.add(callPosLajuApi.join());
                    return combinedResult;
                });

        return combinedFuture.get();
    }
}
