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

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReviewerRepository reviewerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ClaimCancelled'"
    )
    public void wheneverClaimCancelled_CancelReview(@Payload ClaimCancelled claimCancelled) {
        ClaimCancelled event = claimCancelled;
        Review.cancelReview(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ClaimReceived'"
    )
    public void wheneverClaimReceived_AssignReview(@Payload ClaimReceived claimReceived) {
        ClaimReceived event = claimReceived;
        Review.assignReview(event);

    }
}
