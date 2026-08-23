package model;

public class User {
    private String username;
    private String password;
    private String role;
    private String contactNumber;

    public User(String username, String password, String role, String contactNumber) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.contactNumber = contactNumber;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getContactNumber() { return contactNumber; }
}