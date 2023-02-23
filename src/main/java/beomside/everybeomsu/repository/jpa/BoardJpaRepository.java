package beomside.everybeomsu.repository.jpa;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardJpaRepository {

    private final EntityManager em;

    public List<Long> getIdList() {
        return em.createQuery(
                "select b.board_id from Board b", Long.class)
                .getResultList();
    }
}
