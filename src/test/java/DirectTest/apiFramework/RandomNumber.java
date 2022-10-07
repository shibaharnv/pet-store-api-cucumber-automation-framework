package DirectTest.apiFramework;

import java.util.Random;

public class RandomNumber {

    public static void main(String[] args) {
        Random r = new Random();
        int value =r.nextInt(99);
        int low = 10;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        System.out.println(value);
    }
}
