package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional
    public void regist(Member member) {
        validationDuplicateMember(member);
        memberRepository.save(member);
    }

    //회원 로그인
    public void login(Member member) {
        validationLoginMember(member);
    }

    //회원 중복 검사
    private void validationDuplicateMember(Member member) {
        Member findMember = memberRepository.findByLoginId(member.getLoginId());
        Optional<Member> optionalMember = Optional.ofNullable(findMember);

        Member findMemberByNick = memberRepository.findByNickname(member.getNickname());
        Optional<Member> optionalMemberByNick = Optional.ofNullable(findMemberByNick);

        if(optionalMember.isPresent()) {
            throw new IllegalStateException("해당 id의 회원이 이미 존재합니다.");
        }

        if(optionalMemberByNick.isPresent()) {
            throw new IllegalStateException("해당 닉네임이 이미 존재합니다.");
        }
    }

    //회원 로그인 검증
    private void validationLoginMember(Member member) {
        Member byLogin_idAndLogin_pw = memberRepository.findByLoginIdAndLoginPw(member.getLoginPw(), member.getLoginPw());
        Optional<Member> findMember = Optional.ofNullable(byLogin_idAndLogin_pw);

        if(findMember.isEmpty()) {
            throw new IllegalArgumentException("해당하는 회원이 없습니다.");
        }
    }
}
