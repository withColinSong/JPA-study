package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.dto.MemberForm;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "/member/createForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm memberForm, BindingResult result) {

        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());

        if(result.hasErrors()) {
            return "/member/createForm";
        }

        Member member = new Member();
        member.setName(memberForm.getName());
        member.setAddress(address);

        Long userId = memberService.join(member);
        log.info("userId : " + userId);
        return "redirect:/";

    }

    @GetMapping("/members")
    public String memberList(Model model) {

        List<Member> members = memberService.findMembers();
        model.addAttribute("members",  members);

        return "/member/memberList";
    }




}
