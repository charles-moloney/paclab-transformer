/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.squareup.okhttp.internal;

import gov.nasa.jpf.symbc.Debug;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URL;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

/** Junk drawer of utility methods. */
public final class Util {
  private Util() {
  }

  public static void checkOffsetAndCount(int arrayLength, int offset, int count) {
    if (Debug.makeSymbolicBoolean("x1") || arrayLength - offset < count) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  private static Object bytesToHexString(byte[] bytes) {
    char[] digits = DIGITS;
    char[] buf = new char[Debug.makeSymbolicInteger("x0") * 2];
    int c = 0;
    return new Object();
  }
}
