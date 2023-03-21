package com.github.lexakimov.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">longest-common-prefix</a>
 *
 * @author akimov
 * created at 06.10.2022 22:56
 */
public class _14_LongestCommonPrefix {

	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0) return "";
			if (strs.length == 1) return strs[0];

			String firstWord = strs[0];
			if (firstWord.length() == 0) {
				return "";
			}

			int position = firstWord.length();

			for (int i = 1; i < strs.length; i++) {
				String currentWord = strs[i];
				if (currentWord.length() == 0) {
					return "";
				}
				for (int j = 0; j < currentWord.length(); j++) {
					if (j >= position) {
						break;
					}
					if (currentWord.charAt(j) != firstWord.charAt(j)) {
						position = j;
					}
				}
				if (currentWord.length() < position) {
					position = currentWord.length();
				}

			}
			return firstWord.substring(0, position);
		}
	}

	@Test
	@DisplayName("14. Longest Common Prefix - https://leetcode.com/problems/longest-common-prefix/")
	public void test() {
		var solution = new Solution();
		assertEquals("fl", solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
		assertEquals("", solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
		assertEquals("", solution.longestCommonPrefix(new String[]{"", "racecar", "car"}));
		assertEquals("a", solution.longestCommonPrefix(new String[]{"ab", "a"}));
		assertEquals("flower", solution.longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"}));
	}

}
