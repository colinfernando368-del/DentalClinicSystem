package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BillingServiceTest {

    private BillingService billingService = new BillingService();

    @Test
    void testCleaningCost() {
        assertEquals(1500.0, billingService.getTreatmentCost("Cleaning"));
    }

    @Test
    void testFillingCostIsCaseInsensitive() {
        assertEquals(3000.0, billingService.getTreatmentCost("FILLING"));
    }

    @Test
    void testUnknownTreatmentUsesDefaultFee() {
        assertEquals(1000.0, billingService.getTreatmentCost("Whitening"));
    }

    @Test
    void testConsultationFeeIsFixed() {
        assertEquals(500.0, billingService.getConsultationFee());
    }
    
    @Test
void testBracesCost() {
    assertEquals(5000.0, billingService.getTreatmentCost("Braces"));
}
}