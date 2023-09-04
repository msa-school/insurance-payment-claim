package insurance.payment.claim.domain;

import insurance.payment.claim.CustomerApplication;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Customer_table")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date registerDt;

    @Embedded
    private Address address;

    @Embedded
    private Email email;
    private String status;

    public static CustomerRepository repository() {
        CustomerRepository customerRepository = CustomerApplication.applicationContext.getBean(
            CustomerRepository.class
        );
        return customerRepository;
    }
}
