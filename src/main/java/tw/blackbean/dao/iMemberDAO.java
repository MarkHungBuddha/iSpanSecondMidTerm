package tw.blackbean.dao;

import tw.blackbean.model.MemberData;

import java.util.List;


public interface iMemberDAO {
    boolean delete(long memberId);
    List<MemberData> findAll();
    MemberData findById(long memberId);
    MemberData findByemailAndpasswd(String email, String passwd);
    boolean update(MemberData memberData);
    boolean save(MemberData memberData);

    boolean isExistEmail(String email);
    boolean isExistMember(String username);

}
