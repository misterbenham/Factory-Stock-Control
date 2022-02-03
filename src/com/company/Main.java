package com.company;

import java.util.Scanner;                       // Scanner used for User Input.

public class Main {

    static int finalWidgetTotal = 5000;         // variable that stores total number of widgets that need to be produced.
    static int productionCount = 0;             // variable that counts the number of widgets being manufactured by the factories (threads).

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the number of factories available: ");
        int factoryQuantity = userInput.nextInt();
        System.out.println("Thank you. There are " + factoryQuantity
                + " factories adding widgets to central warehouse:\n" +
                "**************************");

                                                // Scanner used for user input (System.in).
                                                // A println asks the user for the number of factories to run.
                                                // The users input is stored as an integer variable named factoryQuantity.

//        Countdown countdown = new Countdown();

//        CountdownThread t1 = new CountdownThread(countdown);
//        t1.setName("Factory 1");

//        CountdownThread t2 = new CountdownThread(countdown);
//        t2.setName("Factory 2");

//        CountdownThread t3 = new CountdownThread(countdown);
//        t3.setName("Factory 3");

//        t1.start();
//        t2.start();
//        t3.start();

        for(int i = 0; i < factoryQuantity; i++){
            warehouseAllocation(i + 1);
        }
    }
                                                // for loop increments the number of warehouseAllocation threads
                                                // and also increments the factoryID variable.


    public static void warehouseAllocation(int factoryID) {

        Thread factoryThread = new Thread(() -> Countdown.doCountdown(factoryID));
        factoryThread.start();
    }
}
                                                // warehouseAllocation method parses factoryID variables and starts
                                                // the new threads that the user has input. Using a Lambda expression
                                                // these threads parse to the doCountdown method.

    class Countdown {

        public static void doCountdown(int factoryID) {

            for (int i = 0; Main.productionCount <= Main.finalWidgetTotal; i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }
                if (Main.productionCount != Main.finalWidgetTotal) {
                    IncreaseProductionCount.activate(factoryID);
                } else {
                    break;
                }
            }
        }
    }
                                                // This method parses the factoryID variables and runs a for loop.
                                                // The for loop increments the number of widgets if the total (productionCount)
                                                // does ot equal the final widget total (finalWidgetTotal) of 5000. If total does
                                                // not equal final total then activate the IncreaseProductionCount method, parsing
                                                // factoryID variable.

//    class CountdownThread extends Thread {
//        private Countdown threadCountdown;
//
//        public CountdownThread(Countdown countdown) {
//            threadCountdown = countdown;
//        }
//
//        public void run() {
//            threadCountdown.doCountdown();
//        }
//    }

    class IncreaseProductionCount extends Thread {
        public synchronized static void activate(int factoryID) {
            Main.productionCount = Main.productionCount + 1;

            String color;
            color = ThreadColour.ANSI_BLUE;

            System.out.println(color + "Factory #" + factoryID + " added widget# " + Main.productionCount);

            if (Main.productionCount == Main.finalWidgetTotal) {
                System.out.println(ThreadColour.ANSI_GREEN + "Central Warehouse received 5000 Widgets");
            }
        }
    }
                                                // This method extends the factoryThread, increasing the widget counter
                                                // (productionCount). A println outputs the factoryID and productionCount
                                                // number of widgets. A println outputs that central has reached 5000
                                                // when finalWidgetTotal is met.