package org.dwh;

<<<<<<< HEAD

=======
import org.dwh.wokrer.RunAfterStartup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> 72abcca (feat: add logging in file)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class Main {
    static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        log.debug("Main is a debug message");
        log.info("Main is an info message");
        log.warn("Main is a warn message");
        log.error("Main is an error message");
        log.trace("Main is an trace message");
    }


}


}