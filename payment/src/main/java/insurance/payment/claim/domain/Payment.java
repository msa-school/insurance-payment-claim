package insurance.payment.claim.domain;

import insurance.payment.claim.PaymentApplication;
import insurance.payment.claim.domain.ClaimPaid;
import insurance.payment.claim.domain.PaymentCancelled;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
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

    @PreUpdate
    public void onPreUpdate() {}

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }
}
//>>> DDD / Aggregate Root
