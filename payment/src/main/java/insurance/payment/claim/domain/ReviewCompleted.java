package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import insurance.payment.claim.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ReviewCompleted extends AbstractEvent {

    private Long reviewId;
    private Long claimId;
    private Long reviewerId;
    private Date reviewDt;
    private String reviewDetails;
    private String status;
}
