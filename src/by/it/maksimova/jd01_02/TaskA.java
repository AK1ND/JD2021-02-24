package by.it.maksimova.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {

            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);

    }

    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];

        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr) {
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            avg = avg + arr[i];

        }
        avg = avg / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < avg)
                System.out.print(arr[i] + " ");
        }
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (min > element) min = element;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min)
                System.out.print(i + " ");
        }
    }
}


