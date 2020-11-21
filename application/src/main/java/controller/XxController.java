package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xx.model.XxVO;
import xx.service.XxService;

@RestController
@RequestMapping("/v1/xx")
public class XxController {

    @Autowired
    private XxService xxService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public XxVO get(@RequestBody String id) {
        return xxService.get(id);
    }
}
