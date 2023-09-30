package com.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipping.service.CallApiManagerService;

@RestController
@RequestMapping("/api") // Base path for this controller
public class CourierController {

    @Autowired
    private CallApiManagerService callApiManagerService;

    @GetMapping("/getShippingRate")
    public ResponseEntity<?> getShippingRate() {
        try {
            return ResponseEntity.ok(callApiManagerService.getAllAgencyShippingRate());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
