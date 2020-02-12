package com.anagrams.service;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class AnagramServiceTest {

	private IAnagramService service = new AnagramService();

	@Test
	public void testIsAnagramWithNulls(){
		boolean isAnagram = service.isAnagram(null, null);
		Assert.isTrue(isAnagram == false, "Not Anagrams");
	}

	@Test
	public void testIsAnagramWithFirstWordAsNull(){
		boolean isAnagram = service.isAnagram(null, "Hello");
		Assert.isTrue(isAnagram == false, "Not Anagrams");
	}

	@Test
	public void testIsAnagramWithSecondWordAsNull(){
		boolean isAnagram = service.isAnagram("Hello", null);
		Assert.isTrue(isAnagram == false, "Not Anagrams");
	}

	@Test
	public void testIsAnagramWithDifferentLengthWords(){
		boolean isAnagram = service.isAnagram("Hello", "helloWorld");
		Assert.isTrue(isAnagram == false, "Not Anagrams");
	}

	@Test
	public void testIsAnagramUpperCase() {
		boolean isAnagram = service.isAnagram("Hello", "hello");
		Assert.isTrue(isAnagram == true, "'Hello' and 'hello' are  Anagrams");
	}

	@Test
	public void testIsAnagramWithWordAnagram() {
		boolean isAnagram = service.isAnagram("anagram", "margana");
		Assert.isTrue(isAnagram == true, "'anagram' and 'margana' are Anagrams");
	}

	@Test
	public void testIsAnagramEqualLengthWithExtraCharacter() {
		boolean isAnagram = service.isAnagram("anagramm", "marganaa");
		Assert.isTrue(isAnagram == false, "'anagramm' and 'marganaa' are Not Anagrams");
	}

	@Test
	public void testIsAnagramEqualLengthDifferentWords() {
		boolean isAnagram = service.isAnagram("bbcc", "dabc");
		Assert.isTrue(isAnagram == false, "bbcc and dabc are Not Anagrams");
	}

}
