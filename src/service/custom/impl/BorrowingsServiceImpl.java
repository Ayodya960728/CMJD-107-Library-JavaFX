package service.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BookDao;
import dao.custom.BorrowingsDao;
import dao.custom.MemberDao;
import db.DBConnection;
import dto.BorrowingsDto;
import dto.MemberDto;
import entity.BookEntity;
import entity.BorrowingsEntity;
import entity.MemberEntity;
import service.custom.BorrowingsService;

public class BorrowingsServiceImpl implements BorrowingsService {

    private BorrowingsDao borrowingsDao = (BorrowingsDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BORROWINGS);
    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);
    private MemberDao memberDao = (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);

   @Override
    public String aproveBorrowings(BorrowingsDto borrowingsDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            
            BorrowingsEntity borrowingsEntity = new BorrowingsEntity(
                borrowingsDto.getBook_id(),
                borrowingsDto.getBorrow_date(), 
                borrowingsDto.getDue_date(), 
                borrowingsDto.getReturn_date(), 
                borrowingsDto.getFine(), null);

            if (borrowingsDao.create(borrowingsEntity)) {
                boolean isMembersSaved = true;

                for (MemberDto memberDto : borrowingsDto.getMemberDtos()) {
                    MemberEntity memberEntity = new MemberEntity(memberDto.getId(), memberDto.getName(), memberDto.getPhone());
                    if (!memberDao.create(memberEntity)) {
                        isMembersSaved = false;
                        break;
                    }
                }

                if (isMembersSaved) {
                    boolean isBookUpdated = true;

                    BookEntity bookEntity = bookDao.get(borrowingsDto.getBook_id());
                    if (bookEntity != null) {
                        
                        bookEntity.setBorrowed(true);

                        if (!bookDao.update(bookEntity)) {
                            isBookUpdated = false;
                        }
                    } else {
                        isBookUpdated = false;
                    }

                    if (isBookUpdated) {
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Book Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Member Save Error";
                }
            } else {
                connection.rollback();
                return "Borrowings Save Error";
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public String save(BorrowingsDto borrowingsDto) throws Exception {
        BorrowingsEntity entity = getBorrowingsEntity(borrowingsDto);
        return borrowingsDao.create(entity) ? "Success" : "Fail";
    }
    @Override
    public String update(BorrowingsDto borrowingsDto) throws Exception {
        BorrowingsEntity entity = getBorrowingsEntity(borrowingsDto);
        return borrowingsDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(Integer id) throws Exception {
       return borrowingsDao.delete(id) ? "Success" : "Fail";
        }

    @Override
    public BorrowingsDto get(Integer id) throws Exception {
        BorrowingsEntity entity = borrowingsDao.get(id);
        if (entity != null) {
            return getBorrowingsDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<BorrowingsDto> getAll() throws Exception {
        ArrayList<BorrowingsEntity> borrowingsEntitys = borrowingsDao.getAll();
        if(borrowingsEntitys != null && !borrowingsEntitys.isEmpty()){
            ArrayList<BorrowingsDto> borrowingsDtos = new ArrayList<>();
            
            for (BorrowingsEntity borrowingsEntity : borrowingsEntitys) {
                borrowingsDtos.add(getBorrowingsDto(borrowingsEntity));
            }
            return borrowingsDtos;
        }
        return null;
    }

    private BorrowingsEntity getBorrowingsEntity(BorrowingsDto borrowingsDto) {
        return new BorrowingsEntity(
            borrowingsDto.getBook_id(),
            borrowingsDto.getBorrow_date(),
            borrowingsDto.getDue_date(),
            borrowingsDto.getReturn_date(),
            borrowingsDto.getFine(),
            null
        );
    }

}
