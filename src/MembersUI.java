import original.Member;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

/* 사용자 메뉴 : 회원 정보를 등록, 목록 출력, 수정, 삭제 기능 */
public class MembersUI {
    private BufferedReader br;

    public MembersUI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    // main 함수에서 사용할 menu 기능
    public int menu(){
        System.out.println("1. 회원 정보 등록");
        System.out.println("2. 회원 목록 보기");
        System.out.println("3. 회원 정보 수정");
        System.out.println("4. 회원 정보 삭제");
        System.out.println("5. 종료");

        int menuId = -1;
        try{
            String line = br.readLine();
            menuId = Integer.parseInt(line);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return menuId;
    }

    // 1. 회원 정보 등록
    public Member regMember(){
        try{
            System.out.println("email을 입력하세요.");
            String email = br.readLine();
            System.out.println("이름을 입력하세요.");
            String name = br.readLine();
            System.out.println("출생년도를 입력하세요.");
            String strBirth = br.readLine();
            int birth = Integer.parseInt(strBirth);

            Member member = new Member(email, name, birth);
            return member;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    // 2. 회원 목록 보기(리스트 출력)
    public void printMemberList(Iterator<Member> iter){
        System.out.println("Email            Name             Birth");
        System.out.println("=======================================");

        while (iter.hasNext()){
            Member member = iter.next();
            System.out.print(member.getEmail());
            System.out.print("            ");
            System.out.print(member.getName());
            System.out.print("            ");
            System.out.print(member.getBirth());
            System.out.println();
        }
    }

    // 3. 회원 정보 수정 : email 입력 받기
    public String inputEmail(){
        System.out.println("수정할 회원의 email을 입력하세요.");
        String email = "";
        try{
            email = br.readLine();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return email;
    }

    // 3. 회원 정보 수정 : 이름(name) 및 출생년도(birth) 받기 == 1. 회원정보 등록
    public Member inputMember(String email){
        try{
            System.out.println(email + "회원 정보를 수정합니다.");
            System.out.println("수정할 이름을 입력하세요.");
            String name = br.readLine();
            System.out.println("수정할 출생년도를 입력하세요.");
            String strBirth = br.readLine();
            int birth = Integer.parseInt(strBirth);

            Member member = new Member(email, name, birth);
            return member;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
