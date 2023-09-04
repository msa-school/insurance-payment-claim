package insurance.payment.claim.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachments {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
