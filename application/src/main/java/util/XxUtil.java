package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xx.model.XxVO;
import xx.service.XxService;

import javax.annotation.PostConstruct;

@Component
public class XxUtil {

    private static XxUtil xxUtil;

    @Autowired
    private XxService xxService;

    public static synchronized XxUtil getInstance() {
        if (xxUtil == null) {
            xxUtil = new XxUtil();
        }
        return xxUtil;
    }

    @PostConstruct
    private void init() {
        xxUtil = getInstance();
        xxUtil.xxService = this.xxService;
    }

    public XxVO getXx(String id) {
        return xxService.get(id);
    }
}
