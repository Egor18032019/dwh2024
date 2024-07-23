package org.dwh.wokrer;

import org.dwh.load.LoaderService;
import org.dwh.read.ReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class RunAfterStartup {
    @Autowired
    ReaderService readerService;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() throws MalformedURLException {

        String fileName = "data.csv";
        String path = "src/main/resources";
        URL url = new URL("https://cloclo62.cloud.mail.ru/public/253563cgSecqb6bN4iCX/g/no/L1xB/nvgHGYJz5");
        LoaderService.loadFile(url, fileName, path);
        readerService.readOneLineByOne(path, fileName);
    }
}
