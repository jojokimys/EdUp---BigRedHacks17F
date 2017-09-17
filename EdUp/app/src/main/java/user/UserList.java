package user;

/**
 * Created by xavy_ on 9/16/2017.
 */

import android.content.Context;
import android.widget.Toast;

import java.util.LinkedList;

public class UserList {

    private static LinkedList<User> userList = new LinkedList<User>();
    private static UserList singleton = new UserList();


    /**
     * Get instance of a singleton
     * @return
     */
    public static UserList getInstance() {
        return singleton;
    }


    /**
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param phonenumber
     * @return
     */
    public boolean addUser(String firstName, String lastName, String email, String password, int phonenumber) {

        for (int i = 0; i < userList.size(); i++) {
            if (email.equals(((User) userList.get(i)).getEmail())) {
                System.err.println("Sorry, this username is already taken.");
                return false;
            }
        }

        User user = new User(firstName, lastName, email, password, phonenumber);
        userList.add(user);

        return true;
    }

    public String displayUsernames() {
        String buffer = "";
        for (int i = 0; i < userList.size(); i++) {
            buffer += "\nUsername: " + ((User) userList.get(i)).getEmail();
        }
        return buffer;
    }

    public int getNumOfUsers() {
        return userList.size();
    }

    public User getUser(String email) {
        for (int i = 0; i < userList.size(); i++) {
            if (email.equals(((User) userList.get(i)).getEmail())) {
                return ((User) userList.get(i));
            }
        }
        return null;
    }

    public boolean login(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(((User) userList.get(i)).getEmail())) {
                if (password.equals(((User) userList.get(i)).getPassword())) {
                    System.out.println("Login successful!");
                    return true;
                } else {
                    System.err.println("Login failed.");
                    return false;
                }
            }
        }
        System.err.println("Login failed."); //Make sure to add this one too

         /*   //---Cannot set contemt
        Context context = getApplicationContext();
        CharSequence text = "LogIn Failed.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        */
        return false;
    }

}

