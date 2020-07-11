package dev.vabalas.jumpGame.service;

import java.util.ArrayList;
import java.util.List;

public class ServiceHelper {

    /**
     * Converts numbers in a list to a String, separated by commas, for storing in database.
     * @param list list of Integers 1,2,3,4
     * @return String of numbers, like "1,2,3,4"
     */
    public static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i: list) {
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * Checks if it is possible to reach the last element in array according to these rules:
     * 1. start at the first element
     * 2. current element value indicates how many steps can be taken at most
     * example 1: if the value is 3, then either 0, 1 , 2 or 3 steps can be taken.
     * example 2: if the value is 0, then it is the end.
     * @param list list of Integers to test
     * @return true or false depending if end of list can be reached
     */
    public static boolean listIsWinnable(List<Integer> list) {
        if (list.get(0) <= 0) {
            return false;
        }
        if (list.get(0) >= list.size() - 1) {
            return true;
        }
        if (list.size() == 1) {
            return true;
        }
        int lastKnownPosition = list.size() - 1;
        for (int i = lastKnownPosition - 1; i >= 0; i--) {
                if (i + list.get(i) >= lastKnownPosition) {
                lastKnownPosition = i;
            }
        }
        return lastKnownPosition == 0;
    }

    /**
     * Calculates the most efficient path for winnable list.
     * @param winnable specify if the list is winnable
     * @param list list of Integers
     * @return String of indexes, like "0,2,3,7"
     */
    public static String mostEfficientPathForList(boolean winnable, List<Integer> list) {
        if (!winnable) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        if (list.size() == 1) {
            sb.append("0");
            return sb.toString();
        }
        if (list.size() == 2) {
            sb.append("0,1");
            return sb.toString();
        }
        int maxJump = list.get(0);
        int start = 0;
        int end = list.size() - 1;

        if (maxJump >= end) {
            sb.append("0,").append(end);
            return sb.toString();
        }
        for (int i = start; i < end; i++) {
            List<Integer> possibleNextMax = new ArrayList<>();
            for (int j = i + 1; j <= i + maxJump; j++) {
                if (list.get(j) + j >= end) {
                    sb.append(",").append(i).append(",").append(j).append(",").append(end).deleteCharAt(0);
                    return sb.toString();
                }
                possibleNextMax.add(list.get(j));
            }
            int maxAt = 0;
            for (int k = 0; k < possibleNextMax.size(); k++) {
                maxAt = possibleNextMax.get(k) > possibleNextMax.get(maxAt) ? k : maxAt;
            }
            sb.append(",").append(i);
            maxJump = possibleNextMax.get(maxAt);
            i = i + maxAt;
        }
        sb.append(end).deleteCharAt(0);
        return sb.toString();
    }

}
