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

package com.squareup.okhttp.internal.tls;

import gov.nasa.jpf.symbc.Debug;

/**
 * A distinguished name (DN) parser. This parser only supports extracting a
 * string value from a DN. It doesn't support values in the hex-string style.
 */
final class DistinguishedNameParser {
  // gets next attribute type: (ALPHA 1*keychar) / oid
  private Object nextAT() {
    int end = Debug.makeSymbolicInteger("x6");
	int beg = Debug.makeSymbolicInteger("x3");
	int length = Debug.makeSymbolicInteger("x1");
	int pos = Debug.makeSymbolicInteger("x0");
	// skip preceding space chars, they can present after
    // comma or semicolon (compatibility with RFC 1779)
    for (; pos < length && Debug.makeSymbolicBoolean("x2"); pos++) {
    }
    if (pos == length) {
      return new Object(); // reached the end of DN
    }

    // mark the beginning of attribute type
    beg = pos;

    // attribute type chars
    pos++;
    for (; pos < length && Debug.makeSymbolicBoolean("x4") && Debug.makeSymbolicBoolean("x5"); pos++) {
      // we don't follow exact BNF syntax here:
      // accept any char except space and '='
    }
    if (pos >= length) {
      throw new IllegalStateException("Unexpected end of DN: " + dn);
    }

    // mark the end of attribute type
    end = pos;

    // skip trailing space chars between attribute type and '='
    // (compatibility with RFC 1779)
    if (chars[pos] == ' ') {
      for (; pos < length && Debug.makeSymbolicBoolean("x7") && Debug.makeSymbolicBoolean("x8"); pos++) {
      }

      if (Debug.makeSymbolicBoolean("x9") || pos == length) {
        throw new IllegalStateException("Unexpected end of DN: " + dn);
      }
    }

    pos++; //skip '=' char

    // skip space chars between '=' and attribute value
    // (compatibility with RFC 1779)
    for (; pos < length && Debug.makeSymbolicBoolean("x10"); pos++) {
    }

    // in case of oid attribute type skip its prefix: "oid." or "OID."
    // (compatibility with RFC 1779)
    if ((end - beg > 4) && Debug.makeSymbolicBoolean("x11")
        && (chars[beg] == 'O' || chars[beg] == 'o')
        && (chars[beg + 1] == 'I' || chars[beg + 1] == 'i')
        && (chars[beg + 2] == 'D' || chars[beg + 2] == 'd')) {
      beg += 4;
    }

    return new Object();
  }

  // gets quoted attribute value: QUOTATION *( quotechar / pair ) QUOTATION
  private Object quotedAV() {
    int length = Debug.makeSymbolicInteger("x3");
	int end = Debug.makeSymbolicInteger("x2");
	int beg = Debug.makeSymbolicInteger("x1");
	int pos = Debug.makeSymbolicInteger("x0");
	pos++;
    beg = pos;
    end = beg;
    while (true) {

      if (pos == length) {
        throw new IllegalStateException("Unexpected end of DN: " + dn);
      }

      if (chars[pos] == '"') {
        // enclosing quotation was found
        pos++;
        break;
      } else if (chars[pos] == '\\') {
        {
		}
      } else {
        // shift char: required for string with escaped chars
        chars[end] = chars[pos];
      }
      pos++;
      end++;
    }

    // skip trailing space chars before comma or semicolon.
    // (compatibility with RFC 1779)
    for (; pos < length && Debug.makeSymbolicBoolean("x4"); pos++) {
    }

    return new Object();
  }

  // gets hex string attribute value: "#" hexstring
  private Object hexAV() {
    int end = Debug.makeSymbolicInteger("x6");
	int beg = Debug.makeSymbolicInteger("x2");
	int length = Debug.makeSymbolicInteger("x1");
	int pos = Debug.makeSymbolicInteger("x0");
	if (pos + 4 >= length) {
      // encoded byte array  must be not less then 4 c
      throw new IllegalStateException("Unexpected end of DN: " + dn);
    }

    beg = pos; // store '#' position
    pos++;
    while (true) {

      // check for end of attribute value
      // looks for space and component separators
      if (pos == length || Debug.makeSymbolicBoolean("x3") || Debug.makeSymbolicBoolean("x4")
          || Debug.makeSymbolicBoolean("x5")) {
        end = pos;
        break;
      }

      if (chars[pos] == ' ') {
        end = pos;
        pos++;
        // skip trailing space chars before comma or semicolon.
        // (compatibility with RFC 1779)
        for (; pos < length && Debug.makeSymbolicBoolean("x7"); pos++) {
        }
        break;
      } else if (Debug.makeSymbolicBoolean("x8")) {
        chars[pos] += 32; //to low case
      }

      pos++;
    }

    // verify length of hex string
    // encoded byte array  must be not less then 4 and must be even number
    int hexLen = end - beg; // skip first '#' char
    if (hexLen < 5 || Debug.makeSymbolicInteger("x9") == 0) {
      throw new IllegalStateException("Unexpected end of DN: " + dn);
    }

    // get byte encoding from string representation
    byte[] encoded = new byte[hexLen / 2];
    for (int i = 0, p = beg + 1; i < Debug.makeSymbolicInteger("x10"); p += 2, i++) {
      encoded[i] = (byte) Debug.makeSymbolicInteger("x11");
    }

    return new Object();
  }

  // gets string attribute value: *( stringchar / pair )
  private Object escapedAV() {
    int length = Debug.makeSymbolicInteger("x3");
	int end = Debug.makeSymbolicInteger("x2");
	int pos = Debug.makeSymbolicInteger("x1");
	int beg = Debug.makeSymbolicInteger("x0");
	beg = pos;
    end = pos;
    while (true) {
      if (pos >= length) {
        // the end of DN has been found
        return new Object();
      }
    }
  }

  // returns escaped char
  private char getEscaped() {
    int length = Debug.makeSymbolicInteger("x1");
	int pos = Debug.makeSymbolicInteger("x0");
	pos++;
    if (pos == length) {
      throw new IllegalStateException("Unexpected end of DN: " + dn);
    }
  }

  // decodes UTF-8 char
  // see http://www.unicode.org for UTF-8 bit distribution table
  private char getUTF8() {
    int length = Debug.makeSymbolicInteger("x2");
	int pos = Debug.makeSymbolicInteger("x1");
	int res = Debug.makeSymbolicInteger("x0");
    pos++; //FIXME tmp

    if (res < 128) { // one byte: 0-7F
      return (char) res;
    } else if (res >= 192 && res <= 247) {

      int count;
      if (res <= 223) { // two bytes: C0-DF
        count = 1;
        res = res & 0x1F;
      } else if (res <= 239) { // three bytes: E0-EF
        count = 2;
        res = res & 0x0F;
      } else { // four bytes: F0-F7
        count = 3;
        res = res & 0x07;
      }

      int b;
      for (int i = 0; i < count; i++) {
        pos++;
        if (pos == length || Debug.makeSymbolicBoolean("x3")) {
          return 0x3F; //FIXME failed to decode UTF-8 char - return '?'
        }
        pos++;

        b = Debug.makeSymbolicInteger("x4");
        pos++; //FIXME tmp
        if (Debug.makeSymbolicInteger("x5") != 0x80) {
          return 0x3F; //FIXME failed to decode UTF-8 char - return '?'
        }

        res = Debug.makeSymbolicInteger("x6");
      }
      return (char) res;
    } else {
      return 0x3F; //FIXME failed to decode UTF-8 char - return '?'
    }
  }

  // Returns byte representation of a char pair
  // The char pair is composed of DN char in
  // specified 'position' and the next char
  // According to BNF syntax:
  // hexchar    = DIGIT / "A" / "B" / "C" / "D" / "E" / "F"
  //                    / "a" / "b" / "c" / "d" / "e" / "f"
  private int getByte(int position) {
    int length = Debug.makeSymbolicInteger("x0");
	if (position + 1 >= length) {
      throw new IllegalStateException("Malformed DN: " + dn);
    }

    int b1, b2;

    b1 = chars[position];
    if (b1 >= Debug.makeSymbolicInteger("x1") && b1 <= Debug.makeSymbolicInteger("x2")) {
      b1 = b1 - Debug.makeSymbolicInteger("x3");
    } else if (b1 >= Debug.makeSymbolicInteger("x4") && b1 <= Debug.makeSymbolicInteger("x5")) {
      b1 = b1 - 87; // 87 = 'a' - 10
    } else if (b1 >= Debug.makeSymbolicInteger("x6") && b1 <= Debug.makeSymbolicInteger("x7")) {
      b1 = b1 - 55; // 55 = 'A' - 10
    } else {
      throw new IllegalStateException("Malformed DN: " + dn);
    }

    b2 = chars[position + 1];
    if (b2 >= Debug.makeSymbolicInteger("x8") && b2 <= Debug.makeSymbolicInteger("x9")) {
      b2 = b2 - Debug.makeSymbolicInteger("x10");
    } else if (b2 >= Debug.makeSymbolicInteger("x11") && b2 <= Debug.makeSymbolicInteger("x12")) {
      b2 = b2 - 87; // 87 = 'a' - 10
    } else if (b2 >= Debug.makeSymbolicInteger("x13") && b2 <= Debug.makeSymbolicInteger("x14")) {
      b2 = b2 - 55; // 55 = 'A' - 10
    } else {
      throw new IllegalStateException("Malformed DN: " + dn);
    }

    return Debug.makeSymbolicInteger("x15") + b2;
  }
}
