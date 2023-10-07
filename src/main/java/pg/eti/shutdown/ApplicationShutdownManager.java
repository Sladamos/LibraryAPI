package pg.eti.shutdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationShutdownManager {

    private final ApplicationContext appContext;

    @Autowired
    public ApplicationShutdownManager(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    public void initiateShutdown(int returnCode){
        SpringApplication.exit(appContext, () -> returnCode);
    }
}
