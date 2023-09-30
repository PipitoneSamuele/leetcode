package com.learning.Leetcode.Stack;

public class MinStack {

    private int[] stack;
    private int pointer;
    private int[] min;
    private int minPointer;

    /**
     * stack == 2 0 3 0
     *
     * minStack == 10000 2 0 0
     *
     */

    public MinStack() {
        this.stack = new int[100000];
        this.pointer = -1;
        this.min = new int[100000];
        this.min[0] = 2147483647;
        this.minPointer = 0;
    }

    public void push(int val) {
        if(val <= this.min[minPointer]) {
            minPointer += 1;
            this.min[minPointer] = val;
        }
        pointer +=1;
        this.stack[pointer] = val;
    }

    public void pop() {
        if(this.min[minPointer] == this.stack[pointer] && this.minPointer > 0) {
            this.minPointer -= 1;
        }
        pointer -= 1;
    }

    public int top() {
        return stack[pointer];
    }

    public int getMin() {
        if(minPointer == 0) return 0;
        return this.min[minPointer];
    }

}
