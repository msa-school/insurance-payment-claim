package insurance.payment.claim.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import insurance.payment.claim.ClaimApplication;
import lombok.Data;

@Entity
@Table(name = "Claim_table")
@Data
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long claimId;
    private Long customerId;
    private Date claimDt;
    private String claimDetails;
    private String status;
    private String claimType;

    @ElementCollection
    private List<Attachments> attachments;

    private String diseaseCode;

    @PostPersist
    public void onPostPersist() {
        this.setStatus(ClaimReceived.class.getSimpleName());
        ClaimReceived claimReceived = new ClaimReceived(this);
        claimReceived.publishAfterCommit();
    }

    @PreUpdate
    public void onPostUpdate() {
        // The update event within the domain is pushed only once. (ClaimCancelled)
        // The code below is not recommended.

        if (this.getClaimType() != null && 
                    this.getClaimType().equalsIgnoreCase("cancel")) {
            this.setClaimType(null);
            this.setStatus(ClaimCancelled.class.getSimpleName());  

            ClaimCancelled claimCancelled = new ClaimCancelled(this);
            claimCancelled.publishAfterCommit();
        }
    }

    public static ClaimRepository repository() {
        ClaimRepository claimRepository = ClaimApplication.applicationContext.getBean(
            ClaimRepository.class
        );
        return claimRepository;
    }

    public static void updateStatus(ReviewerAssigned event) {
        repository().findById(event.getClaimId()).ifPresent(claim->{
            claim.setStatus(ReviewerAssigned.class.getSimpleName()); 
            
            repository().save(claim);
        });
    }

    public static void updateStatus(ReviewCompleted event) {
        repository().findById(event.getClaimId()).ifPresent(claim->{
            claim.setStatus(event.getClass().getSimpleName()); 

            repository().save(claim);
         });        
    }

    public static void updateStatus(ReviewCancelled event) {
        repository().findById(event.getClaimId()).ifPresent(claim->{
            claim.setStatus(event.getClass().getSimpleName()); 

            repository().save(claim);
         });        
    }

    public static void updateStatus(PaymentCancelled event) {
        repository().findById(event.getClaimId()).ifPresent(claim->{
            claim.setStatus(event.getClass().getSimpleName()); 

            repository().save(claim);
         });        
    }

    public static void updateStatus(ClaimPaid event) {
        repository().findById(event.getClaimId()).ifPresent(claim->{
            claim.setStatus(event.getClass().getSimpleName()); 

            repository().save(claim);
         });        
    }
}
