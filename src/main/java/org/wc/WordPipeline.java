package org.wc;

import java.io.File;

public class WordPipeline {
    public static void main(String[] args) {
        File file = new File(System.getenv("FILE_PATH"));
        String topic = System.getenv("KAFKA_TOPIC");
        String bootstrap = System.getenv("KAFKA_SERVER");
        PipeThread pipeThread = new PipeThread(file, topic, bootstrap);
        Thread thread = new Thread(pipeThread);
        thread.setDaemon(true);
        thread.start();
    }
}
