package util;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import dao.AppointmentDAO;
import model.Appointment;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class ApiServer {

    public static void start() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/api/appointment", new AppointmentHandler());
            server.createContext("/api/appointments", new AllAppointmentsHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("Web service started on port 8080");
            System.out.println("  GET /api/appointment/{number}  - one appointment");
            System.out.println("  GET /api/appointments          - all appointments");
        } catch (IOException e) {
            System.out.println("Could not start web service: " + e.getMessage());
        }
    }

    static class AppointmentHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            String appointmentNumber = path.substring(path.lastIndexOf('/') + 1);

            AppointmentDAO dao = new AppointmentDAO();
            Appointment appointment = dao.getAppointmentByNumber(appointmentNumber);

            String response;
            int statusCode;

            if (appointment != null) {
                response = toJson(appointment);
                statusCode = 200;
            } else {
                response = "{\"error\":\"Appointment not found\"}";
                statusCode = 404;
            }

            sendJson(exchange, response, statusCode);
        }
    }

    static class AllAppointmentsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            AppointmentDAO dao = new AppointmentDAO();
            List<Appointment> appointments = dao.getAllAppointments();

            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < appointments.size(); i++) {
                json.append(toJson(appointments.get(i)));
                if (i < appointments.size() - 1) json.append(",");
            }
            json.append("]");

            sendJson(exchange, json.toString(), 200);
        }
    }

    private static String toJson(Appointment appointment) {
        return "{"
                + "\"appointmentNumber\":\"" + appointment.getAppointmentNumber() + "\","
                + "\"patientName\":\"" + appointment.getPatientName() + "\","
                + "\"dentistName\":\"" + appointment.getDentistName() + "\","
                + "\"treatmentType\":\"" + appointment.getTreatmentType() + "\","
                + "\"appointmentDate\":\"" + appointment.getAppointmentDate() + "\","
                + "\"appointmentTime\":\"" + appointment.getAppointmentTime() + "\""
                + "}";
    }

    private static void sendJson(HttpExchange exchange, String response, int statusCode) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}