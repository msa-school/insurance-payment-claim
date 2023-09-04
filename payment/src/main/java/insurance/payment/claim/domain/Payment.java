package insurance.payment.claim.domain;

import insurance.payment.claim.PaymentApplication;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private Long claimId;
    private Long reviewId;
    private Double amount;
    private Date paymentDt;
    private String status;

    @PostPersist
    public void onPostPersist() {
        ClaimPaid claimPaid = new ClaimPaid(this);
        claimPaid.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        PaymentCancelled paymentCancelled = new PaymentCancelled(this);
        paymentCancelled.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void payClaim(ReviewCompleted reviewCompleted) {
        Payment payment = new Payment();
        payment.setClaimId(reviewCompleted.getClaimId());
        payment.setReviewId(reviewCompleted.getReviewId());
        payment.setStatus(ClaimPaid.class.getSimpleName());
        repository().save(payment);
    }

    public static void cancelPayment(ReviewCancelled reviewCancelled) {
        repository().findByClaimId(reviewCancelled.getClaimId()).ifPresent(payment->{
            payment.setStatus(PaymentCancelled.class.getSimpleName());
            repository().save(payment);
         });
    }
}
