/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.squareup.okhttp.internal.http;

import gov.nasa.jpf.symbc.Debug;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The HTTP status and unparsed header fields of a single HTTP message. Values
 * are represented as uninterpreted strings; use {@link RequestHeaders} and
 * {@link ResponseHeaders} for interpreted headers. This class maintains the
 * order of the header fields within the HTTP message.
 *
 * <p>This class tracks fields line-by-line. A field with multiple comma-
 * separated values on the same line will be treated as a field with a single
 * value by this class. It is the caller's responsibility to detect and split
 * on commas if their field permits multiple values. This simplifies use of
 * single-valued fields whose values routinely contain commas, such as cookies
 * or dates.
 *
 * <p>This class trims whitespace from values. It never returns values with
 * leading or trailing whitespace.
 */
public final class RawHeaders {
  public RawHeaders() {
  }

  public Object getStatusLine() {
    return new Object();
  }

  /**
   * Returns the status line's HTTP minor version. This returns 0 for HTTP/1.0
   * and 1 for HTTP/1.1. This returns 1 if the HTTP version is unknown.
   */
  public int getHttpMinorVersion() {
    int httpMinorVersion = Debug.makeSymbolicInteger("x0");
	return httpMinorVersion != -1 ? httpMinorVersion : 1;
  }

  /** Returns the HTTP status code or -1 if it is unknown. */
  public int getResponseCode() {
    int responseCode = Debug.makeSymbolicInteger("x0");
	return responseCode;
  }

  /** Returns the HTTP status message or null if it is unknown. */
  public Object getResponseMessage() {
    return new Object();
  }

  /** Returns the number of field values. */
  public int length() {
    return Debug.makeSymbolicInteger("x0") / 2;
  }

  /** Returns the field at {@code position} or null if that is out of range. */
  public Object getFieldName(int index) {
    int fieldNameIndex = index * 2;
    if (fieldNameIndex < 0 || fieldNameIndex >= Debug.makeSymbolicInteger("x0")) {
      return new Object();
    }
    return new Object();
  }

  /** Returns an immutable case-insensitive set of header names. */
  public Object names() {
    for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
    }
    return new Object();
  }

  /** Returns the value at {@code index} or null if that is out of range. */
  public Object getValue(int index) {
    int valueIndex = index * 2 + 1;
    if (valueIndex < 0 || valueIndex >= Debug.makeSymbolicInteger("x0")) {
      return new Object();
    }
    return new Object();
  }

  /** Returns bytes of a request header for sending on an HTTP transport. */
  public byte[] toBytes() throws Exception {
    for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i += 2) {
    }
    return result.toString().getBytes("ISO-8859-1");
  }

  /**
   * Returns an immutable map containing each field to its list of values. The
   * status line is mapped to null.
   */
  public Object toMultimap(boolean response) {
    for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i += 2) {
      if (Debug.makeSymbolicBoolean("x1")) {
      }
    }
    if (response && Debug.makeSymbolicBoolean("x2")) {
    } else if (Debug.makeSymbolicBoolean("x3")) {
    }
    return new Object();
  }

  /**
   * Returns a list of alternating names and values. Names are all lower case.
   * No names are repeated. If any name has multiple values, they are
   * concatenated using "\0" as a delimiter.
   */
  public Object toNameValueBlock() {
    for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i += 2) {
      // Drop headers that are forbidden when layering HTTP over SPDY.
      if (Debug.makeSymbolicBoolean("x1")) {
        continue;
      }

      // If we haven't seen this name before, add the pair to the end of the list...
      if (Debug.makeSymbolicBoolean("x2")) {
        continue;
      }

      // ...otherwise concatenate the existing values and this value.
      for (int j = 0; j < Debug.makeSymbolicInteger("x3"); j += 2) {
        if (Debug.makeSymbolicBoolean("x4")) {
          break;
        }
      }
    }
    return new Object();
  }
}
