/**
 * @author Administrator
 * @data 2018年12月11日上午10:45:06
 */
package www.cc.com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author lc
 * @data 2018年12月11日上午10:45:06
 */
public class testSpringAop {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnimalConfig.class);
        ClassPathXmlApplicationContext name = new ClassPathXmlApplicationContext();
        
        Animal animal = applicationContext.getBean("dog",Dog.class);
        String result = animal.sayName("rudytan", 12);
        String result1 = animal.sayName("rudytan", 12);
        String result2 = animal.sayName("rudytan", 12);
        String result3 = animal.sayName("rudytan", 13);
        String result4 = animal.sayName("rudytan", 13);
    }
}
