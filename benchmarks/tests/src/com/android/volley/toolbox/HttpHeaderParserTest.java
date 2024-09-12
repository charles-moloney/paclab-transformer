/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.volley.toolbox;

import gov.nasa.jpf.symbc.Debug;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpHeaderParserTest {

    protected void setUp() throws Exception {
    }

    public void testParseCacheHeaders_noHeaders() {
    }

    public void testParseCacheHeaders_headersSet() {
    }

    public void testParseCacheHeaders_etag() {
    }

    public void testParseCacheHeaders_normalExpire() {
        long now = Debug.makeSymbolicInteger("x0");
    }

    public void testParseCacheHeaders_expiresInPast() {
        long now = Debug.makeSymbolicInteger("x0");
    }

    public void testParseCacheHeaders_serverRelative() {

        long now = Debug.makeSymbolicInteger("x0");
    }

    public void testParseCacheHeaders_cacheControlOverridesExpires() {
        long now = Debug.makeSymbolicInteger("x0");
    }

    public void testParseCacheHeaders_cacheControlNoCache() {
        long now = Debug.makeSymbolicInteger("x0");
    }

    public void testParseCacheHeaders_cacheControlMustRevalidate() {
        long now = Debug.makeSymbolicInteger("x0");
    }

    private void assertEqualsWithin(long expected, long value, long fudgeFactor) {
        long diff = Debug.makeSymbolicInteger("x0");
    }

    private static Object rfc1123Date(long millis) {
        return new Object();
    }

    // --------------------------

    public void testParseCharset() {
    }
}
