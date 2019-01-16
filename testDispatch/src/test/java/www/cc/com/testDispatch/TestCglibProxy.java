/**
 * @author Administrator
 * @data 2018年12月10日下午5:30:44
 */
package www.cc.com.testDispatch;

import www.cc.com.proxy.CglibProxy;
import www.cc.com.proxy.IUserService;
import www.cc.com.proxy.UserServiceImpl;

/**
 * 
 * @author lc
 * @data 2018年12月10日下午5:30:44
 */
public class TestCglibProxy {
        
    public static void main(String[] args) {
        /*UserServiceImpl target = new UserServiceImpl();
        
        DynamicProxy handler = new DynamicProxy(target);
        
        IUserService proxy = (IUserService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),handler);
        
        proxy.addUser();
        proxy.deleteUser();*/
        
        
        CglibProxy proxy = new CglibProxy();
        
        IUserService target = (IUserService) proxy.getProxy(UserServiceImpl.class);  
        
        target.addUser();
        target.deleteUser();
        
    }
}
