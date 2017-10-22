package kafkaTest;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class MessageListener {

    public CountDownLatch latch = new CountDownLatch(3);

    @KafkaListener(topics="${message.topic.name}", group = "test-consumer-group")
    public void listenMessage(String message) {
        System.out.println("Recieved message: "+message);
        latch.countDown();
    }


}
