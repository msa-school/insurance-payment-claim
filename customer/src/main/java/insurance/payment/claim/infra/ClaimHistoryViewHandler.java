package insurance.payment.claim.infra;

import insurance.payment.claim.config.kafka.KafkaProcessor;
import insurance.payment.claim.domain.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ClaimHistoryViewHandler {

    @Autowired
    private ClaimHistoryRepository claimHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenClaimReceived_then_CREATE_1(
        @Payload ClaimReceived claimReceived
    ) {
        try {
            if (!claimReceived.validate()) return;

            // view 객체 생성
            ClaimHistory claimHistory = new ClaimHistory();
            // view 객체에 이벤트의 Value 를 set 함
            claimHistory.setClaimId(claimReceived.getClaimId());
            claimHistory.setCustomerId(claimReceived.getCustomerId());
            claimHistory.setDiseaseCode(claimReceived.getDiseaseCode());
            claimHistory.setClaimDetails(claimReceived.getClaimDetails());
            claimHistory.setClaimDt(claimReceived.getClaimDt());
            claimHistory.setStatus(claimReceived.getStatus());
            // view 레파지 토리에 save
            claimHistoryRepository.save(claimHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReviewerAssigned_then_UPDATE_1(
        @Payload ReviewerAssigned reviewerAssigned
    ) {
        try {
            if (!reviewerAssigned.validate()) return;
            // view 객체 조회

            List<ClaimHistory> claimHistoryList = claimHistoryRepository.findByClaimId(
                reviewerAssigned.getClaimId()
            );
            for (ClaimHistory claimHistory : claimHistoryList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                claimHistory.setReviewerId(reviewerAssigned.getReviewerId());
                claimHistory.setReviewStatus(reviewerAssigned.getStatus());
                // view 레파지 토리에 save
                claimHistoryRepository.save(claimHistory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReviewCompleted_then_UPDATE_2(
        @Payload ReviewCompleted reviewCompleted
    ) {
        try {
            if (!reviewCompleted.validate()) return;
            // view 객체 조회

            List<ClaimHistory> claimHistoryList = claimHistoryRepository.findByClaimId(
                reviewCompleted.getClaimId()
            );
            for (ClaimHistory claimHistory : claimHistoryList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                claimHistory.setReviewStatus(reviewCompleted.getStatus());
                claimHistory.setReviewerId(reviewCompleted.getReviewerId());

                // view 레파지 토리에 save
                claimHistoryRepository.save(claimHistory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenClaimPaid_then_UPDATE_3(@Payload ClaimPaid claimPaid) {
        try {
            if (!claimPaid.validate()) return;
            // view 객체 조회

            List<ClaimHistory> claimHistoryList = claimHistoryRepository.findByClaimId(
                claimPaid.getClaimId()
            );
            for (ClaimHistory claimHistory : claimHistoryList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                claimHistory.setAmount(claimPaid.getAmount());
                claimHistory.setPaymentStatus(claimPaid.getStatus());
                // view 레파지 토리에 save
                claimHistoryRepository.save(claimHistory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenClaimCancelled_then_UPDATE_4(
        @Payload ClaimCancelled claimCancelled
    ) {
        try {
            if (!claimCancelled.validate()) return;
            // view 객체 조회

            List<ClaimHistory> claimHistoryList = claimHistoryRepository.findByClaimId(
                claimCancelled.getClaimId()
            );
            for (ClaimHistory claimHistory : claimHistoryList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                claimHistory.setStatus(claimCancelled.getStatus());
                // view 레파지 토리에 save
                claimHistoryRepository.save(claimHistory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReviewCancelled_then_UPDATE_5(
        @Payload ReviewCancelled reviewCancelled
    ) {
        try {
            if (!reviewCancelled.validate()) return;
            // view 객체 조회

            List<ClaimHistory> claimHistoryList = claimHistoryRepository.findByClaimId(
                reviewCancelled.getClaimId()
            );
            for (ClaimHistory claimHistory : claimHistoryList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                claimHistory.setReviewStatus(reviewCancelled.getStatus());
                // view 레파지 토리에 save
                claimHistoryRepository.save(claimHistory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCancelled_then_UPDATE_6(
        @Payload PaymentCancelled paymentCancelled
    ) {
        try {
            if (!paymentCancelled.validate()) return;
            // view 객체 조회

            List<ClaimHistory> claimHistoryList = claimHistoryRepository.findByClaimId(
                paymentCancelled.getClaimId()
            );
            for (ClaimHistory claimHistory : claimHistoryList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                claimHistory.setPaymentStatus(paymentCancelled.getStatus());
                // view 레파지 토리에 save
                claimHistoryRepository.save(claimHistory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
