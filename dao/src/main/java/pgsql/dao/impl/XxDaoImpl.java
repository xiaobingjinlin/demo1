package pgsql.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pgsql.dao.XxDao;
import pgsql.mapper.XxMapper;
import pgsql.model.XxDO;

@Repository
public class XxDaoImpl implements XxDao {

    @Autowired
    private XxMapper xxMapper;

    public XxDO get(String id) {
        return xxMapper.get(id);
    }
}
