package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import insurance.payment.claim.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewCancelled extends AbstractEvent {

    private Long reviewId;
    private Long claimId;
    private Long reviewerId;
    private Date reviewDt;
    private String reviewDetails;
    private String status;

    public ReviewCancelled(Review aggregate) {
        super(aggregate);
    }

    public ReviewCancelled() {
        super();
    }
}
//>>> DDD / Domain Event