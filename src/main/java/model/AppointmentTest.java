package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    void testGettersReturnCorrectValues() {
        Appointment appointment = new Appointment("APT001", "John Silva", "Colombo",
                "0771234567", "Dr. Perera", "Cleaning", "2026-07-21", "16:00");

        assertEquals("APT001", appointment.getAppointmentNumber());
        assertEquals("John Silva", appointment.getPatientName());
        assertEquals("Dr. Perera", appointment.getDentistName());
    }
}