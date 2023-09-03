package insurance.payment.claim.common;

import insurance.payment.claim.ClaimApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ClaimApplication.class })
public class CucumberSpingConfiguration {}
