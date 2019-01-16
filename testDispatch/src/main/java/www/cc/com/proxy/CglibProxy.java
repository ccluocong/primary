/**
 * @author Administrator
 * @data 2018年12月10日下午5:43:33
 */
package www.cc.com.proxy;

import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @author lc
 * @data 2018年12月10日下午5:43:33
 */
public class CglibProxy implements MethodInterceptor {

    Enhancer enhancer = new Enhancer();
    
    /**
     * 
     * void
     */
    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    
    
    /* (非 Javadoc) 
    * <p>Title: intercept</p> 
    * <p>Description: </p> 
    * @param arg0
    * @param arg1
    * @param arg2
    * @param arg3
    * @return
    * @throws Throwable 
    * @see org.springframework.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], org.springframework.cglib.proxy.MethodProxy) 
    */
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("--------测试intercept方法的四个参数的含义-----------");
        System.out.println("obj:"+obj.getClass());
        System.out.println("method:"+method.getName());
        System.out.println("proxy:"+proxy.getSuperName());
        if(args!=null&&args.length>0){
            for(Object value : args){
                System.out.println("args:"+value);
            }
        }
        
        System.out.println("前置方法");
        
        Object result = proxy.invokeSuper(obj, args);
        
        System.out.println("后置方法");
        
        return result;
        
    }


}
