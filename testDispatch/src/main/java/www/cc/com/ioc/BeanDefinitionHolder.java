/**
 * @author Administrator
 * @data 2018年12月12日下午4:26:25
 */
package www.cc.com.ioc;

/**
 * 
 * @author lc
 * @data 2018年12月12日下午4:26:25
 */
public class BeanDefinitionHolder {
    private final BeanDefinition beanDefinition;
    private final String beanName;
    
    public BeanDefinitionHolder(BeanDefinition beanDefinition, String beanName) {
        this.beanDefinition = beanDefinition;
        this.beanName = beanName;
    }

    /**
     * @return the beanDefinition
     */
    public BeanDefinition getBeanDefinition() {
//        return this.beanDefinition;
        return beanDefinition;
    }

    /**
     * @return the beanName
     */
    public String getBeanName() {
//        return this.beanName;
        return beanName;
    }
    
    
    
}
