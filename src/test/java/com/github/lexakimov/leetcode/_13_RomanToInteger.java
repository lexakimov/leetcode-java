package com.github.lexakimov.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/">roman-to-integer</a>
 *
 * @author akimov
 * created at 05.10.2022 21:57
 */
public class _13_RomanToInteger {
	
	class Solution {
		public int romanToInt(String s) {
			int result = 0;
			//I             1
			//V             5
			//X             10
			//L             50
			//C             100
			
			//D             500
			//M             1000
			
			//I can be placed before V (5) and X (10) to make 4 and 9.
			//X can be placed before L (50) and C (100) to make 40 and 90.
			//C can be placed before D (500) and M (1000) to make 400 and 900.
			for (int i = 0; i < s.length(); i++) {
				var ch = s.charAt(i);
				if (ch == 'I') {
					if (i + 1 < s.length()) {
						var nextCh = s.charAt(i + 1);
						if (nextCh == 'V') {
							result += 4;
							i++;
						} else if (nextCh == 'X') {
							result += 9;
							i++;
						} else {
							result += 1;
						}
					} else {
						result += 1;
					}
				} else if (ch == 'V') {
					result += 5;
				} else if (ch == 'X') {
					if (i + 1 < s.length()) {
						var nextCh = s.charAt(i + 1);
						if (nextCh == 'L') {
							result += 40;
							i++;
						} else if (nextCh == 'C') {
							result += 90;
							i++;
						} else {
							result += 10;
						}
					} else {
						result += 10;
					}
				} else if (ch == 'L') {
					result += 50;
				} else if (ch == 'C') {
					if (i + 1 < s.length()) {
						var nextCh = s.charAt(i + 1);
						if (nextCh == 'D') {
							result += 400;
							i++;
						} else if (nextCh == 'M') {
							result += 900;
							i++;
						} else {
							result += 100;
						}
					} else {
						result += 100;
					}
				} else if (ch == 'D') {
					result += 500;
				} else if (ch == 'M') {
					result += 1000;
				}
			}
			
			return result;
		}
	}
	
	@Test
	@DisplayName("13. Roman to Integer - https://leetcode.com/problems/roman-to-integer/")
	public void test() {
		var solution = new Solution();
		assertEquals(1, solution.romanToInt("I"));
		assertEquals(5, solution.romanToInt("V"));
		assertEquals(10, solution.romanToInt("X"));
		assertEquals(50, solution.romanToInt("L"));
		assertEquals(100, solution.romanToInt("C"));
		assertEquals(500, solution.romanToInt("D"));
		assertEquals(1000, solution.romanToInt("M"));
		assertEquals(27, solution.romanToInt("XXVII"));
	}
	
}
