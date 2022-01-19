package org.lennan.refresher.strings;

import java.util.*;

public class MinimumWindowSubstring {
//    Input: S = “ADOBECODEBANC”, T = “ABC”
//    Output: “BANC”

    Integer head;
    Integer tail;
    Integer minDistance;

    public static void main(String[] args) {

        MinimumWindowSubstring solver = new MinimumWindowSubstring();
        solver.solve("ADOBECODEBANC", "ABC");
    }

    public MinimumWindowSubstring() {
    }

    private void solve(String source, String characters) {
        List<Character> ws = new ArrayList<>();
        Map<Character, List<Integer>> indexes = new HashMap<>();
        ArrayList<Integer> currentSolution = new ArrayList<>();

        char[] windowSet = characters.toCharArray();
        for (int i = 0; i < windowSet.length; i++) {
            Character character = windowSet[i];
            ws.add(character);
            indexes.put(character, new ArrayList<>());
            currentSolution.add(0);
        }

        head = 0;
        tail = 0;
        minDistance = Integer.MAX_VALUE;


        for (int i = 0; i < source.length(); i++) {
            Character c = source.charAt(i);
            if (ws.contains(c)) {
                indexes.get(c).add(i);
            }
        }

        permutate(ws, ws.size() - 1, indexes, currentSolution);

        if (head != tail) {
            System.out.println(source.substring(head, tail + 1));
        }
    }

    private void permutate(
            List<Character> chars,
            Integer index,
            Map<Character, List<Integer>> indexes,
            ArrayList<Integer> currentSolution)
    {
        if (index == 0) {
            indexes.get(chars.get(index)).forEach(si -> {
                currentSolution.set(index, si);
                testSolution(currentSolution);
            });
        } else {
            Character currentChar = chars.get(index);
            List<Integer> ixs = indexes.get(currentChar);
            ixs.forEach(si -> {
                currentSolution.set(index, si);
                permutate(chars, index - 1, indexes, currentSolution);
            });
        }
    }

    private void testSolution(ArrayList<Integer> solution) {
        Optional<Integer> min = solution.stream().min(Integer::compare);
        Optional<Integer> max = solution.stream().max(Integer::compare);
        if (min.isPresent() && max.isPresent()) {
            Integer distance = max.get() - min.get();
            if (distance < minDistance) {
                minDistance = distance;
                head = min.get();
                tail = max.get();
            }
        }
    }
}
