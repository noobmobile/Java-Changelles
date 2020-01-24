package karacas_encryptation_algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 author: dont
 changelle: https://edabit.com/challenge/SmL32HnRnmsCqGC5g
 */
public class Main {

    public static void main(String[] args){
        List<String> toEncrypt = Arrays.asList("apple", "banana", "karaca", "burak", "alpaca");
        toEncrypt.stream().map(Main::encrypt).forEach(string -> System.out.println(string + " -> " + decrypt(string)));

        /* output
            1lpp0aca -> apple
            0n0n0baca -> banana
            0c0r0kaca -> karaca
            k0r3baca -> burak
            0c0pl0aca -> alpaca
         */

    }

    private static String decrypt(String string) {
        String decrypted = string.substring(0, string.length()-3); // remove the last 3 characteres, the "aca"
        for (Map.Entry<Character, Character> entry : REPLACER.entrySet()) decrypted = decrypted.replace(entry.getValue(), entry.getKey());
        return reverse(decrypted);
    }

    private static String encrypt(String s) {
        String reverse = reverse(s);
        for (Map.Entry<Character, Character> entry : REPLACER.entrySet()) reverse = reverse.replace(entry.getKey(), entry.getValue());
        return reverse + "aca";
    }

    private final static HashMap<Character, Character> REPLACER = new HashMap<>();

    static {
        REPLACER.put('a', '0');
        REPLACER.put('e', '1');
        REPLACER.put('o', '2');
        REPLACER.put('u', '3');
    }

    private static String reverse(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }


}
