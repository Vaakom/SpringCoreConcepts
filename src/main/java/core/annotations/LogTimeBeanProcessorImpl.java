package core.annotations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class LogTimeBeanProcessorImpl implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if(beanClass.isAnnotationPresent(LogExecutionTime.class)) {
            System.out.println("Creating LogTimeProxy proxy for " + beanName);
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                long start = System.nanoTime();
                Object methodResult = method.invoke(bean, args);
                long end = System.nanoTime();
                System.out.println(beanName + "." + method.getName() + ": execution time = " + (end - start));

                return methodResult;
            });
        }

        return bean;
    }
}
