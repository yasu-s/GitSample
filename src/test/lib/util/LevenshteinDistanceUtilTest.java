package test.lib.util;

import static org.junit.Assert.*;
import lib.util.LevenshteinDistanceUtil;

import org.junit.Test;

public class LevenshteinDistanceUtilTest {

	@Test
	public void testCalc() {

		//
		String source = "aaaa";
		String target = "abaa";
		int result = LevenshteinDistanceUtil.calc(source, target);
		assertTrue(result == 1);

		//
		source = "aaaa";
		target = "aaaa";
		result = LevenshteinDistanceUtil.calc(source, target);
		assertTrue(result == 0);

		//
		source = "aaaa";
		target = "aaaab";
		result = LevenshteinDistanceUtil.calc(source, target);
		assertTrue(result == 1);

		//
		source = "aaaab";
		target = "aaaa";
		result = LevenshteinDistanceUtil.calc(source, target);
		assertTrue(result == 1);

		//
		source = "aaaa";
		target = "bbbb";
		result = LevenshteinDistanceUtil.calc(source, target);
		assertTrue(result == 4);

		//
		source = "aaaa";
		target = "bb";
		result = LevenshteinDistanceUtil.calc(source, target);
		assertTrue(result == 4);

		//
		source = "aaaa";
		target = "";
		result = LevenshteinDistanceUtil.calc(source, target);
		assertTrue(result == 4);

		//
		source = "aaaa";
		target = "aaaaaaaa";
		result = LevenshteinDistanceUtil.calc(source, target);
		assertTrue(result == 4);

		//
		source = "aaaa";
		target = "aaaaaaaaa";
		result = LevenshteinDistanceUtil.calc(source, target);
		assertTrue(result == 5);
	}

}
