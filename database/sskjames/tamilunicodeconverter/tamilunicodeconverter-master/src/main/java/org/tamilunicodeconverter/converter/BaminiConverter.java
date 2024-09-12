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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.UnhandledException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tamilunicodeconverter.map.BaminiUnicodeMap;

/**
 *
 * @author James Selvakumar
 */
public class BaminiConverter implements IUnicodeConverter
{
    private static final Logger logger = LoggerFactory.getLogger(BaminiConverter.class);
    public static final String SCRIPT_FILE = "bamini.js";

    @Override
    public String getUnicodeText(String text)
    {
    	String unicodeText = text;
    	Map<String, String> map = BaminiUnicodeMap.getMap();
		for (String key : map.keySet()) {
			if (unicodeText.contains(key)) {
				unicodeText = unicodeText.replace(key, map.get(key));				
			}
		}    
		return unicodeText;
    }
        
    public String getUnicodeTextUsingJavaScript(String text)
    {
        String unicodeText = "";

        try {
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            engine.eval(getScriptContent());
            Invocable invokable = (Invocable) engine;
            unicodeText = (String) invokable.invokeFunction("convert", new String[]{text});
        } catch (Exception ex) {
            throw new UnhandledException("Error occured while converting bamini text to unicode", ex);
        }
        return unicodeText;
    }

    protected String getScriptContent() throws IOException
    {
        String scriptContent = "";
        URL url = getScriptUrl();
        File scriptFile = FileUtils.toFile(url);
        scriptContent = FileUtils.readFileToString(scriptFile);
        return scriptContent;
    }

    protected URL getScriptUrl()
    {
        return ClassLoader.getSystemClassLoader().getResource(SCRIPT_FILE);
    }
}
