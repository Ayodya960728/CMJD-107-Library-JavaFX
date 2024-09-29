package service.custom;

import java.util.ArrayList;

import dto.BorrowingsDto;
import service.SuperService;

public interface BorrowingsService extends SuperService {

    String save(BorrowingsDto borrowingsDto) throws Exception;
    String update(BorrowingsDto borrowingsDto) throws Exception;
    String delete(Integer id) throws Exception;
    BorrowingsDto get(Integer id) throws Exception;
    ArrayList<BorrowingsDto> getAll() throws Exception;
    public String aproveBorrowings(BorrowingsDto borrowingsDto) throws Exception;
}
