package com.learning.Leetcode.Stack;

import java.util.*;

public class Solutions {

    /**
     * copiato, da capire megio stacks
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i  = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(')');
            } else if(s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if(stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * !!sbagliato perché non avevi compreso bene il problema prima di iniziare!!
     * facile quando inizi a capire come maneggiare le stack
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>();
        Stack<String> stack = new Stack<>();
        int a, b, c;

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for(String s : tokens) {
            if(operators.contains(s)) {
                a = Integer.parseInt(stack.pop());
                b = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+": {
                        c = a + b;
                        stack.push(String.valueOf(c));
                        break;
                    }
                    case "-": {
                        c = b - a;
                        stack.push(String.valueOf(c));
                        break;
                    }
                    case "*": {
                        c = a * b;
                        stack.push(String.valueOf(c));
                        break;
                    }
                    case "/": {
                        c = b / a;
                        stack.push(String.valueOf(c));
                        break;
                    }
                }
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * Ottimo problema che peró non centra con le stack...
     * Video https://www.youtube.com/watch?v=s9fokUqJ76A&ab_channel=NeetCode
     * Bel modo di ragionare! Bella soluzione partendo da bruteforce
     * Visualizzare i limiti del problema con un'istanza dello stesso
     * imho HARD.
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generateRecursiveParenthesis(ret, 0, 0, "", n);
        return ret;
    }

    public static void generateRecursiveParenthesis(List<String> ret, int left, int right, String s, int n) {
        if(s.length() == 2*n) {
            ret.add(s);
            return;
        }
        if(left < n) {
            generateRecursiveParenthesis(ret, left+1, right, s + "(", n);
        }
        if(right < left) {
            generateRecursiveParenthesis(ret, left, right+1, s + ")", n);
        }
    }

    /**
     *  Copiato, da rifare!
     *  HARD
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
           while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
               stack.pop();
           }
           answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;

           stack.push(i);
        }

        return answer;
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        return 0;
    }











}
