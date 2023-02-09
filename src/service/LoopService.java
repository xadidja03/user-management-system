package service;

public class LoopService {
    public static boolean ManagementLoopService() {
        ManagementService managementService = new ManagementService();
        while (true) {
            managementService.userSystem();
        }
    }
}
