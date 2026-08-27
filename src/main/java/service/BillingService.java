/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.HashMap;
import java.util.Map;

public class BillingService {
    private static final double CONSULTATION_FEE = 500.0;
    private static final Map<String, Double> TREATMENT_PRICES = new HashMap<>();

static {
        TREATMENT_PRICES.put("clean", 1500.0);
        TREATMENT_PRICES.put("cleaning", 1500.0); 
        TREATMENT_PRICES.put("filling", 3000.0);
        TREATMENT_PRICES.put("extraction", 4000.0);
        TREATMENT_PRICES.put("root canal", 8000.0);
        TREATMENT_PRICES.put("braces", 5000.0);   
        TREATMENT_PRICES.put("checkup", 500.0);
    }

    public double getTreatmentCost(String treatmentType) {
        return TREATMENT_PRICES.getOrDefault(treatmentType.trim().toLowerCase(), 1000.0);
    }

    public double getConsultationFee() {
        return CONSULTATION_FEE;
    }
}