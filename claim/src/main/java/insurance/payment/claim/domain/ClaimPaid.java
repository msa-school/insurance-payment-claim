package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import insurance.payment.claim.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ClaimPaid extends AbstractEvent {

    private Long paymentId;
    private Long claimId;
    private Long reviewId;
    private Double amount;
    private Date paymentDt;
    private String status;
}
