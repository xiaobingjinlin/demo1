## 目录结构
application--对外接口  
```
 .
  ├─config
  │  └─XxConfig--@Configuration  @Bean
  ├─controller
  │  └─XxController--@RestController  @Autowired
  │                --VO/params->params->VO/params
  ├─service--对外非业务服务
  │  ├─XxService
  │  └─impl
  │     └─XxServiceImpl--@Service  @Autowired
  ├─util
  │  └─XxUtil--对外非业务工具方法
  └─XxApplication--应用入口
```
注：Controller传参，除新增修改传引用类型外其他都传基本类型  

business--业务相关接口及实现  
```
 .
  ├─xx
  │  ├─exception
  │  │  └─XxException
  │  ├─job
  │  │  └─XxJob
  │  ├─xx.model
  │  │  └─XxVO
  │  ├─service--内部业务服务
  │  │  ├─XxService
  │  │  └─impl
  │  │     └─XxServiceImpl--@Service  @Autowired
  │  │                    --VO/params->DO->VO/params
  │  └─util
  │     └─XxUtil--@Component--业务工具方法
  └─yy
```
注：
* 工具类如果依赖bean则增加@Component注解，仅用于application模块
* 静态类调用工具类时，工具类需要使用单例模式，通过@PostConstruct注解的初始化方法注入依赖的bean
```
工具类：
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

    public Xx getXx(String id) {
        return xxService.get(id);
    }
}

调用：
XxUtil.getInstance().getXx(id);
```
pgsql.dao--持久化、缓存相关接口及实现
```
 .
  ├─mysql
  │  ├─pgsql.dao
  │  │  └─XxDao
  │  │  └─impl
  │  │     └─XxDaoImpl
  │  ├─xx.model
  │  │  └─XxDO
  │  ├─entity--DO/params->PO->DO/params
  │  │  └─XxPO
  │  └─mapper
  │     └─XxMapper
  ├─pgsql
  ├─redisedge
  │  ├redis
  │  ├redistimeseries
  │  ├redisai
  │  └redisgears
  └─util
     └─XxUtil--持久化、缓存工具方法
     └─XxConstant--业务常量
```
common--非业务工具类（包括常量）
```
 .
  ├─config
  │  └─XxConfig--@Configuration  @Bean
  ├─service--内部非业务服务
  │  ├─XxService
  │  └─impl
  │     └─XxServiceImpl--@Resource(name = "xxChannel")
  ├─xx.model
  │  └─Xx
  └─util
     ├─XxUtil--非业务工具方法
     └─XxConstant--非业务常量
 └─yy--其他源代码
```