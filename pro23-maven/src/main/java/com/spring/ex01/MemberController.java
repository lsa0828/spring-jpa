package com.spring.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mapper.MemberMapper;

@Controller
public class MemberController {
	private final MemberMapper memberMapper;

    public MemberController(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @GetMapping("/members1")
    public String listMembers(Model model) {
        List<MemberVO> membersList = memberMapper.selectAllMemberList();
        model.addAttribute("membersList", membersList);
        return "test01/listMembers"; // => /WEB-INF/views/test01/listMembers.jsp
    }
    
    @GetMapping("/showMem")
    public String showMember(RedirectAttributes redirectAttributes) {
    	String name = memberMapper.selectName();
    	int pwd = memberMapper.selectPwd();
    	redirectAttributes.addFlashAttribute("alertMsg", "이름: " + name + "\\n비밀번호: " + pwd);
    	return "redirect:/members1";
    }
    
    @GetMapping("/search")
    public String showSearchPage() {
    	return "test02/search";
    }
    
    @GetMapping("/searchMem")
    public String searchMember(@RequestParam("value") String value, @RequestParam("action") String action, Model model) {
    	String nextPage = "";
    	if(action.equals("selectMemberById")) {
    		MemberVO memberVO = memberMapper.selectMemberById(value);
    		model.addAttribute("member", memberVO);
    		nextPage = "test02/memberInfo";
    	} else if (action.equals("selectMemberByPwd")) {
    		List<MemberVO> membersList = memberMapper.selectMemberByPwd(value);
    		model.addAttribute("membersList", membersList);
    		nextPage = "test01/listMembers";
    	}
    	return nextPage;
    }
    
    @GetMapping("/memberForm")
    public String showMemberFormPage() {
    	return "test03/memberForm";
    }
    
    @PostMapping("/insertMem")
    public String insertMember(MemberVO memberVO) {
    	memberMapper.insertMember(memberVO);
    	return "redirect:/members1";
    }
    
    @GetMapping("/modMember")
    public String shoModMemberPage(@RequestParam("id") String id, Model model) {
    	MemberVO memberVO = memberMapper.selectMemberById(id);
		model.addAttribute("member", memberVO);
    	return "test03/modMember";
    }
    
    @PostMapping("/updateMem")
    public String updateMember(MemberVO memberVO) {
    	memberMapper.updateMember(memberVO);
    	return "redirect:/members1";
    }
    
    @GetMapping("/deleteMem")
    public String deleteMember(@RequestParam("id") String id) {
    	memberMapper.deleteMember(id);
    	return "redirect:/members1";
    }
    
    @GetMapping("/searchPage")
    public String showSearchMemberPage() {
    	return "test03/searchMember";
    }
    
    @GetMapping("/searchMem2") 
    public String searchMemByNameAndEmail(MemberVO memberVO, Model model) {
    	List<MemberVO> membersList = memberMapper.searchMember(memberVO);
    	model.addAttribute("membersList", membersList);
    	return "test01/listMembers";
    }
    
    @GetMapping("/foreachSelect")
    public String foreachSelectMem(Model model) {
    	Map<String, Object> nameMap = new HashMap<>();
    	List<String> nameList = new ArrayList<String>();
    	nameList.add("홍길동");
    	nameList.add("이순신");
    	nameList.add("abc");
    	nameMap.put("list", nameList);
    	List<MemberVO> membersList = memberMapper.foreachSelect(nameMap);
    	model.addAttribute("membersList", membersList);
    	return "test01/listMembers";
    }
    
    @GetMapping("/foreachInsert")
    public String foreachInsertMem() {
    	Map<String, Object> memMap = new HashMap<>();
    	List<MemberVO> memList = new ArrayList<MemberVO>();
    	memList.add(new MemberVO("m1", "1234", "박길동", "m1@test.com"));
    	memList.add(new MemberVO("m2", "1234", "이길동", "m2@test.com"));
    	memList.add(new MemberVO("m3", "1234", "김길동", "m3@test.com"));
    	memMap.put("list", memList);
    	memberMapper.foreachInsert(memMap);
    	return "redirect:/members1";
    }
}
