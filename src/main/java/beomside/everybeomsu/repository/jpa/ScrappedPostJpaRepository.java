package beomside.everybeomsu.repository.jpa;

import beomside.everybeomsu.domain.ScrappedPost;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScrappedPostJpaRepository {

    private final EntityManager em;

    public List<ScrappedPost> findScrappedPostByMemberId(Long memberId) {
        return em.createQuery(
                "select s from ScrappedPost s" +
                        " where s.member.memberId = :memberId", ScrappedPost.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
