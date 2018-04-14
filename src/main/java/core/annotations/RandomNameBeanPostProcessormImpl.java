package core.annotations;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class RandomNameBeanPostProcessormImpl implements BeanPostProcessor {
    private DataFactory dataFactory = new DataFactory();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for(Field field : fields){
            InjectRandomText randomText = field.getAnnotation(InjectRandomText.class);
            if(randomText != null){
                int minLength = randomText.minLength();
                int maxLength = randomText.maxLength();

                field.setAccessible(true);
                try {
                    field.set(bean, dataFactory.getRandomText(minLength, maxLength));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return bean;
    }
}
