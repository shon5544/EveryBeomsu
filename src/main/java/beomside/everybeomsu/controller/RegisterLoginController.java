package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.dto.req.regist.MemberRegisterReqDto;
import beomside.everybeomsu.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RegisterLoginController {

    private final MemberService memberService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid MemberRegisterReqDto memberRegisterReqDto) {
        Member member = new Member(memberRegisterReqDto);

        memberService.register(member);
        log.info("Success: registration is completed");
    }
}
