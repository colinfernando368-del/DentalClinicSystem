/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Bill {
    private String appointmentNumber;
    private double consultationFee;
    private double treatmentCost;
    private double totalCost;

    public Bill(String appointmentNumber, double consultationFee, double treatmentCost) {
        this.appointmentNumber = appointmentNumber;
        this.consultationFee = consultationFee;
        this.treatmentCost = treatmentCost;
        this.totalCost = consultationFee + treatmentCost;
    }

    public double getConsultationFee() { return consultationFee; }
    public double getTreatmentCost() { return treatmentCost; }
    public double getTotalCost() { return totalCost; }

    public String generateReceipt(Appointment appointment) {
        StringBuilder sb = new StringBuilder();
        sb.append("---- Sunrise Dental Clinic ----\n");
        sb.append("Appointment No: ").append(appointmentNumber).append("\n");
        sb.append("Patient: ").append(appointment.getPatientName()).append("\n");
        sb.append("Dentist: ").append(appointment.getDentistName()).append("\n");
        sb.append("Treatment: ").append(appointment.getTreatmentType()).append("\n");
        sb.append("Date: ").append(appointment.getAppointmentDate()).append(" ").append(appointment.getAppointmentTime()).append("\n");
        sb.append("--------------------------------\n");
        sb.append(String.format("Consultation Fee: Rs. %.2f%n", consultationFee));
        sb.append(String.format("Treatment Cost:   Rs. %.2f%n", treatmentCost));
        sb.append(String.format("TOTAL:            Rs. %.2f%n", totalCost));
        sb.append("--------------------------------\n");
        sb.append("Thank you for visiting!");
        return sb.toString();
    }
}