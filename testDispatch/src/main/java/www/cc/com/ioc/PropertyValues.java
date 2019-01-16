/**
 * @author Administrator
 * @data 2018年12月12日下午4:11:21
 */
package www.cc.com.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lc
 * @data 2018年12月12日下午4:11:21
 */
public class PropertyValues {
    
    private final List<PropertyValue> propertyValueList;
     
    public PropertyValues(){
        this.propertyValueList = new ArrayList<PropertyValue>();
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }
    
    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
    
}
