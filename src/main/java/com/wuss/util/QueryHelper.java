package com.wuss.util;

import com.wuss.dao.PageParameter;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 */
@Data
public class QueryHelper {
    //查询对象名称，默认和queryClass 一样 命名xxxQry
    private String queryObject;
    private String returnObject;
    //mybatis 生成的 mapper，本地定义为 xxxMapper
    private String mapperName;
    //查询的类，默认是 mybatis生成的 Java 对象 中的属性，继承 自PageParameter
    private static Class queryClass;

    private List<Field> fields;
    //queryClass 中 返回类型是 String 类型的属性
    private  List<String> stringFiles = new ArrayList<>();
    //queryClass 中 返回类型是 日期 类型的属性，默认 含义如下关键字 "date","Date","time","Time"
    private List<String> dateStringFiles = new ArrayList<>();
    //queryClass 中 返回类型是 不是String 类型的 不是日期类型的属性
    private List<String> notStringFiles = new ArrayList<>();

    private Map<String,String> filedAndTypeMap = new LinkedHashMap<>();
    private Set<Map.Entry<String,String>> qrySet ;


    private static List<String> excludeList = Arrays.asList("serialVersionUID");


    private QueryHelper(String returnObject, String queryObject, String mapperName, Class queryClass){
        this.returnObject = returnObject;
        this.queryObject =queryObject;
        this.mapperName = mapperName;
        this.queryClass = queryClass;
    }

    public static QueryHelper build( Class queryClass){
        String returnObject = getRealTypeName(queryClass.getName());
        QueryHelper logicDomain = new QueryHelper(returnObject, returnObject+"Qry", firstUpUpOrLow(returnObject,false)+"Mapper", queryClass);
//        checkBeforeInit();
        initFilesLists(logicDomain);
        initFiledAndTypeMap(logicDomain);
        return logicDomain;
    }




    private static void initFilesLists(QueryHelper logicDomain){
        List<Field> filed = getAllFiled();
        logicDomain.fields = filed;

        filed.forEach(e-> {
            String name = e.getName();
            if (excludeList.contains(name)){
                return;
            }
            if (e.getType() == String.class){
                logicDomain.stringFiles.add(firstUpUpOrLow(name,true));
            }else {
                if (isTime(name)){
                    logicDomain.dateStringFiles.add(firstUpUpOrLow(name,true));
                }else {
                    logicDomain.notStringFiles.add(firstUpUpOrLow(name,true));
                }

            }

        });

    }

    private static List<Field> getAllFiled(){
        List<Field> fieldList = new ArrayList<>();
        while (queryClass != Object.class ){
            Field[] declaredFields = queryClass.getDeclaredFields();
            fieldList.addAll(Arrays.asList(declaredFields));
            queryClass = queryClass.getSuperclass();
            if (queryClass == PageParameter.class){
                break;
            }
        }
        return fieldList;
    }

    private static void checkBeforeInit(){
        if (PageParameter.class.isAssignableFrom(queryClass) ){
            return;
        }
        throw new RuntimeException(queryClass+ "需要继承PageParameter类" );
    }

    private static void initFiledAndTypeMap(QueryHelper queryHelper){
        Map<String, String> map = queryHelper.filedAndTypeMap;
        queryHelper.fields.stream().forEach(e->{
            String name = e.getName();
            String typeName = e.getType().getName();
            typeName = getRealTypeName(typeName);
            if (isTime(e.getName())){
                map.put(name+"Start",typeName);
                map.put(name+"End",typeName);
            }else {
                map.put(name,typeName);
            }
        });

        queryHelper.qrySet = map.entrySet();
    }

    /**
     * 获取 .后面的名称
     * @param timeName
     * @return
     */
    public static String getRealTypeName(String timeName){
        if (StringUtils.isBlank(timeName)){
            return timeName;
        }
        int i = timeName.lastIndexOf('.');
        return timeName.substring(i+1);
    }
    /**
     * 首字母大小写
     * @param str
     * @param bigOrLow ： true : 首字母大写，false 首字母小写
     * @return
     */

    public static String firstUpUpOrLow(String str,boolean bigOrLow){
        if (StringUtils.isBlank(str)){
            return str;
        }
        char firstCh = bigOrLow ? Character.toUpperCase(str.charAt(0)):Character.toLowerCase(str.charAt(0));
        return  firstCh + str.substring(1);

    }

    /**
     * 是否是时间
     * @param string
     * @return
     */
    public static boolean isTime(String string){
        if (StringUtils.isBlank(string)){
            return false;
        }
        List<String> list = Arrays.asList("date","Date","time","Time");
        return list.stream().anyMatch(e-> string.contains(e));
    }
}
