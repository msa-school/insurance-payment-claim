package insurance.payment.claim.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Embeddable
public class Email {
    final String id;
    final String domainName;
    private static final String EMAIL_REGEX = "^[_a-zA-Z0-9-.]+@[.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
}
