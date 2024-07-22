import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
 