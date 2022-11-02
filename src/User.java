

public class User {
    private String name;
    private String username;
    private String email;

//==============================================================================================================================
public User(String name, String username, String email) {
    this.name = name;
    this.username = username;
    this.email = email;
    }


//==============================================================================================================================
    public void showInfo() {
        System.out.println("Name: " + this.getName() + " -- User: " + this.getUserName() + " -- eMail: " + this.getEmail());
    }

//==============================================================================================================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }











}
