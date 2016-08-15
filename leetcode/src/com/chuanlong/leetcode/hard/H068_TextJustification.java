package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class H068_TextJustification {

	/**
	 * https://leetcode.com/problems/text-justification/
	 */
	public static void main(String[] args) {
		H068_TextJustification obj = new H068_TextJustification();

		System.out
				.println("['This', 'is', 'an', 'example', 'of', 'text', 'justification.'] , 16 -> "
						+ "\n[This    is    an, example  of text, justification.  ], "
						+ "result ->\n"
						+ obj.fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16));

		System.out.println("['What','must','be','shall','be.'] , 12 -> "
				+ "\n[What must be, shall be.   ], "
				+ "result ->\n"
				+ obj.fullJustify(new String[] { "What", "must", "be", "shall", "be." }, 12));

	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<String>();

		for (int i = 0; words != null && i < words.length;) {
			int x = i, y = i + 1;
			while (y + 1 <= words.length) {
				int width = 0;
				for (int j = x; j < y + 1; j++) {
					width += words[j].length();
				}
				width += ((y + 1) - i) - 1;
				if (width > maxWidth) {
					break;
				} else {
					y++;
				}
			}
			
			// by default, the last line should be left justified and no extra space
			int avgSpaces = 1;
			int leftMore = 0;
			if (y < words.length) {
				// not the last line
				int width = 0;
				for (int j = x; j < y; j++) {
					width += words[j].length();
				}

				avgSpaces = (maxWidth - width);
				leftMore = 0;
				if (y - x - 1 > 0) {
					avgSpaces = (maxWidth - width) / (y - x - 1);
					leftMore = (maxWidth - width) - (y - x - 1) * avgSpaces;
				}
			}

			String token = "";
			for (int j = x; j < y - 1; j++) {
				token += words[j] + getSpaces(avgSpaces);
				if (j - x < leftMore) {
					token += getSpaces(1);
				}
			}

			token += words[y - 1];
			token += getSpaces(maxWidth - token.length());

			list.add(token);

			i = i + (y - x);
		}

		return list;
	}

	private String getSpaces(int count) {
		String token = "";
		for (int i = 0; i < count; i++) {
			token += " ";
		}
		return token;
	}

}
