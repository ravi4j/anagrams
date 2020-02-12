package com.anagrams.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AnagramService implements IAnagramService {

	@Override
	public boolean isAnagram(String word1, String word2) {
		if (word1 == null || word2 == null || word1.length() != word2.length()) {
			return false;
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
}
