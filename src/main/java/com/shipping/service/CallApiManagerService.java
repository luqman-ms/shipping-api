package com.shipping.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipping.service.dto.CombineCourierRateDto;
import com.shipping.service.dto.CourierRateDto;

@Service
public class CallApiManagerService {

    @Autowired
    private JntService jntService;

    @Autowired
    private CityLinkService cityLinkService;

    @Autowired
    private PosLajuService posLajuService;

    public CombineCourierRateDto getAllAgencyShippingRate() throws InterruptedException, ExecutionException {

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
        CompletableFuture<CombineCourierRateDto> combinedFuture = CompletableFuture
                .allOf(callJntApi, callCityLinkApi, callPosLajuApi)
                .thenApplyAsync(voidResult -> {
                    CombineCourierRateDto combinedResult = new CombineCourierRateDto();
                    combinedResult.setJntRate(callJntApi.join());
                    combinedResult.setCityLinkRate(callCityLinkApi.join());
                    combinedResult.setPosLajuRate(callPosLajuApi.join());
                    return combinedResult;
                });

        return combinedFuture.get(); 
    }
}
