package watson.config;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import watson.web.WatsonController;

/**
 * Created by asus-pc on 05.11.2016.
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/img/").setCachePeriod(31556926);
    }

    @Bean
    public TextToSpeech textToSpeech() {
        TextToSpeech textToSpeech = new TextToSpeech();
        textToSpeech.setUsernameAndPassword("a7b636fc-1495-4652-ae6d-ae05eb502b72", "hkJZtUbtRZmg");
        //textToSpeech.setEndPoint("https://stream.watsonplatform.net/text-to-speech/api");
        return textToSpeech;
    }

}
