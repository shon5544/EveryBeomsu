package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.dto.req.regist.MemberRegisterReqDto;
import beomside.everybeomsu.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid MemberRegisterReqDto memberRegisterReqDto) {
        Member member = Member.builder()
                .name(memberRegisterReqDto.getName())
                .nickname(memberRegisterReqDto.getNickname())
                .loginId(memberRegisterReqDto.getLoginId())
                .loginPw(memberRegisterReqDto.getLoginPw())
                .build();

        memberService.register(member);
        log.info("Success: registration is completed");
    }

    @DeleteMapping("/delete/member/{memberId}")
    public void deleteMember(@PathVariable(name = "memberId") Long memberId) {
        memberService.deleteMember(memberId);
        log.info("Success: member is deleted successfully");
    }
}
