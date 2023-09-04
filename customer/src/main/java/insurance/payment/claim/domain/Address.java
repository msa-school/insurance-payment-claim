package insurance.payment.claim.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Embeddable
public class Address {
    final String street;
    final String zipCode;
}
