package watson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by asus-pc on 05.11.2016.
 */

@SpringBootApplication
@ComponentScan(basePackages = "watson.config")
public class WatsonApp extends SpringBootServletInitializer {

    private static ApplicationContext ctx;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WatsonApp.class);
    }

    public static void main(String[] args) {
        ctx = SpringApplication.run(WatsonApp.class, args);
    }

    public static ApplicationContext getCtx() {
        return ctx;
    }


}
