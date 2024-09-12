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
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tamilunicodeconverter.converter.ConverterFactory;
import org.tamilunicodeconverter.extractor.ContentExtractor;

/**
 * 
 * @author James Selvakumar
 *
 */
public class TamilUnicodeConverter
{
	public static final int MAX_FILE_NAME_LENGTH = 100;
	public static final int MAX_FILE_NAME_TOKENS = 4;
	private static final Logger logger = LoggerFactory
			.getLogger(TamilUnicodeConverter.class);
	private int maxFileNameLength = MAX_FILE_NAME_LENGTH;
	private int maxFileNameTokens = MAX_FILE_NAME_TOKENS;
	private boolean createOutputFileNameFromContent;
	private int convertedFilesCount;

	public TamilUnicodeConverter()
	{
	}

	public TamilUnicodeConverter(boolean createOutputFileNameFromContent)
	{
		this.createOutputFileNameFromContent = createOutputFileNameFromContent;
	}

	public void convert(File sourceFile, File outputDir)
	{		
		convertedFilesCount = 0;
		if (sourceFile.isDirectory()) {
			convertFilesInDir(sourceFile, outputDir);
		}else {
			convertFile(sourceFile, outputDir);
		}
		logger.info("Finished converting {} files", convertedFilesCount);
	}
	
	protected void convertFilesInDir(File sourceDir, File outputDir)
	{
		File[] files = sourceDir.listFiles();			
		
		for (File file : files) {
			if (file.isFile()) {					
				convertFile(file, outputDir);
			} else {
				// recurse
				convertFilesInDir(file, outputDir);
			}
		}
	}

	/**
	 * @param sourceFile
	 * @param outputDir
	 */
	protected void convertFile(File sourceFile, File outputDir)
	{
		logger.info("Processing the file " + sourceFile);
		try {
			String sourceFileBaseName = FilenameUtils.getBaseName(sourceFile
					.getName());
			// get content
			String rawContent = ContentExtractor.get().getContent(sourceFile);
			String unicodeContent = ConverterFactory.getConverter()
					.getUnicodeText(rawContent);
			// store content
			storeContent(outputDir, sourceFileBaseName, rawContent,
					unicodeContent);
			convertedFilesCount ++;
		} catch (Exception ex) {
			logger.error("Error occured while processing the file "
					+ sourceFile, ex);
		}
	}

	private void storeContent(File outputDir, String sourceFileBaseName,
			String rawContent, String unicodeContent)
	{
		// default output file names
		File rawOutpuFile = getRawOutputFile(outputDir, sourceFileBaseName);
		File unicodeOutputFile = getUnicodeOutputFile(outputDir,
				sourceFileBaseName);

		if (isCreateOutputFileNameFromContent()) {
			rawOutpuFile = new File(rawOutpuFile.getParent(),
					getFileNameFromContent(unicodeContent));
			unicodeOutputFile = new File(unicodeOutputFile.getParent(),
					getFileNameFromContent(unicodeContent));
		}

		logger.info("Storing raw content in the file " + rawOutpuFile);
		writeContentToFile(rawOutpuFile, rawContent);

		logger.info("Storing unicode content in the file " + unicodeOutputFile);
		writeContentToFile(unicodeOutputFile, unicodeContent);
	}

	private void writeContentToFile(File file, String content)
	{
		try {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			FileUtils.writeStringToFile(file, content);
		} catch (IOException ex) {
			logger.error("Error occured while storing the file " + file, ex);
		}
	}

	protected File getRawOutputFile(File outputDir, String sourceFileBaseName)
	{
		File rawFile = new File(outputDir, "raw" + File.separator
				+ sourceFileBaseName + ".txt");
		return rawFile;
	}

	/**
	 * @param outputDir
	 * @param sourceFileBaseName
	 * @return
	 */
	protected File getUnicodeOutputFile(File outputDir,
			String sourceFileBaseName)
	{
		File unicodeFile = new File(outputDir, "unicode" + File.separator
				+ sourceFileBaseName + ".txt");
		return unicodeFile;
	}

	protected String getFileNameFromContent(String content)
	{
		String subString = "";

		if (content.length() >= getMaxFileNameLength()) {
			subString = content.substring(0, getMaxFileNameLength());
		} else {
			subString = content;
		}

		String[] tokens = StringUtils.split(subString);
		StringBuilder fileNameBuilder = new StringBuilder();
		for (int i = 0; i < getMaxFileNameTokens(); i++) {
			if (i < tokens.length) {
				fileNameBuilder.append(tokens[i]).append(" ");
			}
		}
		return fileNameBuilder.toString().trim() + ".txt";
	}

	public boolean isCreateOutputFileNameFromContent()
	{
		return createOutputFileNameFromContent;
	}

	public void setCreateOutputFileNameFromContent(
			boolean createOutputFileNameFromContent)
	{
		this.createOutputFileNameFromContent = createOutputFileNameFromContent;
	}

	public int getMaxFileNameLength()
	{
		return maxFileNameLength;
	}

	public void setMaxFileNameLength(int maxFileNameLength)
	{
		this.maxFileNameLength = maxFileNameLength;
	}

	public int getMaxFileNameTokens()
	{
		return maxFileNameTokens;
	}

	public void setMaxFileNameTokens(int maxFileNameTokens)
	{
		this.maxFileNameTokens = maxFileNameTokens;
	}
	
	public int getConvertedFilesCount()
	{
		return convertedFilesCount;
	}
	
	protected void resetConvertedFilesCount()
	{
		convertedFilesCount = 0;
	}
}
