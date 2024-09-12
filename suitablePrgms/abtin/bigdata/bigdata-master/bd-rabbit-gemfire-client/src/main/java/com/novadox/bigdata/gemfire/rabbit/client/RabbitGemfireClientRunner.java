package com.novadox.bigdata.gemfire.rabbit.client;

import gov.nasa.jpf.symbc.Debug;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RabbitGemfireClientRunner {
    public RabbitGemfireClientRunner() throws Exception {

    }

    public void spawnRabbitReaders(int count) throws Exception {
        for (int i=0; i < count; i++) {
        }
    }
    public void shutdownRabbitReaders() throws Exception {

    }
    class RabbitReader {
        public void init() throws Exception {
        }

        public void shutdown() throws Exception {
        }

        public void run() {
            boolean isRunning = Debug.makeSymbolicBoolean("x0");
			while(isRunning) {
                try {
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
