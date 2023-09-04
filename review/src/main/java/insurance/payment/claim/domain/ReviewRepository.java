package insurance.payment.claim.domain;

import insurance.payment.claim.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "reviews", path = "reviews")
public interface ReviewRepository
    extends PagingAndSortingRepository<Review, Long> {

    java.util.Optional<Review> findByClaimId(Long claimId);}
