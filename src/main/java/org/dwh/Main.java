package org.dwh;

import java.net.MalformedURLException;
import java.net.URL;

import org.dwh.load.Loader;
import org.dwh.read.Reader;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        String fileName = "data.csv";
        String path = "src/main/resources";
//        URL url = new URL("https://itsm365.com/documents_rus/web/Content/Resources/doc/import_ou_csv.csv");
//        Loader.loadFile(url, fileName, path);
        Reader reader = new Reader();
        reader.readOneLineByOne(path, fileName);
    }

}