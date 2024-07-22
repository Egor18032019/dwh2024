package org.dwh.wokrer;

import lombok.RequiredArgsConstructor;
import org.dwh.Main;
import org.dwh.read.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RunAfterStartup {
    @Autowired
    ReaderService readerService;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        System.out.println("       Yaaah, I am running........");
        String fileName = "data.csv";
        String path = "src/main/resources";
        readerService.readOneLineByOne(path, fileName);
    }
}
