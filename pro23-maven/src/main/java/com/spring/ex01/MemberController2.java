package com.spring.ex01;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mapper.MemberMapper2;

@Controller
public class MemberController2 {
	private final MemberMapper2 memberMapper;

    public MemberController2(MemberMapper2 memberMapper) {
        this.memberMapper = memberMapper;
    }

    @GetMapping("/members2")
    public String listMembers(Model model) {
        List<MemberVO> membersList = memberMapper.selectAllMemberList();
        model.addAttribute("membersList", membersList);
        return "test01/listMembers"; // => /WEB-INF/views/test01/listMembers.jsp
    }
}
