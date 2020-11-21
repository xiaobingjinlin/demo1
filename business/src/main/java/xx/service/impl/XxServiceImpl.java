package xx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pgsql.dao.XxDao;
import pgsql.model.XxDO;
import xx.model.XxVO;
import xx.service.XxService;

public class XxServiceImpl implements XxService {

    @Autowired
    private XxDao xxDao;

    public XxVO get(String id) {
        XxDO xxDO = xxDao.get(id);
        return null;
    }
}
