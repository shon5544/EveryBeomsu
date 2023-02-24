package beomside.everybeomsu.repository.jpa;

import beomside.everybeomsu.domain.Post;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostJpaRepository {

    private final EntityManager em;

    public List<Post> findPostByPaging(String boardName) {
        return em.createQuery(
                "select p from Post p" +
                        " join fetch p.board on p.board.name = :boardName" +
                        " order by p.postedDate desc", Post.class)
                .setParameter("boardName", boardName)
                .setFirstResult(0)
                .setMaxResults(4)
                .getResultList();
    }
}
