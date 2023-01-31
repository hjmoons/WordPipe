package org.wc;

import java.io.File;

public class WordPipeline {
    public static final String FILE_PATH = "/app/data/word.txt";
    public static final String KAFKA_TOPIC = System.getenv("KAFKA_TOPIC");
    public static final String KAFKA_SERVER = System.getenv("KAFKA_SERVER");
    public static void main(String[] args) {
        System.out.println("* * * * *" +
                "\nConfig Info" +
                "\nFILE_PATH : " + FILE_PATH +
                "\nKAFKA_TOPIC : " + KAFKA_TOPIC +
                "\nKAFKA_SERVER : " + KAFKA_SERVER +
                "\n* * * * *");

        Thread thread = new Thread(new PipeThread(new File(FILE_PATH), KAFKA_TOPIC, KAFKA_SERVER));
        thread.start();
    }
}
