package www.cc.com.testDispatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
import www.cc.com.App;
import www.cc.com.aop.Animal;
import www.cc.com.aop.AnimalConfig;
import www.cc.com.aop.Dog;
import www.cc.com.bean.HelloWord;
import www.cc.com.ioc.BeanDefinition;
import www.cc.com.ioc.BeanDefinitionHolder;
import www.cc.com.ioc.BeanFactory;
import www.cc.com.ioc.PropertyValue;
import www.cc.com.ioc.PropertyValues;
import www.cc.com.proxy.CglibProxy;
import www.cc.com.proxy.IUserService;
import www.cc.com.proxy.UserServiceImpl;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest 
    extends TestCase
{
   
    @Test
    public void testIOC() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        //创建 beanFactory
        BeanFactory beanFactory = new BeanFactory();
        
        
        //注册 bean 
        BeanDefinition bd = new BeanDefinition();
        bd.setBeanClassName("www.cc.com.bean.HelloWord");
        
        BeanDefinitionHolder bdh = new BeanDefinitionHolder(bd,"helloWord");
        beanFactory.registerBeanDefinition(bdh.getBeanName(), bdh.getBeanDefinition());
        
        
        //获取 bean
        HelloWord helloWord = (HelloWord) beanFactory.getBean("helloWord");
        assertEquals("hello word!", helloWord.sayHello());
    }

    @Test
    public void testIOProperty() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        //创建 Bean
        BeanFactory beanFactory = new BeanFactory();
            
        
        //注册 Bean
        BeanDefinition bd = new BeanDefinition();
        bd.setBeanClassName("www.cc.com.bean.HelloWord");
        
        //注入 bean 
        PropertyValues pvs = new PropertyValues();
        pvs.addPropertyValue(new PropertyValue("msg", "Hello IoC Property!"));
        bd.setPropertyValues(pvs);

        BeanDefinitionHolder bdh = new BeanDefinitionHolder(bd,"helloWord");
        beanFactory.registerBeanDefinition(bdh.getBeanName(), bdh.getBeanDefinition());
        
        //获取 bean
        HelloWord hello = (HelloWord) beanFactory.getBean("helloWord");
        assertEquals("Hello IoC Property!", hello.sayHello());
        
    }
    
    @Test
    public void testCglibProxy() {
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
    
    @Test
    public void testSpringProxy() {
//        注册所注释的配置类。此处的配置类是使用 @Configuration 注释声明的 AppContext。在注册了所述类之后，@Bean 注释的方法返回的所有 bean 类型也会得到注册。
        @SuppressWarnings("resource")
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnimalConfig.class);
//        加载外部 XML 上下文文件
//        ClassPathXmlApplicationContext name = new ClassPathXmlApplicationContext();
        
        Animal animal = applicationContext.getBean("dog",Dog.class);
        String result = animal.sayName("rudytan", 12);
        String result1 = animal.sayName("rudytan", 12);
        String result2 = animal.sayName("rudytan", 12);
        String result3 = animal.sayName("rudytan", 13);
        String result4 = animal.sayName("rudytan", 13);
    }
    
}
