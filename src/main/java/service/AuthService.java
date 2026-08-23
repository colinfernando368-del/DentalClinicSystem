package service;

import util.DBConnection;
import model.User;
import java.sql.*;

public class AuthService {

    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement ps = DBConnection.getInstance().prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getString("contact_number"));
            }
        } catch (SQLException e) {
            System.out.println("Login query failed: " + e.getMessage());
        }
        return null;
    }

    public boolean registerPatient(String username, String password, String contactNumber) {
        String checkSql = "SELECT * FROM users WHERE username = ?";
        String insertSql = "INSERT INTO users (username, password, role, contact_number) VALUES (?, ?, 'patient', ?)";

        try (PreparedStatement checkPs = DBConnection.getInstance().prepareStatement(checkSql)) {
            checkPs.setString(1, username);
            ResultSet rs = checkPs.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Check failed: " + e.getMessage());
            return false;
        }

        try (PreparedStatement insertPs = DBConnection.getInstance().prepareStatement(insertSql)) {
            insertPs.setString(1, username);
            insertPs.setString(2, password);
            insertPs.setString(3, contactNumber);
            int rows = insertPs.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
            return false;
        }
    }
}