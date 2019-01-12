package com.slowstarter;

import org.hibernate.annotations.Parent;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.slowstarter")
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class SlowstarterDemoApplication {

    /**
     * Basic SpringApplication
     */
    public static void main(String[] args) {
        SpringApplication.run(SlowstarterDemoApplication.class, args);
    }

    /**
     * PID SpringApplication
     */
//    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(SlowstarterDemoApplication.class);
//        springApplication.addListeners(new ApplicationPidFileWriter());
//        springApplication.run(args);
//    }

    /**
     * Banner Control SpringApplication
     */
//    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(SlowstarterDemoApplication.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.run(args);
//    }

    /**
     * Builder SpringApplication
     */
//    public static void main(String[] args) {
//        new SpringApplicationBuilder(SlowstarterDemoApplication.class)
////                .sources()
////                .child()
//                .bannerMode(Banner.Mode.CONSOLE)
//                .run(args);
//    }

    @GetMapping
    public String HelloWorld() {
        return "Hello World 1!";
    }
}
