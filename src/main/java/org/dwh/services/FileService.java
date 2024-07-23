package org.dwh.services;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@Service
public class FileService {
    static final Logger log = LoggerFactory.getLogger(FileService.class);


    public static void loadFile(URL url, String fileName, String path) {
//        Path outputPath = Path.of(path, fileName);
//
//        try (InputStream in = url.openStream()) {
//            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
//            log.info("Скачали файл с адреса:" + url);
//        } catch (IOException e) {
//            log.error("Ошибка при скачивание файла с адреса:" + url);
//        }
        unZipFile(path +"/"+ fileName, path);
    }

    public static void unZipFile(String zipFile, String outputDirectory) {

        try (ArchiveInputStream archiveInputStream = new ZipArchiveInputStream(new FileInputStream(zipFile))) {
            ArchiveEntry entry;
            while ((entry = archiveInputStream.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    File outputFile = new File(outputDirectory + File.separator + entry.getName());
                    if (!outputFile.exists()) {
                        outputFile.createNewFile();
                    }
                    try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                        IOUtils.copy(archiveInputStream, fos);
                    }
                }
            }
            System.out.println("Файл успешно разархивирован");
        } catch (IOException e) {
            System.out.println("ошибка при разархивирование файла");
            System.out.println(e.getMessage());
        }
    }
}

