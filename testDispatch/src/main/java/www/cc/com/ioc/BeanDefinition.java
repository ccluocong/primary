/**
 * @author Administrator
 * @data 2018年12月12日下午4:11:21
 */
package www.cc.com.ioc;

/**
 * 
 * @author lc
 * @data 2018年12月12日下午4:11:21
 */
public class BeanDefinition {
    private Class beanClass;
    private String beanClassName;
    private PropertyValues propertyValues;

    /**
     * @return the beanClass
     */
    public Class getBeanClass() {
        return beanClass;
    }


    /**
     * @return the beanClassName
     */
    public String getBeanClassName() {
        return beanClassName;
    }

    /**
     * @param beanClassName
     *                          the beanClassName to set
     */
    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        //根据类名设置类
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * @return the propertyValues
     */
    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    /**
     * @param propertyValues
     *                           the propertyValues to set
     */
    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

}
