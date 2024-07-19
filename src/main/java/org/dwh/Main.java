package org.dwh;

import java.net.MalformedURLException;
import java.net.URL;
import org.dwh.store.Loader;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://cloclo53.datacloudmail.ru/public/get/c4DtW24Hc7mMUQUUQjYHownVv41kDZNvDgQ6StAsXXznd57e9ueLYzwjrH2RFTg5DE6JZ8S8LnxUfKJXkEVqMUpK6kaLzw7LCA6PpgeUgLfUQREm8Q5qVWZYddajQqRKvfNegLsfHB9NpVurvpqX18EB2s9cVTffCLDiX1GLjMLbAFfeBnLbJ3JfDQqP2YTC7DeDsZ6TnYLqozev6daueD5KEyCimXnP5Hvas74EAhSEYkVeWU19cDiLtNDEuMP7C4xvyPXAubcZkU3qS8G6d4tZoYN7C2fy6xxxxzsxy7MEbhYiLvHjbBU5V4iUk8CV844E2u5Gg4t3KaopRqFd4BzSJKxGjAs2TLgc3Fkwv3FJEp1hhotEpJXWid8t77G8nWFT1SRBZYtGyRT/egorprishedko@mail.ru/IMOEX_230101_240601.csv");
        Loader.loadFile(url);
    }

}