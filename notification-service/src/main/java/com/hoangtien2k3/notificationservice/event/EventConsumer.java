package com.hoangtien2k3.notificationservice.event;

import com.google.gson.Gson;
import com.hoangtien2k3.notificationservice.constant.KafkaConstant;
import com.hoangtien2k3.notificationservice.dto.EmailDetails;
import com.hoangtien2k3.notificationservice.dto.PostNewsDto;
import com.hoangtien2k3.notificationservice.service.EmailService;
import com.hoangtien2k3.notificationservice.service.PostNewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.function.Consumer;

@Service
@Slf4j
public class EventConsumer {

    Gson gson = new Gson(); // convert Json -> DTO

    @Autowired
    private EmailService emailService;

    @Autowired
    private PostNewsService paymentService;

    @Autowired
    private EventProducer eventProducer;

    public EventConsumer(ReceiverOptions<String, String> receiverOptions) {
        subscribeToTopic(receiverOptions, KafkaConstant.PROFILE_ONBOARDING_TOPIC, this::sendEmailKafkaOnboarding);
        subscribeToTopic(receiverOptions, KafkaConstant.STATUS_PAYMENT_SUCCESSFUL, this::paymentOrderKafkaOnboarding);
    }

    private void subscribeToTopic(
            ReceiverOptions<String,
                    String> receiverOptions,
                    String topic,
                    Consumer<ReceiverRecord<String, String>> handler
    ) {
        KafkaReceiver.create(receiverOptions.subscription(Collections.singleton(topic)))
                .receive()
                .subscribe(handler);
    }

    public void sendEmailKafkaOnboarding(ReceiverRecord<String, String> receiverRecord) {
        EmailDetails emailDetails = gson.fromJson(receiverRecord.value(), EmailDetails.class);

        emailService.sendSimpleMail(emailDetails).subscribe(email -> {
            eventProducer.send(KafkaConstant.PROFILE_ONBOARDED_TOPIC, gson.toJson(email)).subscribe();
        });
    }

    public void paymentOrderKafkaOnboarding(ReceiverRecord<String, String> receiverRecord) {
        PostNewsDto postNewsDto = gson.fromJson(receiverRecord.value(), PostNewsDto.class);
        paymentService.savePostNews(postNewsDto).subscribe(res -> {
            eventProducer.send(KafkaConstant.PROFILE_ONBOARDED_TOPIC, gson.toJson(postNewsDto)).subscribe();
        });

        EmailDetails emailDetails = EmailDetails.builder()
                .recipient("hoangtien2k3dev@gmail.com")
                .msgBody(msgBody(postNewsDto.getTitle(), postNewsDto.getLink(), postNewsDto.getImg()))
                .subject("PostNews Successfully in news with userId: " + postNewsDto.getTitle())
                .attachment("Please, check the full information in: " + LocalDateTime.now())
                .build();
        emailService.sendSimpleMail(emailDetails).subscribe(email -> {
            eventProducer.send(KafkaConstant.PROFILE_ONBOARDED_TOPIC, gson.toJson(email)).subscribe();
        });

    }

    public String msgBody(String title, String link, String img) {
        return "Post News in category admin successfully: \n " +
                " + Title: " + title +
                "\n + Link: " + link +
                "\n\nImg: " + img +
                "\nDate: " + LocalTime.now();
    }

}