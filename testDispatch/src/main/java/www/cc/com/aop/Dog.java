/**
 * @author Administrator
 * @data 2018年12月11日上午10:58:24
 */
package www.cc.com.aop;

import org.springframework.stereotype.Component;

/**
 * 
 * @author lc
 * @data 2018年12月11日上午10:58:24
 */
@Component
public class Dog implements Animal {

    /* (非 Javadoc) 
    * <p>Title: sayName</p> 
    * <p>Description: </p> 
    * @param name
    * @param num
    * @return 
    * @see www.cc.com.aop.Animal#sayName(java.lang.String, java.lang.Integer) 
    */
    @Cache(60)
    public String sayName(String name, Integer num) {
        return "this is dog:"+name+","+num;
    }
}
