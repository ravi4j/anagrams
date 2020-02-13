package com.anagrams.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnagramService implements IAnagramService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AnagramService.class);
	private static final Pattern PATTERN_ALPHA = Pattern.compile("^[A-Za-z]+$");

	/**
	 * Method to check two words have anagrams property.
	 * Null arguments returns false. It trims non-null arguments to remove leading and trailing whitespaces.
	 *
	 * @param word1
	 * 		- string argument
	 * @param word2
	 * 		- string argument
	 * @return boolean - a boolean value (true|false)
	 * @throws IllegalArgumentException
	 * 		if either string arguments contains non-alpha characters
	 */
	@Override
	public boolean isAnagram(String word1, String word2) {

		if (word1 == null || word2 == null) {
			return false;
		}
		// Trim and check length
		word1 = word1.trim();
		word2 = word2.trim();

		if (word1.length() != word2.length()) {
			return false;
		}

		if (!isAlpha(word1) || !isAlpha(word2)) {
			String msg = "Illegal argument1 or argument2 is provided. Only accept alpha words i.e [A-Za-z].";
			LOGGER.error(msg);
			throw new IllegalArgumentException(msg);
		}

		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		Map<Character, Integer> map = new HashMap();

		for (int i = 0; i < word1.length(); i++) {
			char ch = word1.charAt(i);
			map.merge(ch, 1, Integer::sum);
		}

		for (int i = 0; i < word2.length(); i++) {
			char ch = word2.charAt(i);
			if (map.containsKey(ch) && map.get(ch) > 0) {
				map.put(ch, map.get(ch) - 1);
			} else {
				return false;
			}
		}
		return true;
	}

	boolean isAlpha(String word) {
		return word != null && PATTERN_ALPHA.matcher(word).find();
	}
}
