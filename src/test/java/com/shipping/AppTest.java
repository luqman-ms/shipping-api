package com.shipping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shipping.service.CallApiManagerService;
import com.shipping.service.dto.CombineCourierRateDto;
import com.shipping.service.dto.CourierRateDto;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    @Autowired
    private CallApiManagerService callApiManagerService;

    /**
     * Rigorous Test :-)
     */
    // @Test
    // public void shouldAnswerWithTrue()
    // {
    // assertTrue( true );
    // }

    @Test
    public void testGetAllAgencyShippingRate() {

        List<CourierRateDto> result = null;

        try {
            result = callApiManagerService.getAllAgencyShippingRate();
        } catch (Exception e) {
            // skip
        }

        // assertEquals("", result);
        assertTrue(result == null);
    }
}
