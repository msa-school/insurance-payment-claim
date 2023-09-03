package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import insurance.payment.claim.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewCompleted extends AbstractEvent {

    private Long reviewId;
    private Long claimId;
    private Long reviewerId;
    private Date reviewDt;
    private String reviewDetails;
    private String status;

    public ReviewCompleted(Review aggregate) {
        super(aggregate);
    }

    public ReviewCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
