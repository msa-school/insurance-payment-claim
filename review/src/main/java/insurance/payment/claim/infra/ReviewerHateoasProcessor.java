package insurance.payment.claim.infra;

import insurance.payment.claim.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReviewerHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Reviewer>> {

    @Override
    public EntityModel<Reviewer> process(EntityModel<Reviewer> model) {
        return model;
    }
}
