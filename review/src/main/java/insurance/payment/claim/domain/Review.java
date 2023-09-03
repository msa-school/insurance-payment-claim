package insurance.payment.claim.domain;

import insurance.payment.claim.ReviewApplication;
import insurance.payment.claim.domain.ReviewCancelled;
import insurance.payment.claim.domain.ReviewCompleted;
import insurance.payment.claim.domain.ReviewerAssigned;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    private Long claimId;

    private Long reviewerId;

    private Date reviewDt;

    private String reviewDetails;

    private String status;

    private String diseaseCode;

    @PostPersist
    public void onPostPersist() {
        ReviewerAssigned reviewerAssigned = new ReviewerAssigned(this);
        reviewerAssigned.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        ReviewCompleted reviewCompleted = new ReviewCompleted(this);
        reviewCompleted.publishAfterCommit();

        ReviewCancelled reviewCancelled = new ReviewCancelled(this);
        reviewCancelled.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }
}
//>>> DDD / Aggregate Root
