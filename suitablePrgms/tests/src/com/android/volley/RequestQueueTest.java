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

package com.android.volley;

import gov.nasa.jpf.symbc.Debug;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueueTest {
    protected void setUp() throws Exception {
    }

    /**
     * Make a list of requests with random priorities.
     * @param count Number of requests to make
     */
    private Object makeRequests(int count) {
        for (int i = 0; i < count; i++) {
        }
        return new Object();
    }

    public void testAdd_requestProcessedInCorrectOrder() throws Exception {
        int requestsToMake = 100;
    }

    public void testAdd_dedupeByCacheKey() throws Exception {
    }

    public void testCancelAll_onlyCorrectTag() throws Exception {
    }

    private class OrderCheckingNetwork {
        public void setExpectedRequests(int expectedRequests) {
            // Leave one permit available so the waiter can find it.
            expectedRequests--;
        }

        public void waitUntilExpectedDone(long timeout)
                throws Exception {
            if (Debug.makeSymbolicBoolean("x0") == false) {
                throw new TimeoutError();
            }
        }
    }

    private class DelayedRequest {
    }

}
