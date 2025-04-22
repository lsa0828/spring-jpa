package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.spring.ex01.MemberVO;

@Mapper
public interface MemberMapper {
	List<MemberVO> selectAllMemberList();
	String selectName();
	int selectPwd();
	MemberVO selectMemberById(String id);
	List<MemberVO> selectMemberByPwd(String pwd);
	void insertMember(MemberVO memberVO);
	void updateMember(MemberVO memberVO);
	void deleteMember(String id);
	List<MemberVO> searchMember(MemberVO memberVO);
	List<MemberVO> foreachSelect(Map<String, Object> map);
	void foreachInsert(Map<String, Object> map);
}
