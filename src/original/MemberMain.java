package original;

import java.util.List;

/* 메뉴 출력하고 모든 기능 실행 */
public class MemberMain {
    public static void main(String[] args) {
        MemberUI memberUI = new MemberUI();
        MemberDao memberDao = new MemberDao("/tmp/members.dat");
        // 파일에 있는 회원목록 얻기 (List 타입의 original.Member 형태로)
        List<Member> members = memberDao.getMember();

        while (true) {
            int menuId = memberUI.menu();
            if(menuId == 5){ // 5. 종료
                System.out.println("프로그램을 종료합니다.");
                memberDao.saveMember(members);
                break;
            } else if(menuId == 1) { // 1. 회원 정보 등록
                Member member = memberUI.regMember();
                members.add(member);
                System.out.println("회원 정보 등록을 완료했습니다.");
            } else if(menuId == 2) { // 2. 회원 목록 보기
                memberUI.printMemberList(members);
            } else if(menuId == 3) { // 3. 회원 정보 수정
                String email = memberUI.inputEmail();
                int findIndex = -1;
                for(int i = 0; i < members.size(); i++){
                    // 3-1. MemberDao에 있는 List<original.Member> 정보 가져오기
                    Member m = members.get(i);

                    // 3-2. 기존의 회원정보 이메일(m.getEmail()) == (입력)수정할 email과 같은지 비교
                    if(m.getEmail().equals(email)){
                        findIndex = i; // 같은 original.Member 정보를 findIndex에 담는다.
                        break;
                    }
                }

                if(findIndex != -1){ // 3-3. 이메일 정보 같으면 이름 및 출생년도 수정 가능
                    Member updateMember = memberUI.inputMember(email);
                    members.remove(findIndex);
                    members.add(updateMember);
                    System.out.println("회원 정보가 수정되었습니다.");
                } else{
                    System.out.println("수정할 회원정보가 없습니다.");
                }
            } else if(menuId == 4) { // 4. 회원 정보 삭제
                String email = memberUI.inputEmail();
                int findIndex = -1;
                for(int i = 0; i < members.size(); i++){
                    Member m = members.get(i);
                    if(m.getEmail().equals(email)){
                        findIndex = i;
                        break;
                    }
                }
                if(findIndex != -1){
                    members.remove(findIndex);
                    System.out.println("회원 정보를 삭제했습니다.");
                } else{
                    System.out.println("삭제할 회원정보가 없습니다.");
                }
            }
        }
    }
}
