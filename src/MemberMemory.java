import original.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

// 메모리상에서 Member정보를 관리하는 클래스로 MemberService를 구현
public class MemberMemory implements MemberService {
    private List<Member> members;
    private int findIndex(String email){
        int findIndex = -1;
        for(int i = 0; i < members.size(); i++){
            if(members.get(i).getEmail().equals(email)){
                findIndex = i;
                break;
            }
        }
        return findIndex;
    }

    public MemberMemory(){
        this.members = new ArrayList<>();
    }
    public MemberMemory(List<Member> members) {
        this.members = members;
    }

    // 1. 회원 정보 등록
    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    // 2. 회원 정보 삭제
    @Override
    public boolean deleteMember(String email) {
        int findIndex = findIndex(email);
        if(findIndex > -1){
            members.remove(findIndex);
            return true;
        } else{
            return false;
        }
    }

    // 3. 회원 정보 수정
    @Override
    public boolean updateMember(Member member) {
        boolean delFlag = deleteMember(member.getEmail());
        if(delFlag){
            members.add(member);
            return true;
        } else{
            return false;
        }
    }

    // 4. 회원 정보 반환
    @Override
    public Iterator<Member> getMember() {
        return members.iterator();
    }

    // ?????????? 5. 이메일 존재 여부 확인
    @Override
    public boolean exists(String email) {
        if(findIndex(email) >= 0){
            return true;
        } else {
            return false;
        }
    }
}
