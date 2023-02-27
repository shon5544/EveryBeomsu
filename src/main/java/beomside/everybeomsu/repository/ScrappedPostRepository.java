package beomside.everybeomsu.repository;

import beomside.everybeomsu.domain.ScrappedPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrappedPostRepository extends JpaRepository<ScrappedPost, Long> {
}
