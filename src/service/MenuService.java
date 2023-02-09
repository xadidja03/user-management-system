package service;

import util.InputUtil;

public class MenuService {
    public int userSystem() {
        System.out.println("\n" + "============User Management Service==============" +
                "\n[1] Login" +
                "\n[2] Register" +
                "\n[3] Exit system"
        );
        return InputUtil.InputTypeInt("Enter the option: ");
    }

    public int userLoginSystem() {
        System.out.println("\n===============User Login Service================" +
                "\n[1] UserInfo" +
                "\n[2] ChangePassword" +
                "\n[3] Log out"
        );
        return InputUtil.InputTypeInt("Enter the option: ");
    }
}
