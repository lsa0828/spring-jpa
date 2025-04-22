package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.ex01.MemberVO;

@Mapper
public interface MemberMapper2 {
	@Select("SELECT * FROM t_member ORDER BY joinDate DESC")
    List<MemberVO> selectAllMemberList();
}
