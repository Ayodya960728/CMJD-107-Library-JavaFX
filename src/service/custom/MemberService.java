package service.custom;

import java.util.ArrayList;

import dto.MemberDto;
import service.SuperService;

public interface MemberService extends SuperService {

     public MemberDto getMember(Integer id) throws Exception;
    
    String save(MemberDto memberDto) throws Exception;
    String update(MemberDto memberDto) throws Exception;
    String delete(Integer id) throws Exception;
    MemberDto get(Integer id) throws Exception;
    ArrayList<MemberDto> getAll() throws Exception;
}
