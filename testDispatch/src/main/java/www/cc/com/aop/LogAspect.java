/**
 * @author Administrator
 * @data 2018年12月11日上午10:32:41
 */
package www.cc.com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @author lc
 * @data 2018年12月11日上午10:32:41
 */
@Component
@Aspect
@Order(100)
public class LogAspect {
    
    //定义切入点，包含任意参数，任意返回值，的公共方法 sayName
    @Pointcut("execution(public * *sayName(..))")
    private void log() {};
    
    //通知环绕增强，处理日志注入
    @Around("log()")
    private Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        
        
        System.out.println("before-around, params:"+JSONObject.wrap(args));
        Object result = proceedingJoinPoint.proceed(); 
        System.out.println("after-around, result:"+JSONObject.wrap(result));
        return result;
        
    }
    
    @Before("log()")
    private Object logBefore() throws Throwable {
        
        
        System.out.println("before");
//        Object result = proceedingJoinPoint.proceed(); 
//        System.out.println("before2, result:"+JSONObject.wrap(result));
        return null;
    }
    
    @After("log()")
    private Object logAfter() throws Throwable {
        
        System.out.println("After");
//        Object result = proceedingJoinPoint.proceed(); 
//        System.out.println("after2, result:"+JSONObject.wrap(result));
        return null;
    }
    
    @AfterReturning("log()")
    private Object logAfterReturning() throws Throwable {
        System.out.println("AfterReturning");
//        Object result = proceedingJoinPoint.proceed(); 
//        System.out.println("AfterReturning2, result:"+JSONObject.wrap(result));
        return null;
    }
    
    @AfterThrowing("log()")
    private Object logAfterThrowing() throws Throwable {
        
        System.out.println("AfterThrowing");
//        Object result = proceedingJoinPoint.proceed(); 
//        System.out.println("AfterThrowing2, result:"+JSONObject.wrap(result));
        return null;
    }
    
    
    
    
}
