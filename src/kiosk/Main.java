package kiosk;

import kiosk.service.KioskService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        KioskService kiosk = new KioskService();
        kiosk.initMenu();
        kiosk.mainMenu();
    }
}