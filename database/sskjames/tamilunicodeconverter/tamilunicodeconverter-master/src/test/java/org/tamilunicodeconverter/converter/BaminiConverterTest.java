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
package org.tamilunicodeconverter.converter;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.tamilunicodeconverter.converter.BaminiConverter;
import org.tamilunicodeconverter.extractor.ContentExtractor;

/**
 * 
 * @author James Selvakumar
 */
public class BaminiConverterTest
{
	public final String PPT_DIR = "src/test/resources/ppt";
	private BaminiConverter baminiConverter = new BaminiConverter();

	public BaminiConverterTest()
	{
	}

	@Test
	public void testGetScriptUrl()
	{
		URL result = baminiConverter.getScriptUrl();
		assertEquals(
				ClassLoader.getSystemClassLoader().getResource(
						BaminiConverter.SCRIPT_FILE), result);
		System.out.println("Url: " + result);
	}

	@Test
	public void testGetScriptContent() throws IOException
	{
		String result = baminiConverter.getScriptContent();
		assert StringUtils.isNotBlank(result);
		System.out.println("Result:\n" + result);
	}

	@Test
	public void testConvertBaminiToUnicode() throws IOException
	{
		File file = new File(PPT_DIR, "A-001.PPT");
		String fileContent = ContentExtractor.get().getContent(file);
		String result = baminiConverter.getUnicodeText(fileContent);
		assert result != null;

		System.out.println("Unicode text:\n" + result);
		File outputFile = new File("target/temp/bamini-to-unicode.txt");
		outputFile.getParentFile().mkdirs();
		FileUtils.writeStringToFile(outputFile, result);
	}

	@Test
	public void testConvertBaminiWord_1()
	{
		String input = "Nahh;jhdpd; nts;sk; te;jhYk;";
		String expected = "யோர்தானின் வெள்ளம் வந்தாலும்";
		String actual = baminiConverter.getUnicodeText(input);
		assertEquals(expected, actual);
		System.out.println("Input: " + input + ", unicode output: " + actual);
	}

	@Test
	public void testBaminiWord_2()
	{
		String input = "Xrd;dh n[aNk Xrd;dh n[ak; ekf;Nf";
		String expected = "ஓசன்னா ஜெயமே ஓசன்னா ஜெயம் நமக்கே";
		String unicodeText = baminiConverter.getUnicodeText(input);
		System.out.println("Input text: " + input + ", Unicode text: "
				+ unicodeText);
		assertEquals(expected, unicodeText);
	}

	@Test
	public void testBaminiWord_3()
	{
		String input = "mgpN\\f ehjh";
		String expected = "அபிஷேக நாதா";
		String unicodeText = baminiConverter.getUnicodeText(input);
		System.out.println("Input text: " + input + ", Unicode text: "
				+ unicodeText);
		assertEquals(expected, unicodeText);
	}

	@Test
	public void testBaminiWord_4()
	{
		String input = "me;epa ghi\\fs;";		
		String expected = "அந்நிய பாஷைகள்";
		String unicodeText = baminiConverter.getUnicodeText(input);
		System.out.println("Input text: " + input + ", Unicode text: "
				+ unicodeText);
		assertEquals(expected, unicodeText);
	}

	@Test
	public void testBaminiWord_5()
	{
		String input = "naNfhth uh/gh";		
		String expected = "யெகோவா ராஃபா";
		String unicodeText = baminiConverter.getUnicodeText(input);
		System.out.println("Input text: " + input + ", Unicode text: "
				+ unicodeText);
		assertEquals(expected, unicodeText);
	}
	
	@Test
	public void testBaminiWord_6()
	{
		String input = "naNfhth &th";		
		String expected = "யெகோவா ரூவா";
		String unicodeText = baminiConverter.getUnicodeText(input);
		System.out.println("Input text: " + input + ", Unicode text: "
				+ unicodeText);
		assertEquals(expected, unicodeText);
	}

}
