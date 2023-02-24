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

    /**
     * home에서만 사용하는 함수로, 게시판의 게시글을 4개씩 긁어오는 함수이다.
     * 성능상의 이슈가 생기면 join fetch로 하고 where 절로 p를 필터링하여 최적화하자.
     * 
     * @param boardName
     * @return 해당하는 게시판의 게시글을 4개만큼 리스트로 만들어서 봔환.
     */
    public List<Post> findPostPageByName(String boardName, int page, int size) {
        return em.createQuery(
                "select p from Post p" +
                        " join p.board b on b.name = :boardName" +
                        " order by p.postedDate desc", Post.class)
                .setParameter("boardName", boardName)
                .setFirstResult(page != 0 ? (page * size) - 1 : 0)
                .setMaxResults(size)
                .getResultList();
    }

    public List<Post> findPostPageById(Long id, int page, int size) {
        return em.createQuery(
                        "select p from Post p" +
                                " join p.board b on b.boardId = :id" +
                                " order by p.postedDate desc", Post.class)
                .setParameter("id", id)
                .setFirstResult(page != 0 ? (page * size) - 1 : 0)
                .setMaxResults(size)
                .getResultList();
    }
}
