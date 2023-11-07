import original.Member;

import java.util.Iterator;

// 회원 정보를 등록, 삭제, 수정, 목록 보기에 대한 메서드 원형
public interface MemberService {
    public void addMember(Member member);
    public boolean deleteMember(String email);
    public boolean updateMember(Member member);
    public Iterator<Member> getMember();
    public boolean exists(String email);
}
