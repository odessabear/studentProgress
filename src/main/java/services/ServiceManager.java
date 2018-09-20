package services;

import database.DataService;

public class ServiceManager {

    static ServiceManager manager = new ServiceManager();

    DataService dataService = new DataService();

    private ServiceManager() {

    }

    public static ServiceManager getInstance() {
        return manager;
    }

    public void startALLServices() {
        dataService.init();
    }

}
