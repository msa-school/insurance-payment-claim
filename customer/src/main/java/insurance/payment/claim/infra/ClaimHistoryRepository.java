package insurance.payment.claim.infra;

import insurance.payment.claim.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "claimHistories",
    path = "claimHistories"
)
public interface ClaimHistoryRepository
    extends PagingAndSortingRepository<ClaimHistory, Long> {
    List<ClaimHistory> findByClaimId(Long claimId);
}
