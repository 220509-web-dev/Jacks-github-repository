package dev.rosen.Model;

public class Users {
    public Object get;
    private int usersId;
    private String username;
    private String password;


    public Users(){

    }

    public Users(int usersid, String username, String password) {
        this.usersId = usersId;
        this.username = username;
        this.password = password;
    }

    public int getUsersId() {
        return usersId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

   
    }

    public void setUsersId(int userId) {
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getusername() {
    }

    public String getpassword() {
    }
}





}
