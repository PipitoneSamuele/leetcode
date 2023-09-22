package com.learning.Leetcode.ArrayAndHashing;

import java.util.*;
import java.util.stream.Collectors;

public class Solutions {

    /**
     * Assumption: develop an algorithm under O(n^2) - actual O(n logn)
     * Notes: study HashSets
     *
     * @param nums
     * @return true if any value in nums appear twice, false if every value is distinct
     */
    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> contained = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(contained.contains(nums[i])){
                return true;
            } else {
                contained.add(nums[i]);
            }
        }
        return false;
    }

    /**
     * Duplicato del metodo prima ma con i char, con modifica
     * per togliere '.' dall'array
     *
     * @param chars
     * @return
     */
    public static boolean containsDuplicate(char[] chars) {

        Set<Character> contained = new HashSet<>();

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != '.' && contained.contains(chars[i])){
                return true;
            } else {
                contained.add(chars[i]);
            }
        }
        return false;
    }


    /**
     * Assumption: under O(n^2) - actual O(3n)
     * Notes:
     *
     * @param s
     * @param t
     * @return true if t is anagram of s, false otherwise
     */
    public static boolean isAnagram(String s, String t) {

        if((s == null || t == null) || s.length() != t.length()) return false;

        int[] alphabetPos = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i);
            alphabetPos[pos-97] += 1;
        }
        for(int i = 0; i < t.length(); i++) {
            int pos = t.charAt(i);
            alphabetPos[pos-97] -= 1;
        }
        for(int i = 0; i < alphabetPos.length; i++) {
            if(alphabetPos[i] != 0) return false;
        }
        return true;
    }

    /**
     * Assumption: under O(n^2) - actual O(n logn)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] positions = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
           if(map.containsKey(nums[i])) {
               positions[1] = i;
               positions[0] = map.get(nums[i]);
               return positions;
           } else {
               map.put(target - nums[i], i);
           }
        }
        return null;
    }

    /**
     * Redo: passed but not happy with my solution
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> container = new ArrayList<>();

        for(int i = 0; i < strs.length; i++) {
            List<String> anagrams = new ArrayList<>();
            for(int j = 0; j < strs.length; j++) {
                if(i != j && isAnagram(strs[i], strs[j])) {
                    anagrams.add(strs[j]);
                    strs[j] = null;
                }
            }
            if(strs[i] != null) {
                anagrams.add(strs[i]);
            }
            if(anagrams.size() > 0) {
                container.add(anagrams);
            }

        }
        return container;
    }

    /**
     * TODO: Da capire, premessa giusta, proseguo sbagliato.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] topELement = new int[k];

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        return null;
    }

    /**
     * Con disegno era molto chiaro questo, se lo vedi visivamente riesci a risolverlo con
     * l'intuizione del prefisso e postfisso
     *
     * TODO: capisci come rendere codice piú clean, ora brutto
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];
        for(int i = 1; i < n; i++) {
            prefix[i] = 1;
        }
        for(int i = n-2; i > 0; i--) {
            suffix[i] = 1;
        }

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }
        for(int i = n-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i];
        }
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                answer[i] = suffix[i+1];
            } else if (i==n-1){
                answer[i] = prefix[i-1];
            } else {
                answer[i] = prefix[i-1] * suffix[i+1];
            }
        }
        return answer;
    }

    /**
     * Assunzione: dove c'é il punto abbiamo una casella vuota
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        char[] checkCharRow = new char[board.length];
        char[] checkCharColumn = new char[board.length];
        char[] checkCharBox = new char[board.length];

        //check row and column
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                checkCharRow[j] = board[i][j];
                checkCharColumn[j] = board[j][i];
            }
            if(containsDuplicate(checkCharRow) ||
                    containsDuplicate(checkCharColumn)) {
                return false;
            }
        }

        //check boxes TODO: che mostro, primo colpo senza bugs merito dell'esame
        for(int i = 0; i < board.length; i+=3) {
            for(int j = 0; j < board.length; j+=3) {
                for(int k = 0; k < 3; k++) {
                    for(int m = 0; m < 3; m++) {
                        checkCharBox[(k*3)+m] = board[i+k][j+m];
                    }
                }
                if(containsDuplicate(checkCharBox)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Must be O(n)
     * L'idea iniziale sarebbe quello di sortarlo e verificare i numeri consecutivi!
     * Copiata da neetcode, usa la testa e disegna il problema prima di guardare la soluzione
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        int length = 0;

        for(int n : nums) {
            set.add(n);
        }
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]-1)) {
                length = 0;
                while(set.contains(nums[i] + length)) {
                    length += 1;
                }
                if(length > longest) {
                    longest = length;
                }
            }
        }
        return longest;
    }














}
