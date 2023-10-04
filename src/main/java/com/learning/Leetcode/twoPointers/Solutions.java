package com.learning.Leetcode.twoPointers;

import java.util.*;

public class Solutions {

    /**
     * Pulire stringa, bell'approccio!!
     * Ci sono soluzioni molto piú efficienti, ricontrolla
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    /**
     * Good job, fatto primo tentativo
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length-1;

        while(left <= right) {
            if(numbers[left] + numbers[right] == target) {
                left += 1;
                right += 1;
                res[0] = left;
                res[1] = right;
                return res;
            } else if(numbers[left] + numbers[right] < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return res;
    }

    /**
     *  Copiato, l'idead del set e del sort erano fondamentali.
     *  Impara ad usare sto cazzo di Set
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int left, right, threeSum;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length -1;
            while(left < right) {
                threeSum = nums[i] + nums[left] + nums[right];
                if(threeSum == 0) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    right -= 1;
                } else if (threeSum < 0) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        res.addAll(set);
        return res;
    }

    /**
     *  Copiato, ma una volta capito il concetto é facile.
     *  Per i prossimi tentativi, prova bruteforce poi vedi se trovi una logica
     *  La svolta é stata il calcolo di currentSolution (ovvimaente copiato)
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxSolution = 0;
        int currentSolution;

        while(left < right) {
            currentSolution = (right - left) * Math.min(height[left], height[right]);
            if(currentSolution > maxSolution) maxSolution = currentSolution;
            if(height[left] > height[right]) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return maxSolution;
    }

























}
