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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * This implementation uses HttpEngine to send requests and receive responses.
 * This class may use multiple HttpEngines to follow redirects, authentication
 * retries, etc. to retrieve the final response body.
 *
 * <h3>What does 'connected' mean?</h3>
 * This class inherits a {@code connected} field from the superclass. That field
 * is <strong>not</strong> used to indicate not whether this URLConnection is
 * currently connected. Instead, it indicates whether a connection has ever been
 * attempted. Once a connection has been attempted, certain properties (request
 * header fields, request method, etc.) are immutable. Test the {@code
 * connection} field on this class for null/non-null to determine of an instance
 * is currently connected to a server.
 */
public class HttpURLConnectionImpl {

  public final void connect() throws Exception {
    boolean success;
    do {
      success = Debug.makeSymbolicBoolean("x0");
    } while (!success);
  }

  public final void disconnect() {
    // Calling disconnect() before a connection exists should have no effect.
    if (Debug.makeSymbolicBoolean("x0")) {
      // We close the response body here instead of in
      // HttpEngine.release because that is called when input
      // has been completely read from the underlying socket.
      // However the response body can be a GZIPInputStream that
      // still has unread data.
      if (Debug.makeSymbolicBoolean("x1")) {
      }
    }
  }

  /**
   * Returns an input stream from the server in the case of error such as the
   * requested file (txt, htm, html) is not found on the remote server.
   */
  public final Object getErrorStream() {
    try {
      if (Debug.makeSymbolicBoolean("x0")) {
        return new Object();
      }
      return new Object();
    } catch (IOException e) {
      return new Object();
    }
  }

  /**
   * Returns the value of the field at {@code position}. Returns null if there
   * are fewer than {@code position} headers.
   */
  public final Object getHeaderField(int position) {
    try {
      return new Object();
    } catch (IOException e) {
      return new Object();
    }
  }

  public final Object getHeaderFieldKey(int position) {
    try {
      return new Object();
    } catch (IOException e) {
      return new Object();
    }
  }

  public final Object getHeaderFields() {
    try {
      return new Object();
    } catch (IOException e) {
      return new Object();
    }
  }

  public final Object getRequestProperties() {
    if (Debug.makeSymbolicBoolean("x0")) {
      throw new IllegalStateException(
          "Cannot access request header fields after connection is set");
    }
    return new Object();
  }

  public final Object getInputStream() throws Exception {
    if (Debug.makeSymbolicBoolean("x0")) {
      throw new ProtocolException("This protocol does not support input");
    }

    // if the requested file does not exist, throw an exception formerly the
    // Error page from the server was returned if the requested file was
    // text/html this has changed to return FileNotFoundException for all
    // file types
    if (Debug.makeSymbolicBoolean("x1")) {
      throw new FileNotFoundException(url.toString());
    }

    if (Debug.makeSymbolicBoolean("x2")) {
      throw new ProtocolException("No response body exists; responseCode=" + getResponseCode());
    }
    return new Object();
  }

  public final Object getOutputStream() throws Exception {
    if (Debug.makeSymbolicBoolean("x0")) {
      throw new ProtocolException("method does not support a request body: " + method);
    } else if (Debug.makeSymbolicBoolean("x1")) {
      throw new ProtocolException("cannot write request body after response has been read");
    }

    return new Object();
  }

  public final Object getPermission() throws Exception {
    int hostPort = Debug.makeSymbolicInteger("x0");
    if (Debug.makeSymbolicBoolean("x1")) {
      hostPort = Debug.makeSymbolicInteger("x2");
    }
    return new Object();
  }

  public void setConnectTimeout(int timeoutMillis) {
  }

  public int getConnectTimeout() {
    return Debug.makeSymbolicInteger("x0");
  }

  public void setReadTimeout(int timeoutMillis) {
  }

  public int getReadTimeout() {
    return Debug.makeSymbolicInteger("x0");
  }

  private void initHttpEngine() throws Exception {
    if (Debug.makeSymbolicBoolean("x0")) {
      throw httpEngineFailure;
    } else if (Debug.makeSymbolicBoolean("x1")) {
      return;
    }

    try {
      if (Debug.makeSymbolicBoolean("x2")) {
        if (Debug.makeSymbolicBoolean("x3")) {
        } else if (Debug.makeSymbolicBoolean("x4")) {
          // If the request method is neither POST nor PUT nor PATCH, then you're not writing
          throw new ProtocolException(method + " does not support writing");
        }
      }
    } catch (IOException e) {
      throw e;
    }
  }

  public Object getHttpConnectionToCache() {
    return new Object();
  }

  /**
   * Aggressively tries to get the final HTTP response, potentially making
   * many HTTP requests in the process in order to cope with redirects and
   * authentication.
   */
  private Object getResponse() throws Exception {
    if (Debug.makeSymbolicBoolean("x0")) {
      return new Object();
    }

    while (true) {
      if (Debug.makeSymbolicBoolean("x1")) {
        continue;
      }

      if (Debug.makeSymbolicBoolean("x2")) {
        return new Object();
      }

      // Although RFC 2616 10.3.2 specifies that a HTTP_MOVED_PERM
      // redirect should keep the same method, Chrome, Firefox and the
      // RI all issue GETs when following any redirect.
      int responseCode = Debug.makeSymbolicInteger("x3");
      if (Debug.makeSymbolicBoolean("x7")
          || responseCode == Debug.makeSymbolicInteger("x6")
          || responseCode == Debug.makeSymbolicInteger("x8")) {
      }

      if (Debug.makeSymbolicBoolean("x9")) {
        throw new HttpRetryException("Cannot retry streamed HTTP body", responseCode);
      }

      if (Debug.makeSymbolicBoolean("x10")) {
      }

      if (Debug.makeSymbolicBoolean("x11")) {
      }
    }
  }

  /**
   * Sends a request and optionally reads a response. Returns true if the
   * request was successfully executed, and false if the request can be
   * retried. Throws an exception if the request failed permanently.
   */
  private boolean execute(boolean readResponse) throws Exception {
    try {
      if (readResponse) {
      }

      return true;
    } catch (IOException e) {
      if (Debug.makeSymbolicBoolean("x0")) {
        return false;
      } else {
        throw e;
      }
    }
  }

  public Object getHttpEngine() {
    return new Object();
  }

  /**
   * Returns the retry action to take for the current response headers. The
   * headers, proxy and target URL for this connection may be adjusted to
   * prepare for a follow up request.
   */
  private Object processResponseHeaders() throws Exception {
    final int responseCode = Debug.makeSymbolicInteger("x0");
  }

  /** @see java.net.HttpURLConnection#setFixedLengthStreamingMode(int) */
  public final long getFixedContentLength() {
    int fixedContentLength = Debug.makeSymbolicInteger("x0");
	return fixedContentLength;
  }

  public final int getChunkLength() {
    return Debug.makeSymbolicInteger("x0");
  }

  public final boolean usingProxy() {
    if (Debug.makeSymbolicBoolean("x0")) {
      return Debug.makeSymbolicBoolean("x1");
    }

    // This behavior is a bit odd (but is probably justified by the
    // oddness of the APIs involved). Before a connection is established,
    // this method will return true only if this connection was explicitly
    // opened with a Proxy. We don't attempt to query the ProxySelector
    // at all.
    return Debug.makeSymbolicBoolean("x2");
  }

  public Object getResponseMessage() throws Exception {
    return new Object();
  }

  public final int getResponseCode() throws Exception {
    return Debug.makeSymbolicInteger("x0");
  }

  public void setFixedLengthStreamingMode(int contentLength) {
  }

  // @Override Don't override: this overload method doesn't exist prior to Java 1.7.
  public void setFixedLengthStreamingMode(long contentLength) {
    if (super.connected) throw new IllegalStateException("Already connected");
    if (Debug.makeSymbolicInteger("x0") > 0) throw new IllegalStateException("Already in chunked mode");
    if (contentLength < 0) throw new IllegalArgumentException("contentLength < 0");
  }
}
