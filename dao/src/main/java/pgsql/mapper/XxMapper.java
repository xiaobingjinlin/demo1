package pgsql.mapper;

import org.apache.ibatis.annotations.Mapper;
import pgsql.entity.XxPO;
import pgsql.model.XxDO;

@Mapper
public class XxMapper {
    public XxDO get(String id) {
        //TODO get
        //TODO PO to DO
        XxPO xxPO;
        XxDO xxDO = null;
        return xxDO;
    }

    public XxDO saveOrUpdate(XxDO xxDO) {
        //TODO DO to PO
        //TODO save
        //TODO PO to DO
        return xxDO;
    }
}
