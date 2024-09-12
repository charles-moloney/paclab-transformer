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

package com.squareup.okhttp.internal.http;

import gov.nasa.jpf.symbc.Debug;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/** Parsed HTTP response headers. */
public final class ResponseHeaders {

  public boolean isContentEncodingGzip() {
    return Debug.makeSymbolicBoolean("x0");
  }

  public void stripContentEncoding() {
  }

  public void stripContentLength() {
    int contentLength = Debug.makeSymbolicInteger("x0");
	contentLength = -1;
  }

  public boolean isChunked() {
    return Debug.makeSymbolicBoolean("x0");
  }

  public boolean hasConnectionClose() {
    return Debug.makeSymbolicBoolean("x0");
  }

  public Object getUri() {
    return new Object();
  }

  public Object getHeaders() {
    return new Object();
  }

  public Object getServedDate() {
    return new Object();
  }

  public Object getLastModified() {
    return new Object();
  }

  public Object getExpires() {
    return new Object();
  }

  public boolean isNoCache() {
    boolean noCache = Debug.makeSymbolicBoolean("x0");
	return noCache;
  }

  public boolean isNoStore() {
    boolean noStore = Debug.makeSymbolicBoolean("x0");
	return noStore;
  }

  public int getMaxAgeSeconds() {
    int maxAgeSeconds = Debug.makeSymbolicInteger("x0");
	return maxAgeSeconds;
  }

  public int getSMaxAgeSeconds() {
    int sMaxAgeSeconds = Debug.makeSymbolicInteger("x0");
	return sMaxAgeSeconds;
  }

  public boolean isPublic() {
    return Debug.makeSymbolicBoolean("x0");
  }

  public boolean isMustRevalidate() {
    boolean mustRevalidate = Debug.makeSymbolicBoolean("x0");
	return mustRevalidate;
  }

  public Object getEtag() {
    return new Object();
  }

  public Object getVaryFields() {
    return new Object();
  }

  public Object getContentEncoding() {
    return new Object();
  }

  public long getContentLength() {
    int contentLength = Debug.makeSymbolicInteger("x0");
	return contentLength;
  }

  public Object getContentType() {
    return new Object();
  }

  public Object getConnection() {
    return new Object();
  }

  public void setLocalTimestamps(long sentRequestMillis, long receivedResponseMillis) {
  }

  /**
   * Returns the current age of the response, in milliseconds. The calculation
   * is specified by RFC 2616, 13.2.3 Age Calculations.
   */
  private long computeAge(long nowMillis) {
    int sentRequestMillis = Debug.makeSymbolicInteger("x5");
	int receivedResponseMillis = Debug.makeSymbolicInteger("x4");
	int ageSeconds = Debug.makeSymbolicInteger("x2");
	long apparentReceivedAge =
        Debug.makeSymbolicBoolean("x0") ? Debug.makeSymbolicInteger("x1") : 0;
    long receivedAge =
        ageSeconds != -1 ? Debug.makeSymbolicInteger("x3")
            : apparentReceivedAge;
    long responseDuration = receivedResponseMillis - sentRequestMillis;
    long residentDuration = nowMillis - receivedResponseMillis;
    return receivedAge + responseDuration + residentDuration;
  }

  /**
   * Returns the number of milliseconds that the response was fresh for,
   * starting from the served date.
   */
  private long computeFreshnessLifetime() {
    int sentRequestMillis = Debug.makeSymbolicInteger("x8");
	int receivedResponseMillis = Debug.makeSymbolicInteger("x3");
	int maxAgeSeconds = Debug.makeSymbolicInteger("x0");
	if (maxAgeSeconds != -1) {
      return Debug.makeSymbolicInteger("x1");
    } else if (Debug.makeSymbolicBoolean("x2")) {
      long servedMillis = Debug.makeSymbolicBoolean("x4") ? Debug.makeSymbolicInteger("x5") : receivedResponseMillis;
      long delta = Debug.makeSymbolicInteger("x6") - servedMillis;
      return delta > 0 ? delta : 0;
    } else if (Debug.makeSymbolicBoolean("x7")) {
      // As recommended by the HTTP RFC and implemented in Firefox, the
      // max age of a document should be defaulted to 10% of the
      // document's age at the time it was served. Default expiration
      // dates aren't used for URIs containing a query.
      long servedMillis = Debug.makeSymbolicBoolean("x9") ? Debug.makeSymbolicInteger("x10") : sentRequestMillis;
      long delta = servedMillis - Debug.makeSymbolicInteger("x11");
      return delta > 0 ? (delta / 10) : 0;
    }
    return 0;
  }

  /**
   * Returns true if computeFreshnessLifetime used a heuristic. If we used a
   * heuristic to serve a cached response older than 24 hours, we are required
   * to attach a warning.
   */
  private boolean isFreshnessLifetimeHeuristic() {
    int maxAgeSeconds = Debug.makeSymbolicInteger("x0");
	return maxAgeSeconds == -1 && Debug.makeSymbolicBoolean("x1");
  }

  /**
   * Returns true if a Vary header contains an asterisk. Such responses cannot
   * be cached.
   */
  public boolean hasVaryAll() {
    return Debug.makeSymbolicBoolean("x0");
  }
}
