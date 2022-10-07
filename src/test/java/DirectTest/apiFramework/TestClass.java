package DirectTest.apiFramework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        System.out.println(randomStringGeneration());

        String value=LocalDate.now().toString();
        System.out.println(value);

        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime nextMonday = dateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("nextMonday "+nextMonday);

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);
        System.out.println(tomorrow.isAfter(today));
    }

    public static String randomStringGeneration() {
        Random robj = new Random();
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        String newWord = "";
        for (int i = 0; i < 10; i++) {
            char c = alphabets.charAt(robj.nextInt(15));
            newWord = newWord + c;
        }
//        int number = robj.nextInt(100);
//        newWord = newWord + String.valueOf(number);
        return newWord;

    }
}
