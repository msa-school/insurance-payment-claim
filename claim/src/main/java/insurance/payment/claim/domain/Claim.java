package insurance.payment.claim.domain;

import insurance.payment.claim.ClaimApplication;
import insurance.payment.claim.domain.ClaimCancelled;
import insurance.payment.claim.domain.ClaimReceived;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Claim_table")
@Data
//<<< DDD / Aggregate Root
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long claimId;

    private Long customerId;

    private Date claimDt;

    private String claimDetails;

    private String status;

    @ElementCollection
    private List<Attachments> attachments;

    private String diseaseCode;

    @PostPersist
    public void onPostPersist() {
        ClaimReceived claimReceived = new ClaimReceived(this);
        claimReceived.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        ClaimCancelled claimCancelled = new ClaimCancelled(this);
        claimCancelled.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static ClaimRepository repository() {
        ClaimRepository claimRepository = ClaimApplication.applicationContext.getBean(
            ClaimRepository.class
        );
        return claimRepository;
    }
}
//>>> DDD / Aggregate Root
