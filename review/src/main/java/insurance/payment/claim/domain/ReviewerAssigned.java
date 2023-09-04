package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import insurance.payment.claim.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ReviewerAssigned extends AbstractEvent {

    private Long reviewId;
    private Long claimId;
    private Long reviewerId;
    private Date reviewDt;
    private String reviewDetails;
    private String status;

    public ReviewerAssigned(Review aggregate) {
        super(aggregate);
    }

    public ReviewerAssigned() {
        super();
    }
}
