package org.wc;

import java.io.File;

public class WordPipeline {
    public static void main(String[] args) {
        File file = new File("/");
        String topic = "word";
        String bootstrap = "";
        PipeThread pipeThread = new PipeThread(file, topic, bootstrap);
        Thread thread = new Thread(pipeThread);
        thread.setDaemon(true);
        thread.start();
    }
}
