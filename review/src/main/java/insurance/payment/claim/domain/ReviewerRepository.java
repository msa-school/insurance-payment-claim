package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "reviewers", path = "reviewers")
public interface ReviewerRepository
    extends PagingAndSortingRepository<Reviewer, Long> {}
