/**
 * @author Administrator
 * @data 2018年12月10日下午5:26:15
 */
package www.cc.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @author lc
 * @data 2018年12月10日下午5:26:15
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;
    
    
    /** 
    * @Description: TODO
    * @param @param target    
    * @throws 
    */
    public DynamicProxy(Object target) {
        super();
        this.target = target;
    }



    /* (非 Javadoc) 
    * <p>Title: invoke</p> 
    * <p>Description: </p> 
    * @param proxy
    * @param method
    * @param args
    * @return
    * @throws Throwable 
    * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]) 
    */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在目标方法之前执行
        System.out.println("前置执行");
        
        //通过反射机制调用目标方法
        Object result = method.invoke(target, args);
        
        //目标方法之后执行
        System.out.println("后置执行");
        return result;
    }
    
    
    
    
    
    
}
