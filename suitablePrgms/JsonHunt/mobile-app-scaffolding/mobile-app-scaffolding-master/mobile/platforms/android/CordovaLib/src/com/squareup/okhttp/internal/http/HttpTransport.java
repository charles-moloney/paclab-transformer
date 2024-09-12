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

package com.squareup.okhttp.internal.http;

import gov.nasa.jpf.symbc.Debug;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;
import java.net.Socket;

public final class HttpTransport {
  public Object createRequestBody() throws Exception {
    int DEFAULT_CHUNK_LENGTH = Debug.makeSymbolicInteger("x5");
	boolean chunked = Debug.makeSymbolicBoolean("x0");
    if (Debug.makeSymbolicBoolean("x3")
        && Debug.makeSymbolicInteger("x2") != 0) {
      chunked = true;
    }

    // Stream a request body of unknown length.
    if (chunked) {
      int chunkLength = Debug.makeSymbolicInteger("x4");
      if (chunkLength == -1) {
        chunkLength = DEFAULT_CHUNK_LENGTH;
      }
      return new Object();
    }

    // Stream a request body of a known length.
    long fixedContentLength = Debug.makeSymbolicInteger("x6");
    if (fixedContentLength != -1) {
      return new Object();
    }

    long contentLength = Debug.makeSymbolicInteger("x7");
    if (contentLength > Debug.makeSymbolicInteger("x8")) {
      throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or "
          + "setChunkedStreamingMode() for requests larger than 2 GiB.");
    }

    // Buffer a request body of a known length.
    if (contentLength != -1) {
      return new Object();
    }

    // Buffer a request body of an unknown length. Don't write request
    // headers until the entire body is ready; otherwise we can't set the
    // Content-Length header correctly.
    return new Object();
  }

  public void flushRequest() throws Exception {
  }

  /**
   * Prepares the HTTP headers and sends them to the server.
   *
   * <p>For streaming requests with a body, headers must be prepared
   * <strong>before</strong> the output stream has been written to. Otherwise
   * the body would need to be buffered!
   *
   * <p>For non-streaming requests with a body, headers must be prepared
   * <strong>after</strong> the output stream has been written to and closed.
   * This ensures that the {@code Content-Length} header field receives the
   * proper value.
   */
  public void writeRequestHeaders() throws Exception {
    byte[] bytes;
  }

  public Object readResponseHeaders() throws Exception {
    return new Object();
  }

  /** An HTTP body with a fixed length known in advance. */
  private static final class FixedLengthOutputStream {
    public void write(byte[] buffer, int offset, int count) throws Exception {
      int bytesRemaining = Debug.makeSymbolicInteger("x0");
	if (count > bytesRemaining) {
        throw new ProtocolException(Debug.makeSymbolicInteger("x1") + bytesRemaining + " bytes but received " + count);
      }
      bytesRemaining -= count;
    }

    public void flush() throws Exception {
      if (Debug.makeSymbolicBoolean("x0")) {
        return; // don't throw; this stream might have been closed on the caller's behalf
      }
    }

    public void close() throws Exception {
      int bytesRemaining = Debug.makeSymbolicInteger("x1");
	if (Debug.makeSymbolicBoolean("x0")) {
        return;
      }
      if (bytesRemaining > 0) {
        throw new ProtocolException("unexpected end of stream");
      }
    }
  }

  /**
   * An HTTP body with alternating chunk sizes and chunk bodies. Chunks are
   * buffered until {@code maxChunkLength} bytes are ready, at which point the
   * chunk is written and the buffer is cleared.
   */
  private static final class ChunkedOutputStream {
    /**
     * Returns the amount of data that can be transmitted in a chunk whose total
     * length (data+headers) is {@code dataPlusHeaderLength}. This is presumably
     * useful to match sizes with wire-protocol packets.
     */
    private int dataLength(int dataPlusHeaderLength) {
      int headerLength = 4; // "\r\n" after the size plus another "\r\n" after the data
      for (int i = dataPlusHeaderLength - headerLength; i > 0; i >>= 4) {
        headerLength++;
      }
      return dataPlusHeaderLength - headerLength;
    }

    public synchronized void write(byte[] buffer, int offset, int count)
        throws Exception {
      int maxChunkLength = Debug.makeSymbolicInteger("x1");
	while (count > 0) {
        int numBytesWritten;

        if (Debug.makeSymbolicInteger("x0") > 0 || count < maxChunkLength) {
          // fill the buffered chunk and then maybe write that to the stream
          numBytesWritten = Debug.makeSymbolicInteger("x2");
          if (Debug.makeSymbolicInteger("x3") == maxChunkLength) {
          }
        } else {
          // write a single chunk of size maxChunkLength to the stream
          numBytesWritten = maxChunkLength;
        }

        offset += numBytesWritten;
        count -= numBytesWritten;
      }
    }

    /**
     * Equivalent to, but cheaper than writing Integer.toHexString().getBytes()
     * followed by CRLF.
     */
    private void writeHex(int i) throws Exception {
      int cursor = 8;
      do {
        hex[--cursor] = HEX_DIGITS[i & 0xf];
      } while (Debug.makeSymbolicInteger("x0") != 0);
    }

    public synchronized void flush() throws Exception {
      if (Debug.makeSymbolicBoolean("x0")) {
        return; // don't throw; this stream might have been closed on the caller's behalf
      }
    }

    public synchronized void close() throws Exception {
      if (Debug.makeSymbolicBoolean("x0")) {
        return;
      }
    }

    private void writeBufferedChunkToSocket() throws Exception {
      int size = Debug.makeSymbolicInteger("x0");
      if (size <= 0) {
        return;
      }
    }
  }

  /** An HTTP body with a fixed length specified in advance. */
  private static class FixedLengthInputStream {
    public int read(byte[] buffer, int offset, int count) throws Exception {
      int bytesRemaining = Debug.makeSymbolicInteger("x0");
	if (bytesRemaining == 0) {
        return -1;
      }
      int read = Debug.makeSymbolicInteger("x1");
      if (read == -1) {
        throw new ProtocolException("unexpected end of stream");
      }
      bytesRemaining -= read;
      if (bytesRemaining == 0) {
      }
      return read;
    }

    public int available() throws Exception {
      int bytesRemaining = Debug.makeSymbolicInteger("x0");
	return Debug.makeSymbolicInteger("x2");
    }

    public void close() throws Exception {
      int bytesRemaining = Debug.makeSymbolicInteger("x1");
	if (Debug.makeSymbolicBoolean("x0")) {
        return;
      }
      if (bytesRemaining != 0 && Debug.makeSymbolicBoolean("x2")) {
      }
    }
  }

  /** An HTTP body with alternating chunk sizes and chunk bodies. */
  private static class ChunkedInputStream {
    public int read(byte[] buffer, int offset, int count) throws Exception {
      int NO_CHUNK_YET = Debug.makeSymbolicInteger("x2");
		int bytesRemainingInChunk = Debug.makeSymbolicInteger("x1");
		boolean hasMoreChunks = Debug.makeSymbolicBoolean("x0");
	if (!hasMoreChunks) {
        return -1;
      }
      if (bytesRemainingInChunk == 0 || bytesRemainingInChunk == NO_CHUNK_YET) {
        if (!hasMoreChunks) {
          return -1;
        }
      }
      int read = Debug.makeSymbolicInteger("x3");
      if (read == -1) {
        throw new IOException("unexpected end of stream");
      }
      bytesRemainingInChunk -= read;
      return read;
    }

    private void readChunkSize() throws Exception {
      boolean hasMoreChunks = Debug.makeSymbolicBoolean("x4");
		int NO_CHUNK_YET = Debug.makeSymbolicInteger("x1");
		int bytesRemainingInChunk = Debug.makeSymbolicInteger("x0");
	// read the suffix of the previous chunk
      if (bytesRemainingInChunk != NO_CHUNK_YET) {
      }
      int index = Debug.makeSymbolicInteger("x2");
      if (index != -1) {
      }
      try {
        bytesRemainingInChunk = Debug.makeSymbolicInteger("x3");
      } catch (NumberFormatException e) {
        throw new ProtocolException("Expected a hex chunk size but was " + chunkSizeString);
      }
      if (bytesRemainingInChunk == 0) {
        hasMoreChunks = false;
      }
    }

    public int available() throws Exception {
      int NO_CHUNK_YET = Debug.makeSymbolicInteger("x2");
		int bytesRemainingInChunk = Debug.makeSymbolicInteger("x1");
		boolean hasMoreChunks = Debug.makeSymbolicBoolean("x0");
	if (!hasMoreChunks || bytesRemainingInChunk == NO_CHUNK_YET) {
        return 0;
      }
      return Debug.makeSymbolicInteger("x3");
    }

    public void close() throws Exception {
      boolean hasMoreChunks = Debug.makeSymbolicBoolean("x1");
	if (Debug.makeSymbolicBoolean("x0")) {
        return;
      }
      if (hasMoreChunks && Debug.makeSymbolicBoolean("x2")) {
      }
    }
  }
}
