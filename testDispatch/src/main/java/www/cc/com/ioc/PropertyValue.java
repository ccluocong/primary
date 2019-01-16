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
public class PropertyValue {
    private final String name;
    private final Object value;
    /** 
    * @Description: TODO
    * @param @param name
    * @param @param value    
    * @throws 
    */
    public PropertyValue(String name, Object value) {
        super();
        this.name = name;
        this.value = value;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }    

}
