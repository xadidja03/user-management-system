package service;

import global.GlobalData;
import model.User;
import util.InputUtil;


public class UserService implements service.impl.UserService {

    public User fillUser() {
        String username = InputUtil.InputTypeString("Enter the username: ");
        String password = InputUtil.InputTypeString("Enter the password: ");
        String mail = InputUtil.InputTypeString("Enter the mail: ");


        User user = new User(username,password,mail);
        user.setPassword(password);
        return user;
    }

    @Override
    public boolean register() {
        int count = InputUtil.InputTypeInt("How many user do you registered: ");
        if (GlobalData.users != null) {
            User[] tempUser = GlobalData.users;
            GlobalData.users = new User[count + tempUser.length];

            for (int i = 0, k = 0; i < GlobalData.users.length; i++) {
                if (tempUser.length>i) {
                    GlobalData.users[i] = tempUser[i];
                }
                else {
                    System.out.println("-----------------------");
                    System.out.println(k++ + ". User");
                    GlobalData.users[i] = fillUser();
                    System.out.println("-----------------------");
                }
            }
        }
        else {
            GlobalData.users = new User[count];

            for (int i = 0; i < count; i++) {
                System.out.println("-----------------------");
                System.out.println(i+1 + ". User");
                GlobalData.users[i] = fillUser();
                System.out.println("-----------------------");
            }
            System.out.println("Registered is successfully!");
            System.out.println("Total users: " + GlobalData.users.length);
        }
        return false;
    }

    @Override
    public void getUser() {
        if (GlobalData.users == null) {
            System.err.println("Warning: User list is empty! \n");
        }
        else {
            for (int i = 0; i < GlobalData.users.length; i++) {
                System.out.println("-----------------------");
                System.out.println(i+1 + ". User");
                System.out.println(GlobalData.users[i]);
                System.out.println("-----------------------");
            }
        }
    }

    @Override
    public boolean changePassword() {
        User user = new User();

        String oldPassword = InputUtil.InputTypeString("Enter the old password: ");

        for (int i = 0; i < GlobalData.users.length; i++) {
            if (GlobalData.users[i].getPassword().equals(oldPassword)) {
                String newPassword = InputUtil.InputTypeString("Enter the new password: ");
                user.setPassword(newPassword);
                System.out.println("\nPassword changed successfully");
            }
        }

        return true;
    }
}
