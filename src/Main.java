// 6510405814 Sornchai Somsakul

import services.GumballService;

public class Main {
    public static void main(String[] args) {
        GumballService service = new GumballService();

        service.init();
        service.insertQuarter();
        service.rotateCrank();

        System.out.println();
        service.init();
        service.insertQuarter();
        service.ejectQuarter();
        service.rotateCrank();

        System.out.println();
        service.init();
        service.insertQuarter();
        service.rotateCrank();
        service.insertQuarter();
        service.rotateCrank();
        service.ejectQuarter();

        System.out.println();
        service.init();
        service.insertQuarter();
        service.insertQuarter();
        service.rotateCrank();
        service.insertQuarter();
        service.rotateCrank();
        service.insertQuarter();
        service.rotateCrank();

        System.out.println();
        service.init();
    }
}