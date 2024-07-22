package org.dwh.wokrer;

import org.dwh.read.ReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class RunAfterStartup {
    @Autowired
    ReaderService readerService;

    static final Logger log = LoggerFactory.getLogger(RunAfterStartup.class);
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() throws MalformedURLException {
        log.debug("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warn message");
        log.error("This is an error message");
        log.trace("This is an trace message");
        System.out.println("       Yaaah, I am running........");
        String fileName = "data.csv";
        String path = "src/main/resources";
//        URL url = new URL("https://cloclo58.cloud.mail.ru/public/M87gXAw89WHWyoBB8H5/g/no/L1xB/nvgHGYJz5");
//        LoaderService.loadFile(url, fileName, path);
        readerService.readOneLineByOne(path, fileName);
    }
}
