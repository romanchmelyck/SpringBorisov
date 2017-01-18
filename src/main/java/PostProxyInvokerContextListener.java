import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.applet.AppletContext;
import java.lang.reflect.Method;

/**
 * Created by Roman on 18.01.2017.
 */
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext ctx = event.getApplicationContext();
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            final BeanDefinition definition = factory.getBeanDefinition(name);
            final String originalClassName = definition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] methods = originalClass.getMethods();
                for (Method method : methods){
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        Object bean = ctx.getBean(name);
                        final Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                        currentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                System.out.println("Bean name : " + name);
                System.out.println(e);
            }
        }
    }
}
