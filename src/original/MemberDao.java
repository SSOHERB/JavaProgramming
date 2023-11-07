package original;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 파일에서 List 형태의 original.Member 정보를 저장 OR 읽어오는 클래스 */
public class MemberDao {
    private String filename;

    public MemberDao(String filename) {
        this.filename = filename;
    }

    public void saveMember(List<Member> list){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            // 매개변수로 가져온 객체를 파일 자체로 쓴다.
            out.writeObject(list);
        } catch (Exception ex){
            // 파일 열때, FileNotFoundException 발생할 수 있으므로 예외 catch 처리
            ex.printStackTrace();
        }
    }

    public List<Member> getMember(){
        File file = new File(filename);

        if(!file.exists()){
            return new ArrayList<>();
        }

        List<Member> list = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            // 파일에 쓰여진 객체를 읽고 original.Member 형식의 List 객체로 형변환
            list = (List<Member>)in.readObject();
        } catch (Exception ex){
            // 객체의 클래스를 찾을 수 없는 예외 발생시 (ClassNotFoundException) 예외 던지기
            ex.printStackTrace();
        }
        return list;
    }
}
