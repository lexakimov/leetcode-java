package com.github.lexakimov.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/">palindrome-number</a>
 *
 * @author akimov
 * created at 05.10.2022 21:45
 */
public class _9_Palindrome_Number {
	
	class Solution {
		public boolean isPalindrome(int x) {
			String str = String.valueOf(x);
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
					return false;
				}
			}
			return true;
		}
	}
	
	@Test
	@DisplayName("9. Palindrome Number - https://leetcode.com/problems/palindrome-number/")
	public void test() {
		var solution = new Solution();
		Assertions.assertTrue(solution.isPalindrome(121));
		Assertions.assertFalse(solution.isPalindrome(123));
		Assertions.assertFalse(solution.isPalindrome(-121));
		Assertions.assertTrue(solution.isPalindrome(0));
	}
}
