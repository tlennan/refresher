package org.lennan.refresher.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringNoRepeats {
    public static void main(String[] args) {
//        Example 1:
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//                Example 4:
//        Input: s = ""
//        Output: 0

        Integer l = longestNonRepeating("abcabcbb");
        System.out.println(l);

        l = longestNonRepeating("bbbbb");
        System.out.println(l);

        l = longestNonRepeating("pwwkew");
        System.out.println(l);

        l = longestNonRepeating("");
        System.out.println(l);
    }

    private static Integer longestNonRepeating(String string) {
        Integer longest = 0;

        Integer head = 0;
        Integer tail = 0;
        String ls = "";
        while (tail < string.length()) {
            Character currentChar = string.charAt(tail);
            while (!ls.contains(currentChar.toString()) && tail < string.length()) {
                tail++;
                if (tail < string.length()) {
                    currentChar = string.charAt(tail);
                    ls = string.substring(head, tail);
                }
            }

            if (tail - head > longest)
                longest = tail - head;

            while (ls.contains(currentChar.toString()) && (head < tail)) {
                head++;
                ls = string.substring(head, tail);
            }
        }

        return longest;
    }
}
