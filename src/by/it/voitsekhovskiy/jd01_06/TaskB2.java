package by.it.voitsekhovskiy.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static StringBuilder step1() {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("\\.{3}");
        Matcher matcher = pattern.matcher(Poem.text);
        while(matcher.find()) {
            int start = matcher.start();
            sb.delete(start, start+3);
        }
        return sb;
    }

    private static String[] step2(StringBuilder text) {
        Pattern pattern = Pattern.compile("[\\.\\?\\!]");
        String[] arr = pattern.split(text);
        return arr;
    }

    private static String[] step3(String[] arrayOfSentence) {
        Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ]");
        for (int i = 0; i < arrayOfSentence.length; i++) {
            StringBuilder sb = new StringBuilder(arrayOfSentence[i]);
            Matcher matcher = pattern.matcher(arrayOfSentence[i]);
            while(matcher.find()) {
                sb.setCharAt(matcher.start(), ' ');
                arrayOfSentence[i] = sb.toString().trim().replaceAll("\\s{2,}", " ");
            }
        }
        return arrayOfSentence;
    }

    private static String[] sort(String[] arr) {
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].length() > arr[i + 1].length()) {
                    String buffer = arr[i];
                    arr[i] = arr[i+1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
        }
        while (swap);
        return arr;
    }


    public static void main(String[] args) {
        StringBuilder withoutDots = step1();
        String[] arrOfSentence = step2(withoutDots);
        String[] cleanArr1 = step3(arrOfSentence);
        String[] sortArr = sort(cleanArr1);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.println(sortArr[i]);
        }

    }



















//    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder(Poem.text);
//        Pattern patternDeleteLine = Pattern.compile("\\n");
//        Matcher matcher = patternDeleteLine.matcher(Poem.text);
//        while (matcher.find()) {
//            int start = matcher.start();
//            sb.setCharAt(start, ' ');
//        }
//
//        Pattern findSentences = Pattern.compile("[.!?]");
//        String[] arrOfSentences = findSentences.split(sb);
//        Pattern changeSpecChar = Pattern.compile("\\p{Punct}");
//
//        for (int i = 0; i < arrOfSentences.length; i++) {
//            Matcher matcher1 = changeSpecChar.matcher(arrOfSentences[i]);
//            while (matcher.find()) {
//                int start = matcher.start();
//                arrOfSentences[i] = arrOfSentences[i];
//            }
//        }


//        Pattern pattern = Pattern.compile("\\p{Punct}");
//        Matcher matcher = pattern.matcher(Poem.text);
//        while (matcher.find()) {
//            int start = matcher.start();
//            sb.setCharAt(start, ' ');
//        }
//        System.out.println(sb);
    }
