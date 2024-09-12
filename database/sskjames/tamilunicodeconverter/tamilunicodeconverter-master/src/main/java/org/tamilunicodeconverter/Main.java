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
package org.tamilunicodeconverter;

import java.io.File;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author James Selvakumar
 */
public class Main
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		// source file
		System.out.println("Enter the source file or directory: ");
		String sourceFilePath = keyboard.next();

		// output dir
		System.out.println("Enter the output directory: ");
		String outputDir = keyboard.next();
		
		// auto create file names
		System.out.println("Automatically create output file names based on content? (True|False): ");
		boolean createOutputFileName = keyboard.nextBoolean();

		if (StringUtils.isNotBlank(sourceFilePath)
				&& StringUtils.isNotBlank(outputDir)) {
			new TamilUnicodeConverter(createOutputFileName).convert(new File(sourceFilePath),
					new File(outputDir));
		} else {
			System.out.println("Both source and output dir are mandatory. Please run the program again.");
		}
	}
}
