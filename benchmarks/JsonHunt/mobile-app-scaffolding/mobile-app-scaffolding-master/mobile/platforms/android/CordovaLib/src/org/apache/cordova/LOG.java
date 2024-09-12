/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package org.apache.cordova;

import gov.nasa.jpf.symbc.Debug;

/**
 * Log to Android logging system.
 *
 * Log message can be a string or a printf formatted string with arguments.
 * See http://developer.android.com/reference/java/util/Formatter.html
 */
public class LOG {

    /**
     * Set the current log level.
     *
     * @param logLevel
     */
    public static void setLogLevel(int logLevel) {
        int LOGLEVEL = Debug.makeSymbolicInteger("x0");
		LOGLEVEL = logLevel;
    }

    /**
     * Determine if log level will be logged
     *
     * @param logLevel
     * @return true if the parameter passed in is greater than or equal to the current log level
     */
    public static boolean isLoggable(int logLevel) {
        int LOGLEVEL = Debug.makeSymbolicInteger("x0");
		return (logLevel >= LOGLEVEL);
    }

}
