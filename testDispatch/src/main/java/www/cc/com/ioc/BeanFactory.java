/**
 * @author Administrator
 * @data 2018年12月12日下午4:30:56
 */
package www.cc.com.ioc;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * 
 * @author lc
 * @data 2018年12月12日下午4:30:56
 */
public class BeanFactory {
    //用于存储 bean 的单体实例
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>();
    //用于存储 BeanDefinition 
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
     
    //注册 beanDefinition
    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
    
    //获取 bean ,如果不存在则创建
    public Object getBean(String beanName) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Object bean = getSingleton(beanName);
        if (bean == null) {
            bean = doCreateBean(beanName,beanDefinitionMap.get(beanName));
        }
        return bean;
        
    }

    /**
     * @param beanName
     * @param beanDefinition
     * @return
     * Object
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     */
    private Object doCreateBean(final String beanName, final BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    /**
     * @param bean
     * @param beanDefinition
     * void
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        if (propertyValues != null) {
            for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                field.set(bean, propertyValue.getValue());
                
                
                
            }
        }
        
    }

    /**
     * @param beanDefinition
     * @return
     * Object
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    private Object createBeanInstance(final BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
        Object bean;
        bean = beanDefinition.getBeanClass().newInstance();
        return bean;
    }

    /**
     * 获取单体实例 bean
     * @param beanName
     * @return
     * Object
     */
    private Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
    
    
}
