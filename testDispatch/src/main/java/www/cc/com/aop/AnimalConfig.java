/**
 * @author Administrator
 * @data 2018年12月11日上午10:05:31
 */
package www.cc.com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 
 * @author lc
 * @data 2018年12月11日上午10:05:31
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AnimalConfig {
    
}
