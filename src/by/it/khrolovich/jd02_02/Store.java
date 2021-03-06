package by.it.khrolovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static ListGoods priceList;


    public static void main(String[] args) {
        priceList = new ListGoods();

        //List<Customer> customers = new ArrayList<>(120);//список покупателей
        List<Thread> threads = new ArrayList<>(120);//список покупателей

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier, cashier.toString());
            threads.add(thread);//TODO
            thread.start();
        }

        System.out.println("Store opened");
        int numberCustomer = 0;
        int counterForPensionner = 0;
        int intervalForPensioneer = Util.getRandom(3, 5);
        while (Manager.storeIsOpened()) {
                int count = Util.getRandom(0, 2);
                for (int j = 0; j < count && Manager.storeIsOpened(); j++) {//если 99 и добавилось 2
                    // если нет проверки Manager.storeIsOpened() , то проскакивает больше покупателей
                    numberCustomer++;
                    counterForPensionner++;

                   Customer customer;
                    if (counterForPensionner == intervalForPensioneer) {
                        customer = new Customer(numberCustomer, true);
                        counterForPensionner = 0;
                        intervalForPensioneer =Util.getRandom(3, 5);
                    } else {
                        customer = new Customer(numberCustomer, false);
                    }

                   threads.add(customer);
                    customer.start();
                }
                Util.Sleep(1000);
         }
        /*for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                throw new RuntimeException();
            }
        }*/

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("Store closed");
    }
}
