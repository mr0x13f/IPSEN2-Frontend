package models;

public class User {

    private int UserId;
    private String email;
    private String name;
    private String password;
    private String salt;



    public User(int userId, String name, String email, String password, String salt) {
        this.UserId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.salt = salt;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
