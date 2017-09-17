package user;

/**
 * Created by xavy_ on 9/16/2017.
 */

public class User {
    //Variables
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int phoneNumber;



    public User(String firstName, String lastName, String email, String password, int phonenumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phonenumber;
    }

    //Getters

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }



}
