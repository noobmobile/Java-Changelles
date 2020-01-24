package letter_distance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 author: dont
 changelle: https://edabit.com/challenge/Wr5YbkQakb6qh8Gax
 */

public class Main {

    public static void main(String[] args){
        HashMap<String, String> inputs = new HashMap<>();
        inputs.put("house", "fly");
        inputs.put("sharp", "sharq");
        inputs.put("abcde", "Abcde");
        inputs.put("eae", "ola");
        inputs.forEach((string1, string2) -> System.out.println(string1 + ", "+string2 +" -> "+distance(string1, string2)));

        /* output
            abcde, Abcde -> 32
            eae, ola -> 25
            house, fly -> 11
            sharp, sharq -> 1
         */

    }

    private static int distance(String string1, String string2) {
        int lenghtDifference = string1.length() == string2.length() ? 0 : difference(string1.length(),string2.length());
        int distance = 0;

        for (int i = 0; i < string1.toCharArray().length; i++) {
            char c1 = string1.toCharArray()[i];
            if (i >= string2.length()) break;;
            char c2 = string2.toCharArray()[i];
            distance += (difference(c1, c2));
        }

        return distance + lenghtDifference;
    }

    private static int difference(int i, int j){ // am I disabled?
        return Math.abs(i - j);
    }

}
