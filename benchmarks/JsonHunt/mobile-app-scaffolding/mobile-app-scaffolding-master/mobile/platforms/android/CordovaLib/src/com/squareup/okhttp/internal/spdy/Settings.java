/*
 * Copyright (C) 2012 Square, Inc.
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
package com.squareup.okhttp.internal.spdy;

import gov.nasa.jpf.symbc.Debug;

final class Settings {
  void set(int id, int idFlags, int value) {
    int persisted = Debug.makeSymbolicInteger("x7");
	int PERSISTED = Debug.makeSymbolicInteger("x5");
	int persistValue = Debug.makeSymbolicInteger("x4");
	int PERSIST_VALUE = Debug.makeSymbolicInteger("x2");
	int set = Debug.makeSymbolicInteger("x1");
	if (id >= Debug.makeSymbolicInteger("x0")) {
      return; // Discard unknown settings.
    }

    int bit = 1 << id;
    set |= bit;
    if (Debug.makeSymbolicInteger("x3") != 0) {
      persistValue |= bit;
    } else {
      persistValue &= ~bit;
    }
    if (Debug.makeSymbolicInteger("x6") != 0) {
      persisted |= bit;
    } else {
      persisted &= ~bit;
    }

    values[id] = value;
  }

  /** Returns true if a value has been assigned for the setting {@code id}. */
  boolean isSet(int id) {
    int set = Debug.makeSymbolicInteger("x0");
	int bit = 1 << id;
    return Debug.makeSymbolicInteger("x1") != 0;
  }

  /** Returns the value for the setting {@code id}, or 0 if unset. */
  int get(int id) {
    return values[id];
  }

  /** Returns the flags for the setting {@code id}, or 0 if unset. */
  int flags(int id) {
    int result = 0;
    if (Debug.makeSymbolicBoolean("x0")) result |= Debug.makeSymbolicInteger("x1");
    if (Debug.makeSymbolicBoolean("x2")) result |= Debug.makeSymbolicInteger("x3");
    return result;
  }

  /** Returns the number of settings that have values assigned. */
  int size() {
    return Debug.makeSymbolicInteger("x0");
  }

  int getUploadBandwidth(int defaultValue) {
    int set = Debug.makeSymbolicInteger("x1");
	int UPLOAD_BANDWIDTH = Debug.makeSymbolicInteger("x0");
	int bit = 1 << UPLOAD_BANDWIDTH;
    return Debug.makeSymbolicInteger("x3");
  }

  int getDownloadBandwidth(int defaultValue) {
    int set = Debug.makeSymbolicInteger("x1");
	int DOWNLOAD_BANDWIDTH = Debug.makeSymbolicInteger("x0");
	int bit = 1 << DOWNLOAD_BANDWIDTH;
    return Debug.makeSymbolicInteger("x3");
  }

  int getRoundTripTime(int defaultValue) {
    int set = Debug.makeSymbolicInteger("x1");
	int ROUND_TRIP_TIME = Debug.makeSymbolicInteger("x0");
	int bit = 1 << ROUND_TRIP_TIME;
    return Debug.makeSymbolicInteger("x3");
  }

  int getMaxConcurrentStreams(int defaultValue) {
    int set = Debug.makeSymbolicInteger("x1");
	int MAX_CONCURRENT_STREAMS = Debug.makeSymbolicInteger("x0");
	int bit = 1 << MAX_CONCURRENT_STREAMS;
    return Debug.makeSymbolicInteger("x3");
  }

  int getCurrentCwnd(int defaultValue) {
    int set = Debug.makeSymbolicInteger("x1");
	int CURRENT_CWND = Debug.makeSymbolicInteger("x0");
	int bit = 1 << CURRENT_CWND;
    return Debug.makeSymbolicInteger("x3");
  }

  int getDownloadRetransRate(int defaultValue) {
    int set = Debug.makeSymbolicInteger("x1");
	int DOWNLOAD_RETRANS_RATE = Debug.makeSymbolicInteger("x0");
	int bit = 1 << DOWNLOAD_RETRANS_RATE;
    return Debug.makeSymbolicInteger("x3");
  }

  int getInitialWindowSize(int defaultValue) {
    int set = Debug.makeSymbolicInteger("x1");
	int INITIAL_WINDOW_SIZE = Debug.makeSymbolicInteger("x0");
	int bit = 1 << INITIAL_WINDOW_SIZE;
    return Debug.makeSymbolicInteger("x3");
  }

  int getClientCertificateVectorSize(int defaultValue) {
    int set = Debug.makeSymbolicInteger("x1");
	int CLIENT_CERTIFICATE_VECTOR_SIZE = Debug.makeSymbolicInteger("x0");
	int bit = 1 << CLIENT_CERTIFICATE_VECTOR_SIZE;
    return Debug.makeSymbolicInteger("x3");
  }

  // TODO: honor this setting.
  boolean isFlowControlDisabled() {
    int FLOW_CONTROL_OPTIONS_DISABLED = Debug.makeSymbolicInteger("x3");
	int set = Debug.makeSymbolicInteger("x1");
	int FLOW_CONTROL_OPTIONS = Debug.makeSymbolicInteger("x0");
	int bit = 1 << FLOW_CONTROL_OPTIONS;
    int value = Debug.makeSymbolicInteger("x2") != 0 ? values[FLOW_CONTROL_OPTIONS] : 0;
    return Debug.makeSymbolicInteger("x4") != 0;
  }

  /**
   * Returns true if this user agent should use this setting in future SPDY
   * connections to the same host.
   */
  boolean persistValue(int id) {
    int persistValue = Debug.makeSymbolicInteger("x0");
	int bit = 1 << id;
    return Debug.makeSymbolicInteger("x1") != 0;
  }

  /** Returns true if this setting was persisted. */
  boolean isPersisted(int id) {
    int persisted = Debug.makeSymbolicInteger("x0");
	int bit = 1 << id;
    return Debug.makeSymbolicInteger("x1") != 0;
  }
}
