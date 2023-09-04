package insurance.payment.claim.domain;

import insurance.payment.claim.ReviewApplication;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Review_table")
@Data
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
    private String reviewType;

    @PreUpdate
    public void onPostUpdate() {
        // The Update event within the domain is pushed only When the "Reviewtype" is 'reviewed'.
        if (this.getReviewType() != null &&
                    this.getReviewType().equalsIgnoreCase("reviewed")) {
            this.setStatus(ReviewCompleted.class.getSimpleName());

            ReviewCompleted reviewCompleted = new ReviewCompleted(this);
            reviewCompleted.publishAfterCommit();
        }
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }

    public static void cancelReview(ClaimCancelled claimCancelled) {
        repository().findByClaimId(claimCancelled.getClaimId()).ifPresent(review->{
            review.setReviewType("cancel");
            review.setStatus(ReviewCancelled.class.getSimpleName()); 

            repository().save(review);

            ReviewCancelled reviewCancelled = new ReviewCancelled(review);
            reviewCancelled.publishAfterCommit();
        });
    }

    public static void assignReview(ClaimReceived claimReceived) {
        Review review = new Review();
        review.setClaimId(claimReceived.getClaimId());
        review.setDiseaseCode(claimReceived.getDiseaseCode());
        review.setReviewId(100L);
        review.setStatus(ReviewerAssigned.class.getSimpleName());

        repository().save(review);

        ReviewerAssigned reviewerAssigned = new ReviewerAssigned(review);
        reviewerAssigned.publishAfterCommit();
    }
}
