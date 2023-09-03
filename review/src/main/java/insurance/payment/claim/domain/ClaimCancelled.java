package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import insurance.payment.claim.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ClaimCancelled extends AbstractEvent {

    private Long claimId;
    private Long customerId;
    private Date claimDt;
    private String claimDetails;
    private String status;
    private Object attachments;
    private String diseaseCode;
}
