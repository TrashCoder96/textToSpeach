package watson.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import watson.comp.WatsonComponent;
import watson.web.WatsonController;

/**
 * Created by asus-pc on 05.11.2016.
 */

@Configuration
public class WebConfig {

    @Bean
    public WatsonComponent watsonComponent() {
        return new WatsonComponent();
    }

    @Bean
    public WatsonController watsonController() {
        return new WatsonController();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;
    }

}
