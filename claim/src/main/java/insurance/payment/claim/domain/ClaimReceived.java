package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import insurance.payment.claim.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ClaimReceived extends AbstractEvent {

    private Long claimId;
    private Long customerId;
    private Date claimDt;
    private String claimDetails;
    private String status;
    private List<Attachments> attachments;
    private String diseaseCode;

    public ClaimReceived(Claim aggregate) {
        super(aggregate);
    }

    public ClaimReceived() {
        super();
    }
}
//>>> DDD / Domain Event
