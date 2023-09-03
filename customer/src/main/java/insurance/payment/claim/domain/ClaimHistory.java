package insurance.payment.claim.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "ClaimHistory_table")
@Data
public class ClaimHistory {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long claimId;
    private Long reviewerId;
    private Long customerId;
    private String diseaseCode;
    private Double amount;
    private String reviewStatus;
    private String paymentStatus;
    private String status;
}
