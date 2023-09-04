package insurance.payment.claim.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ClaimHistory_table")
@Data
public class ClaimHistory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long claimId;
    private Long reviewerId;
    private Long customerId;
    private String diseaseCode;
    private Double amount;
    private String reviewStatus;
    private String paymentStatus;
    private String status;
    private String claimDetails;
    private Date claimDt;
}
