package util;

import util.DBConnection;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();
        if (conn != null) {
            System.out.println("SUCCESS: connection object created.");
        } else {
            System.out.println("FAILED: connection is null.");
        }
    }
}