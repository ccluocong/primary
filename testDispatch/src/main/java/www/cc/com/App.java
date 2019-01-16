package www.cc.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages="www.cc.com")
public class App
{
//    private static final Logger LOGGER = LoggerFactory.getLogger(App.class); 
    public App() {
        
//        log.debug("---> debug start! <------");
//        log.info("---> info start! <------");
//        log.warn("---> warn start! <------");
//        log.error("---> error start! <------");

//        System.out.println("===> System.out.println <=====");
    }
    
    
    
    public static void main( String[] args ) {
        SpringApplication.run(App.class);
    }
}
