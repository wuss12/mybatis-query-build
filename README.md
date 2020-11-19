# mybatis-query-build
针对 mybatis自动生成工具生成的类，如果前台界面查询条件 很多一个个
手写查询条件 比较复杂如果不留意赋值错误 会引入bug，因此引入自动化生成
对应查询的 logic 类
# mybatis 生成配置文件如下
```
<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE generatorConfiguration  
PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"  
"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>

	<context id="generatorTables" targetRuntime="MyBatis3">
		<property name="mergeable" value="false"/>

		<plugin type="org.mybatis.generator.plugins.MapperConfigPlugin">
		<property name="fileName" value="mybatis-config.xml"/>
		<property name="targetPackage" value="/"/>
		<property name="targetProject" value="src/main/resources"/>
		</plugin>
		
		<!--  此处是将Example改名为Criteria 当然 想改成什么都行  -->
		<plugin type="org.mybatis.generator.plugins.RenameExampleClassPlugin">
		<property name="searchString" value="Example"/>
		<property name="replaceString" value="Criteria"/>
		</plugin>

		<plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>

		<!-- 给 MBG 生成的 Java 模型对象增加 equals 和 hashCode 方法 -->
		<plugin type="org.mybatis.generator.plugins.EqualsHashCodePlugin"/>

		<!-- commentGenerator 去除自动生成的注释  -->
		<commentGenerator>
		<property name="suppressDate" value="true" />
		</commentGenerator>

 		<jdbcConnection driverClass="com.mysql.jdbc.Driver"
		connectionURL="jdbc:mysql://127.0.0.1:3306/wuss?useUnicode=true&amp;characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull&amp;remarksReporting=true" userId="root"
		password="123">
		</jdbcConnection>
		<!-- 
		默认false，把JDBC DECIMAL 和 NUMERIC 类型解析为 Integer true，
		把JDBC DECIMAL 和 NUMERIC 类型解析为java.math.BigDecimal 
		-->
		<javaTypeResolver>
		<property name="forceBigDecimals" value="false" />
		</javaTypeResolver>

		<!-- javaModelGenerator是模型的生成信息，这里将指定这些Java model类的生成路径； -->
		<javaModelGenerator targetPackage="com.wuss.domain"
		targetProject="src/main/java">
		<property name="enableSubPackages" value="true" />
		<property name="trimStrings" value="true" />
		</javaModelGenerator>
		
		
		

		<!-- sqlMapGenerator是mybatis 的sqlMapper XML文件的生成信息，包括生成路径等；   先生成xml，在生成java-->
		<sqlMapGenerator targetPackage="com.wuss.dao"
		targetProject="src/main/resources">
		<property name="enableSubPackages" value="true" />
		</sqlMapGenerator>

		<!-- javaClientGenerator是应用接口的生成信息； -->
		<javaClientGenerator type="XMLMAPPER"
		 targetPackage="com.wuss.dao"
		 targetProject="src/main/java">
		<property name="enableSubPackages" value="true" />
		</javaClientGenerator>

		<!-- table是用户指定的被生成相关信息的表，它必须在指定的jdbc连接中已经被建立。可以多个 -->
		 
		<table tableName="sp_risk_record" domainObjectName="SpRiskRecord" ></table>

		
		<!-- 
		<table tableName="app_bind_status" domainObjectName="AppBindStatus" enableCountByExample="false" enableUpdateByExample="false"
			enableDeleteByExample="false" enableSelectByExample="false"
			selectByExampleQueryId="false"></table>
		-->
		 

	</context>
</generatorConfiguration>  
```
对应的生成类
```
 List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(this.getClass().getClassLoader().getResourceAsStream("generatorConfigMyBatis3.xml"));
        List<Context> contexts = config.getContexts();
        for (Context context : contexts){
            System.out.println(context);
        }
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);

        try {
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
            myBatisGenerator.generate(null);
        } catch (InvalidConfigurationException e) {
            assertEquals(2, e.getErrors().size());
        }
```


# 用法
```
GenLogicHelperService.generateLogic(SpRiskRecord.class);
```
其中 SpRiskRecord.class 是mybatis自动生成的 domain
生成的 logic 和 qry 位于 test 目录下：分别位于 logic 和qry 包下

# 生成的查询条件
```
public class SpRiskRecordQry extends PageParameter implements Serializable {

    private Long id;
    private String customerId;
    private String orgCode;
    private String orgName;
    private String riskType;
    private String riskLevel;
    private String remark;
    private Integer createDateStart;
    private Integer createDateEnd;
    private Long createDatetimeStart;
    private Long createDatetimeEnd;
    private long serialVersionUID;
}
```
# 生成的对应查询条件的 logic如下
```
```


@Repository
public class SpRiskRecordLogic{
    
    @Autowired
    private SpRiskRecordMapper spRiskRecordMapper;

    public PageDataList<SpRiskRecord> pageDataLists(SpRiskRecordQry qry){

        PageDataList<SpRiskRecord> pageDomain = new PageDataList<>();

        SpRiskRecordCriteria example = new SpRiskRecordCriteria();

        example.setStart(qry.getStart());
        example.setLimit(qry.getLimit());
        example.setOrderByClause("id desc");

        SpRiskRecordCriteria.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(qry.getCustomerId())){
            criteria.andCustomerIdEqualTo(qry.getCustomerId());
        }

        if (StringUtils.isNotBlank(qry.getOrgCode())){
            criteria.andOrgCodeEqualTo(qry.getOrgCode());
        }

        if (StringUtils.isNotBlank(qry.getOrgName())){
            criteria.andOrgNameEqualTo(qry.getOrgName());
        }

        if (StringUtils.isNotBlank(qry.getRiskType())){
            criteria.andRiskTypeEqualTo(qry.getRiskType());
        }

        if (StringUtils.isNotBlank(qry.getRiskLevel())){
            criteria.andRiskLevelEqualTo(qry.getRiskLevel());
        }

        if (StringUtils.isNotBlank(qry.getRemark())){
            criteria.andRemarkEqualTo(qry.getRemark());
        }

         if (qry.getId() != null){
            criteria.andIdEqualTo(qry.getId());
        }


        if (qry.getCreateDateStart() != null){
            criteria.andCreateDateGreaterThanOrEqualTo(qry.getCreateDateStart());
        }

        if (qry.getCreateDateEnd() != null){
            criteria.andCreateDateLessThanOrEqualTo(qry.getCreateDateEnd());
        }

        if (qry.getCreateDatetimeStart() != null){
            criteria.andCreateDatetimeGreaterThanOrEqualTo(qry.getCreateDatetimeStart());
        }

        if (qry.getCreateDatetimeEnd() != null){
            criteria.andCreateDatetimeLessThanOrEqualTo(qry.getCreateDatetimeEnd());
        }


        int count = spRiskRecordMapper.countByExample(example);
        pageDomain.setTotal(count);

        if (count == 0){
            return pageDomain;
        }

        pageDomain.setRows(spRiskRecordMapper.selectByExample(example));
        return pageDomain;
    }
    
