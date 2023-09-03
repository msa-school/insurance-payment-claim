package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import insurance.payment.claim.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ClaimCancelled extends AbstractEvent {

    private Long claimId;
    private Long customerId;
    private Date claimDt;
    private String claimDetails;
    private String status;
    private List<Attachments> attachments;
    private String diseaseCode;

    public ClaimCancelled(Claim aggregate) {
        super(aggregate);
    }

    public ClaimCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
