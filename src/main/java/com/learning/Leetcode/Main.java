package com.learning.Leetcode;

import com.learning.Leetcode.Stack.MinStack;
import com.learning.Leetcode.Stack.Solutions;

import java.util.Arrays;
import java.util.List;

public class Main {

	/**
	 * Rifai tutto senza checkare le soluzioni!
	 * Studia meglio:
	 *  - Modellazione dei problemi in modo visivo e originale
	 * 	- Set
	 * 	- Map
	 * 	- Hashing!
	 * 	- Stack
	 */
	public static void main(String[] args) {

		int[] temperatures = {73,74,75,71,69,72,76,73};
		System.out.println(Arrays.toString(Solutions.dailyTemperatures(temperatures)));

		/**
		 MinStack obj = new MinStack();
		 obj.push(2);
		 obj.push(0);
		 obj.push(3);
		 obj.push(0);
		 System.out.println(obj.getMin());
		 obj.pop();
		 System.out.println(obj.getMin());
		 obj.pop();
		 System.out.println(obj.getMin());
		 obj.pop();
		 System.out.println(obj.getMin());
		 */
	}

}
