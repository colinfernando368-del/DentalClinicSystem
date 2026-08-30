/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BillTest {
    
 @Test
    void testTotalCostIsSumOfFeeAndTreatment() {
        Bill bill = new Bill("APT001", 500.0, 1500.0);
        assertEquals(2000.0, bill.getTotalCost());
    }
}
