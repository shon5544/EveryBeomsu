package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional
    public void register(Member member) {
        validationDuplicateMember(member);
        memberRepository.save(member);
    }

    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    //회원 로그인
    public void login(Member member) {
        validationLoginMember(member);
    }

    public Member getMemberById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        return optionalMember.orElseThrow(() -> new IllegalStateException("해당하는 회원정보가 없습니다."));
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
            throw new EntityNotFoundException("해당하는 회원이 없습니다.");
        }
    }
}
