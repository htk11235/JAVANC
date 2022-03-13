package model;

public class User {

    private int id_User;
    private int id_Role;
    private String user_Name;
    private String pass_Word;

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public int getId_Role() {
        return id_Role;
    }

    public void setId_Role(int id_Role) {
        this.id_Role = id_Role;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getPass_Word() {
        return pass_Word;
    }

    public void setPass_Word(String pass_Word) {
        this.pass_Word = pass_Word;
    }

}
