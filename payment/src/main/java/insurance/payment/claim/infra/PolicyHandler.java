package insurance.payment.claim.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import insurance.payment.claim.config.kafka.KafkaProcessor;
import insurance.payment.claim.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReviewCompleted'"
    )
    public void wheneverReviewCompleted_PayClaim(
        @Payload ReviewCompleted reviewCompleted
    ) {
        ReviewCompleted event = reviewCompleted;
        System.out.println(
            "\n\n##### listener PayClaim : " + reviewCompleted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReviewCancelled'"
    )
    public void wheneverReviewCancelled_CancelPayment(
        @Payload ReviewCancelled reviewCancelled
    ) {
        ReviewCancelled event = reviewCancelled;
        System.out.println(
            "\n\n##### listener CancelPayment : " + reviewCancelled + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
