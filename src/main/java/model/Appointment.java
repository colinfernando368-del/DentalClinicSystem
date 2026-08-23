package model;

public class Appointment {
    private String appointmentNumber;
    private String patientName;
    private String address;
    private String contactNumber;
    private String dentistName;
    private String treatmentType;
    private String appointmentDate;
    private String appointmentTime;

    public Appointment(String appointmentNumber, String patientName, String address,
                        String contactNumber, String dentistName, String treatmentType,
                        String appointmentDate, String appointmentTime) {
        this.appointmentNumber = appointmentNumber;
        this.patientName = patientName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.dentistName = dentistName;
        this.treatmentType = treatmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentNumber() { return appointmentNumber; }
    public String getPatientName() { return patientName; }
    public String getAddress() { return address; }
    public String getContactNumber() { return contactNumber; }
    public String getDentistName() { return dentistName; }
    public String getTreatmentType() { return treatmentType; }
    public String getAppointmentDate() { return appointmentDate; }
    public String getAppointmentTime() { return appointmentTime; }
}