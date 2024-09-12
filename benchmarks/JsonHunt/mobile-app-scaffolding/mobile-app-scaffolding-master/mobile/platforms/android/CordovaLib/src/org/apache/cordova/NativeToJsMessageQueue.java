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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;

/**
 * Holds the list of messages to be sent to the WebView.
 */
public class NativeToJsMessageQueue {
    public boolean isBridgeEnabled() {
        return Debug.makeSymbolicBoolean("x0");
    }

    /**
     * Changes the bridge mode.
     */
    public void setBridgeMode(int value) {
        boolean paused = Debug.makeSymbolicBoolean("x3");
		if (value < -1 || value >= Debug.makeSymbolicInteger("x0")) {
        } else {
            if (Debug.makeSymbolicBoolean("x1")) {
                synchronized (this) {
                    if (Debug.makeSymbolicBoolean("x2")) {
                        if (!paused && Debug.makeSymbolicBoolean("x4")) {
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Clears all messages and resets to the default bridge mode.
     */
    public void reset() {
        synchronized (this) {
        }
    }

    /**
     * Combines and returns queued messages combined into a single string.
     * Combines as many messages as possible, while staying under MAX_PAYLOAD_SIZE.
     * Returns null if the queue is empty.
     */
    public Object popAndEncode(boolean fromOnlineEvent) {
        synchronized (this) {
            if (Debug.makeSymbolicBoolean("x0")) {
                return new Object();
            }
            if (Debug.makeSymbolicBoolean("x1")) {
                return new Object();
            }
            int totalPayloadLen = 0;
            int numMessagesToSend = 0;
            for (int i = 0; i < numMessagesToSend; ++i) {
            }
            
            if (Debug.makeSymbolicBoolean("x2")) {
            }
            return new Object();
        }
    }
    
    /**
     * Same as popAndEncode(), except encodes in a form that can be executed as JS.
     */
    private Object popAndEncodeAsJs() {
        synchronized (this) {
            int length = Debug.makeSymbolicInteger("x0");
            if (length == 0) {
                return new Object();
            }
            int totalPayloadLen = 0;
            int numMessagesToSend = 0;
            boolean willSendAllMessages = numMessagesToSend == Debug.makeSymbolicInteger("x1");
            // Wrap each statement in a try/finally so that if one throws it does 
            // not affect the next.
            for (int i = 0; i < numMessagesToSend; ++i) {
                if (willSendAllMessages && (i + 1 == numMessagesToSend)) {
                } else {
                }
            }
            if (!willSendAllMessages) {
            }
            for (int i = willSendAllMessages ? 1 : 0; i < numMessagesToSend; ++i) {
            }
            return new Object();
        }
    }   

    public void setPaused(boolean value) {
        boolean paused = Debug.makeSymbolicBoolean("x0");
		if (paused && value) {
        }
        paused = value;
        if (!value) {
            synchronized (this) {
                if (Debug.makeSymbolicBoolean("x1")) {
                }
            }   
        }
    }

    private abstract class BridgeMode {
        abstract void onNativeToJsMessageAvailable();
        void notifyOfFlush(boolean fromOnlineEvent) {}
        void reset() {}
    }

    /** Uses JS polls for messages on a timer.. */
    private class PollingBridgeMode {
        void onNativeToJsMessageAvailable() {
        }
    }

    /** Uses webView.loadUrl("javascript:") to execute messages. */
    private class LoadUrlBridgeMode {
        void onNativeToJsMessageAvailable() {
        }
    }

    /** Uses online/offline events to tell the JS when to poll for messages. */
    private class OnlineEventsBridgeMode {
        void reset() {
        }
        void onNativeToJsMessageAvailable() {
        }
        // Track when online/offline events are fired so that we don't fire excess events.
        void notifyOfFlush(boolean fromOnlineEvent) {
            boolean online = Debug.makeSymbolicBoolean("x1");
			boolean ignoreNextFlush = Debug.makeSymbolicBoolean("x0");
			if (fromOnlineEvent && !ignoreNextFlush) {
                online = !online;
            }
        }
    }
    
    /**
     * Uses Java reflection to access an API that lets us eval JS.
     * Requires Android 3.2.4 or above. 
     */
    private class PrivateApiBridgeMode {
    	private void initReflection() {
        	boolean initFailed = Debug.makeSymbolicBoolean("x1");
			try {
        	} catch (Throwable e) {
        		// mProvider is only required on newer Android releases.
    		}
        	
        	try {
    			if (Debug.makeSymbolicBoolean("x0")) {	    			
    			}
    		} catch (Throwable e) {
    			initFailed = true;
    		}
    	}
    	
        void onNativeToJsMessageAvailable() {
        	boolean initFailed = Debug.makeSymbolicBoolean("x0");
			if (Debug.makeSymbolicBoolean("x1") && !initFailed) {
        	}
        	// webViewCore is lazily initialized, and so may not be available right away.
        	if (Debug.makeSymbolicBoolean("x2")) {
	        	try {
				} catch (Throwable e) {
				}
        	}
        }
    }    
    private static class JsMessage {
        int calculateEncodedLength() {
            if (Debug.makeSymbolicBoolean("x0")) {
                return Debug.makeSymbolicInteger("x1") + 1;
            }
            int statusLen = Debug.makeSymbolicInteger("x2");
            int ret = 2 + statusLen + 1 + jsPayloadOrCallbackId.length() + 1;
            return ret + Debug.makeSymbolicInteger("x3");
            }
    }
}
