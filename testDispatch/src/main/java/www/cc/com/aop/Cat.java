/**
 * @author Administrator
 * @data 2018年12月11日上午10:09:29
 */
package www.cc.com.aop;

import org.springframework.stereotype.Component;

/**
 * 
 * @author lc
 * @data 2018年12月11日上午10:09:29
 */
@Component
public class Cat implements Animal {

    /* (非 Javadoc) 
    * <p>Title: sayName</p> 
    * <p>Description: </p> 
    * @param name
    * @param num
    * @return 
    * @see www.cc.com.aop.Animal#sayName(java.lang.String, java.lang.Integer) 
    */
    @Cache(61)
    public String sayName(String name, Integer num) {
        return "this is cat:"+name+","+num;
    }
    
    
}
