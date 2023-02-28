package beomside.everybeomsu.repository;

import beomside.everybeomsu.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    static final String UPDATE_MEMBER_LAST_LOGIN = "update member set last_login_time = :lastLoginTime where loginId = :loginId";

    @Transactional
    @Modifying
    @Query(value = UPDATE_MEMBER_LAST_LOGIN, nativeQuery = true)
    public int updateMemberLastLogin(@Param("loginId") String loginId, @Param("lastLoginTime")LocalDateTime lastLoginTime);
    Member findByLoginId(String login_id);
    Member findByLoginIdAndLoginPw(String login_id, String login_pw);
    Member findByNickname(String nickname);
}
