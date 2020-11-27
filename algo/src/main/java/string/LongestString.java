package string;

import java.util.*;

/**
 * @date 2020/11/24
 */

public class LongestString {

    public static void main(String[] args) {

        System.out.println(longestString("bpfbhmipx"));
        System.out.println(longestString("abcabcab"));
        System.out.println(longestString("pwwkew"));
        System.out.println(longestString("dvdf"));
        System.out.println(longestString(" "));

    }

    static Integer longestString(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        char[] chars = string.toCharArray();
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
//            if (map.getOrDefault(chars[i], -1) < left) {
//                map.put(chars[i], i);
//            } else {
//                maxLength = Math.max(maxLength, i - left);
//                left = map.get(chars[i]) + 1;
//                map.put(chars[i], i);
//            }
            if (map.containsKey(chars[i])) {
                maxLength = maxLength < (i - left) ? i - left : maxLength;
                left = map.get(chars[i]) + 1 > left ? map.get(chars[i]) + 1 : left;
            }
            map.put(chars[i], i);

        }

        return maxLength = maxLength < (chars.length - left ) ? (chars.length - left ) : maxLength;


//        Optional<Integer> max = longest.stream().map(x -> x.size()).max(Comparator.comparing(y -> y));
//        return max.orElse(0);
//        return maxLength;
    }
}
