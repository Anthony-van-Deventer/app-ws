package van.deventer.anthony.tutorial.appws;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

//lyk vir my soos spring bean maak en bere in sy application context
//so al wat die method sal doen is met daai applicationCOntext praat em vra vir die registered bean
//hoekom doen ons dit so? well dit lyk soos beans net in ander beans in inject kan word
public class SpringApplicationContext implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;

    public void setApplicationContext(ApplicationContext context){
        CONTEXT=context;
    }

    public static Object getBean(String beanName){
        return CONTEXT.getBean(beanName);
    }
}
