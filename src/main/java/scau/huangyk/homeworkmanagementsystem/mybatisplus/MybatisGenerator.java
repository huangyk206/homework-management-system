package scau.huangyk.homeworkmanagementsystem.mybatisplus;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatisplus代码生成器
 *
 * @author huangyk
 * @since 2019.01.02
 */
public class MybatisGenerator {
    private static String authorName = "huangyk";     //作者
    private static String[] tables = new String[]{"sys_info"};                  //table名字
    //private static String prefix="sc_";                     //table前缀
    private static String path = System.getProperty("user.dir");
    private static String packageName = "scau.huangyk.homeworkmanagementsystem";
   // private static String templatePath = "/mybatis_template/";

    public static void main(String[] args) {
        // 自定义需要填充的字段
        //List<TableFill> tableFillList = new ArrayList<>();
        //tableFillList.add(new TableFill("create_date", FieldFill.INSERT));
        //tableFillList.add(new TableFill("update_date", FieldFill.INSERT_UPDATE));
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir(path + "/src/main/java")//输出目录
                        //.setFileOverride(true)// 是否覆盖文件
                        .setActiveRecord(true)// 开启 activeRecord 模式
                       // .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        .setOpen(false)//生成后打开文件夹
                        .setAuthor(authorName)
                        // 自定义文件命名，注意 %s 会自动填充表实体属性！
                        .setMapperName("%sMapper")
                        .setXmlName("%sMapper")
                        .setServiceName("%sService")
                        .setServiceImplName("%sServiceImpl")
                        .setControllerName("%sController")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL)// 数据库类型
                        .setTypeConvert(new MySqlTypeConvert() {
                            // 自定义数据库表字段类型转换【可选】
                            @Override
                            public DbColumnType processTypeConvert(String fieldType) {
                                System.out.println("转换类型：" + fieldType);
                                if (fieldType.toLowerCase().contains("datetime")) {
                                    return DbColumnType.TIMESTAMP;
                                }
                                return super.processTypeConvert(fieldType);
                            }
                        })
                        .setDriverName("com.mysql.jdbc.Driver")
                        .setUsername("root")
                        .setPassword("123456")
                        .setUrl("jdbc:mysql://127.0.0.1:3306/scau_homework?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8")
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        //.setDbColumnUnderline(true)//全局下划线命名
                        //.setTablePrefix(new String[]{prefix})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(tables) // 需要生成的表
                        .setRestControllerStyle(false)
                        //.setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体父类
                        .setSuperEntityClass("scau.huangyk.homeworkmanagementsystem.base.BaseModel")
                        // 自定义实体，公共字段
                        .setSuperEntityColumns(new String[]{"createTime", "updateTime", "id"})
                        //.setTableFillList(tableFillList)
                        // 自定义 mapper 父类
                        // .setSuperMapperClass("com.mankind.mnb.common.base.BaseMapper")
                        // 自定义 service 父类
                        //.setSuperServiceClass("com.mankind.mnb.common.base.BaseService")
                        // 自定义 service 实现类父类
                        //.setSuperServiceImplClass("com.mankind.mnb.common.base.BaseServiceImpl")
                        // 自定义 controller 父类
                        .setSuperControllerClass("scau.huangyk.homeworkmanagementsystem.base.BaseController")
                        // 【实体】是否生成字段常量（默认 false）
                        // public static final String ID = "test_id";
                        // .setEntityColumnConstant(true)
                        // 【实体】是否为构建者模型（默认 false）
                        // public User setName(String name) {this.name = name; return this;}
                        // .setEntityBuilderModel(true)
                        // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                        .setEntityLombokModel(true)
                        // Boolean类型字段是否移除is前缀处理
                        .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        //.setModuleName("User")
                        .setParent("scau.huangyk.homeworkmanagementsystem")// 自定义包路径
                        .setController("controller")// 这里是控制器包名，默认 web
                        .setEntity("entity")
                        .setMapper("mapper")
                        .setService("service")
                        .setServiceImpl("service.impl")
                //.setXml("mapper")
        );

        // 执行生成
        mpg.execute();
    }

}
