package number_expender;

import java.util.Arrays;
import java.util.List;

/**
 author: dont
 changelle: https://edabit.com/challenge/f72omtBYFEBotgdEX
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> inputs = Arrays.asList(13, 86, 17000000, 5325);
        inputs.forEach(input -> System.out.println(input + " -> " + expand(input)));
        /* output
            13 -> 10 + 3
            86 -> 80 + 6
            17000000 -> 10000000 + 7000000 + 0
            5325 -> 5000 + 300 + 20 + 5
         */
    }

    private static String expand(Integer input) {
        if (input <= 10) return input.toString();

        int lenght = input.toString().length() - 1;
        int power = (int) Math.pow(10,lenght);

        int first = (input / power) * power;
        int rest = input % power;

        return first +" + " + expand(rest);
    }

}
