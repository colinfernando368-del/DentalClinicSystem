package dao;

import model.Appointment;
import util.DBConnection;
import java.sql.*;

public class AppointmentDAO {

    public boolean addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (appointment_number, patient_name, address, "
                + "contact_number, dentist_name, treatment_type, appointment_date, appointment_time) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = DBConnection.getInstance().prepareStatement(sql)) {
            ps.setString(1, appointment.getAppointmentNumber());
            ps.setString(2, appointment.getPatientName());
            ps.setString(3, appointment.getAddress());
            ps.setString(4, appointment.getContactNumber());
            ps.setString(5, appointment.getDentistName());
            ps.setString(6, appointment.getTreatmentType());
            ps.setString(7, appointment.getAppointmentDate());
            ps.setString(8, appointment.getAppointmentTime());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
            return false;
        }
    }
    
    public Appointment getLatestAppointmentByContact(String contactNumber) {
    String sql = "SELECT * FROM appointments WHERE contact_number = ? ORDER BY appointment_date DESC, appointment_time DESC LIMIT 1";
    try (PreparedStatement ps = DBConnection.getInstance().prepareStatement(sql)) {
        ps.setString(1, contactNumber);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Appointment(
                rs.getString("appointment_number"),
                rs.getString("patient_name"),
                rs.getString("address"),
                rs.getString("contact_number"),
                rs.getString("dentist_name"),
                rs.getString("treatment_type"),
                rs.getString("appointment_date"),
                rs.getString("appointment_time")
            );
        }
    } catch (SQLException e) {
        System.out.println("Search failed: " + e.getMessage());
    }
    return null;
}

    public Appointment getAppointmentByNumber(String appointmentNumber) {
        String sql = "SELECT * FROM appointments WHERE appointment_number = ?";
        try (PreparedStatement ps = DBConnection.getInstance().prepareStatement(sql)) {
            ps.setString(1, appointmentNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Appointment(
                    rs.getString("appointment_number"),
                    rs.getString("patient_name"),
                    rs.getString("address"),
                    rs.getString("contact_number"),
                    rs.getString("dentist_name"),
                    rs.getString("treatment_type"),
                    rs.getString("appointment_date"),
                    rs.getString("appointment_time")
                );
            }
        } catch (SQLException e) {
            System.out.println("Search failed: " + e.getMessage());
        }
        return null;
    }
    
    public java.util.List<Appointment> getAllAppointments() {
    java.util.List<Appointment> appointments = new java.util.ArrayList<>();
    String sql = "SELECT * FROM appointments";
    try (PreparedStatement ps = DBConnection.getInstance().prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            appointments.add(new Appointment(
                rs.getString("appointment_number"),
                rs.getString("patient_name"),
                rs.getString("address"),
                rs.getString("contact_number"),
                rs.getString("dentist_name"),
                rs.getString("treatment_type"),
                rs.getString("appointment_date"),
                rs.getString("appointment_time")
            ));
        }
    } catch (SQLException e) {
        System.out.println("Fetch all failed: " + e.getMessage());
    }
    return appointments;
}
}