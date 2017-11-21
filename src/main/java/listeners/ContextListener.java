package listeners;


import services.ServiceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServiceManager serviceManager = ServiceManager.getInstance();
        serviceManager.startALLServices();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
