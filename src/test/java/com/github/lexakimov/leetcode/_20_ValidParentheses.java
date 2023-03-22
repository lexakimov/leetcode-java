package com.github.lexakimov.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author akimov
 * created at 22.03.2023 18:09
 */
public class _20_ValidParentheses {
	class Solution {

		static class CharStack {
			private int size;
			private Entry head;

			static class Entry {
				private char ch;
				private Entry prev;
			}

			public void push(char ch) {
				var entry = new Entry();
				entry.ch = ch;
				if (head != null) {
					entry.prev = head;
				}
				head = entry;
				size++;
			}

			public char poll() {
				char ch = '-';
				if (head != null) {
					ch = head.ch;
					head = head.prev;
					size--;
				}
				return ch;
			}

			public boolean isEmpty() {
				return size == 0;
			}

		}

		public boolean isValid(String s) {
			var stack = new CharStack();
			for (char ch : s.toCharArray()) {
				switch (ch) {
					case '(', '{', '[' -> stack.push(ch);
					case ')' -> {
						if ('(' != stack.poll()) return false;
					}
					case '}' -> {
						if ('{' != stack.poll()) return false;
					}
					case ']' -> {
						if ('[' != stack.poll()) return false;
					}
				}
			}
			return stack.isEmpty();
		}
	}


	@Test
	@DisplayName("20. Valid Parentheses - https://leetcode.com/problems/valid-parentheses/")
	public void test() {
		var solution = new _20_ValidParentheses.Solution();
		assertTrue(solution.isValid("()"));
		assertTrue(solution.isValid("()[]{}"));
		assertTrue(solution.isValid("([]{})"));
		assertFalse(solution.isValid("[]{})"));
		assertFalse(solution.isValid("([]{}"));
		assertFalse(solution.isValid("([{})"));
		assertFalse(solution.isValid("(]"));
	}
}
