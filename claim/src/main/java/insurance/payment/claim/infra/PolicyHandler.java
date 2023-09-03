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
    ClaimRepository claimRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReviewerAssigned'"
    )
    public void wheneverReviewerAssigned_UpdateStatus(
        @Payload ReviewerAssigned reviewerAssigned
    ) {
        ReviewerAssigned event = reviewerAssigned;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + reviewerAssigned + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReviewCompleted'"
    )
    public void wheneverReviewCompleted_UpdateStatus(
        @Payload ReviewCompleted reviewCompleted
    ) {
        ReviewCompleted event = reviewCompleted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + reviewCompleted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReviewCancelled'"
    )
    public void wheneverReviewCancelled_UpdateStatus(
        @Payload ReviewCancelled reviewCancelled
    ) {
        ReviewCancelled event = reviewCancelled;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + reviewCancelled + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCancelled'"
    )
    public void wheneverPaymentCancelled_UpdateStatus(
        @Payload PaymentCancelled paymentCancelled
    ) {
        PaymentCancelled event = paymentCancelled;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + paymentCancelled + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ClaimPaid'"
    )
    public void wheneverClaimPaid_UpdateStatus(@Payload ClaimPaid claimPaid) {
        ClaimPaid event = claimPaid;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + claimPaid + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
