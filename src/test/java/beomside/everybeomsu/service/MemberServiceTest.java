package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.dto.req.regist.MemberRegisterReqDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    public void 회원가입() {
        //given
        MemberRegisterReqDto memberDto = new MemberRegisterReqDto();
        memberDto.setName("손범수");
        memberDto.setNickname("틈만나면케겔운동");
        memberDto.setLogin_id("sbs8239");
        memberDto.setLogin_pw("sbs32465169");

        Member member = new Member(memberDto);

        MemberRegisterReqDto memberDto2 = new MemberRegisterReqDto();
        memberDto2.setName("이나리");
        memberDto2.setNickname("100m매일걷기");
        memberDto2.setLogin_id("sbs8239");
        memberDto2.setLogin_pw("0909012");

        Member member2 = new Member(memberDto2);

        //when
        memberService.register(member);

        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.register(member2);
        });

    }

    @Test
    void login() {
        //given
        MemberRegisterReqDto memberDto = new MemberRegisterReqDto();
        memberDto.setName("손범수");
        memberDto.setNickname("틈만나면케겔운동");
        memberDto.setLogin_id("sbs8239");
        memberDto.setLogin_pw("sbs32465169");

        Member member = new Member(memberDto);
        memberService.register(member);


        //when
        MemberRegisterReqDto memberDto2 = new MemberRegisterReqDto();
        memberDto2.setName("이나리");
        memberDto2.setNickname("100m매일걷기");
        memberDto2.setLogin_id("sbs8239");
        memberDto2.setLogin_pw("0909012");

        Member member2 = new Member(memberDto);

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            memberService.login(member2);
        });
    }
}