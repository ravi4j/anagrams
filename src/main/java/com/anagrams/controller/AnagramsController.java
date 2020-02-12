package com.anagrams.controller;

import com.anagrams.service.IAnagramService;

import java.util.Collections;
import java.util.Map;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class AnagramsController {

	@Autowired
	IAnagramService service;

	@RequestMapping(value = "/anagrams/{string1}/{string2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map areAnagrams(@PathVariable @Pattern(regexp = "^[A-Za-z]+$", message = "Only Letters are allowed") String string1,
			@PathVariable @Pattern(regexp = "^[A-Za-z]+$", message = "Only Letters are allowed") String string2) {
		return Collections.singletonMap("areAnagrams", service.isAnagram(string1, string2));
	}

}
