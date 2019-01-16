/**
 * @author Administrator
 * @data 2018年12月11日上午10:07:23
 */
package www.cc.com.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author lc
 * @data 2018年12月11日上午10:07:23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Cache {
    int value() default 0;
}
