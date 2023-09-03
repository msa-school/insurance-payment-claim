package insurance.payment.claim.infra;

import insurance.payment.claim.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ClaimHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Claim>> {

    @Override
    public EntityModel<Claim> process(EntityModel<Claim> model) {
        return model;
    }
}
