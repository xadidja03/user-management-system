package service;

public class ManagementService {
    public int userSystem() {
        UserService userService = new UserService();
        MenuService menuService = new MenuService();
        int option = menuService.userSystem();
        switch (option) {
            case 1:
                userLoginSystem(menuService.userLoginSystem());
                break;
            case 2:
                userService.register();
                break;
            case 3:
                System.exit(-1);
            default:
                System.err.println("Invalid option!");
        }

        return 0;
    }

    public int userLoginSystem(int option) {
        UserService userService = new UserService();
        ManagementService managementService = new ManagementService();
        switch (option) {
            case 1:
                userService.getUser();
                break;
            case 2:
                userService.changePassword();
                break;
            case 3:
                managementService.userSystem();
                break;
            default:
                System.err.println("Invalid option!\n");
        }
        return 0;
    }
}
