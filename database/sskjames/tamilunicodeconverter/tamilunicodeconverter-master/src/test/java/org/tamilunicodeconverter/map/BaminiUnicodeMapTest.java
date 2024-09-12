/*
 * Licensed to the http://code.google.com/p/tamilunicodeconverter under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tamilunicodeconverter.map;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

/**
 * 
 * @author James Selvakumar
 *
 */
public class BaminiUnicodeMapTest
{
	private Map<String, String> map = BaminiUnicodeMap.getMap();

	@Test
	public void testPrintAllEntries()
	{
		for (String key : map.keySet()) {
			System.out.println(key + "\t" + map.get(key));
		}
	}

	@Test
	public void testChars()
	{
		assertEquals("ரி", map.get("hp"));
		assertEquals("க", map.get("f"));
		assertEquals("கௌ", map.get("nfs"));
		assertEquals("ஷே", map.get("N\\"));
	}

	@Test
	public void testBaminiWord_1()
	{
		String input = "uh[h";
		String expected = "ராஜா";
		String unicodeText = input;
		for (String key : map.keySet()) {
			unicodeText = unicodeText.replace(key, map.get(key));
		}
		System.out.println("Input text: " + input + ", Unicode text: "
				+ unicodeText);
		assertEquals(expected, unicodeText);
	}
}
