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
		
		}
	}
	
	@Test
	@DisplayName("14. Longest Common Prefix - https://leetcode.com/problems/longest-common-prefix/")
	public void test() {
		var solution = new Solution();
		assertEquals("fl", solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
		assertEquals("", solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
	}
	
}
