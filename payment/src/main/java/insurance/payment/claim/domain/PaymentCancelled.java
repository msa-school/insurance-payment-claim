package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import insurance.payment.claim.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long paymentId;
    private Long claimId;
    private Long reviewId;
    private Double amount;
    private Date paymentDt;
    private String status;

    public PaymentCancelled(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
