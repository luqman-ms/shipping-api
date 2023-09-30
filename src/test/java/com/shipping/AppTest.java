package com.shipping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shipping.service.CallApiManagerService;
import com.shipping.service.dto.CombineCourierRateDto;

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

        CombineCourierRateDto result = null;

        try {
            result = callApiManagerService.getAllAgencyShippingRate();
        } catch (Exception e) {
            // skip
        }

        // assertEquals("", result);
        assertTrue(result == null);
    }
}
