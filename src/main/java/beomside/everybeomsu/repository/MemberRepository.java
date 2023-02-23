package beomside.everybeomsu.repository;

import beomside.everybeomsu.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByLoginId(String login_id);
    Member findByLoginIdAndLoginPw(String login_id, String login_pw);
    Member findByNickname(String nickname);
}
