import original.Member;

/* 메뉴 출력하고 모든 기능 실행 */
public class MembersMain {
    public static void main(String[] args) {
        MembersUI membersUI = new MembersUI();
        MembersDao membersDao = new MembersDao("/tmp/members.dat");
        MemberService memberService = new MemberMemory(membersDao.getMember());

        while (true) {
            int menuId = membersUI.menu();

            if(menuId == 5){

                // 5. 종료
                System.out.println("프로그램을 종료합니다.");
                membersDao.saveMember(memberService.getMember());
                break;

            } else if(menuId == 1) {

                // 1. 회원 정보 등록
                Member member = membersUI.regMember();
                memberService.addMember(member);
                System.out.println("회원 정보 등록을 완료했습니다.");

            } else if(menuId == 2) {

                // 2. 회원 목록 보기
                membersUI.printMemberList(memberService.getMember());

            } else if(menuId == 3) {

                // 3. 회원 정보 수정
                String email = membersUI.inputEmail();
                boolean isFindEmail = memberService.exists(email);

                // 3-3. 이메일 정보 같으면 이름 및 출생년도 수정 가능
                if(isFindEmail){
                    Member updateMember = membersUI.inputMember(email);
                    memberService.updateMember(updateMember);
                    System.out.println("회원 정보가 수정되었습니다.");
                } else{
                    System.out.println("수정할 회원정보가 없습니다.");
                }

            } else if(menuId == 4) {

                // 4. 회원 정보 삭제
                String email = membersUI.inputEmail();
                boolean isFindEmail = memberService.exists(email);

                if(isFindEmail){
                    memberService.deleteMember(email);
                    System.out.println("회원 정보를 삭제했습니다.");
                } else{
                    System.out.println("삭제할 회원정보가 없습니다.");
                }

            }
        }
    }
}
