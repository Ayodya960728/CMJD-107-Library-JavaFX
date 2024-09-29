package dao.custom;

import dao.CrudDao;
import entity.BorrowingsEntity;

public interface BorrowingsDao extends CrudDao<BorrowingsEntity, String> {

    public boolean delete(Integer id);

    public BorrowingsEntity get(Integer id);

}
