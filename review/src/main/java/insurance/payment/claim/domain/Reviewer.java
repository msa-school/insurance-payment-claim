package insurance.payment.claim.domain;

import insurance.payment.claim.ReviewApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reviewer_table")
@Data
//<<< DDD / Aggregate Root
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String division;

    private String status;

    public static ReviewerRepository repository() {
        ReviewerRepository reviewerRepository = ReviewApplication.applicationContext.getBean(
            ReviewerRepository.class
        );
        return reviewerRepository;
    }
}
//>>> DDD / Aggregate Root
