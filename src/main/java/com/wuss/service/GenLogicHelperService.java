package com.wuss.service;

import com.wuss.dto.SpRiskRecord;
import com.wuss.util.FileUtil;
import com.wuss.util.QueryHelper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.StringWriter;

/**
 */
public class GenLogicHelperService {

    public static void main(String[] args) {

        generateLogic(SpRiskRecord.class);
    }

    /**
     * 生成 文件的方法
     * @param queryClass
     */
    public static void generateLogic(Class queryClass){
        QueryHelper logicDomain =  QueryHelper.build( queryClass);
        String name = QueryHelper.getRealTypeName(queryClass.getName());
        initQueryQry("/com/wuss/qry/"+name+"Qry",logicDomain);
        initQueryLogic("/com/wuss/logic/"+name+"Logic",logicDomain);



    }

    /**
     * 生成logic
     * @param logicName
     * @param queryHelper
     */
    public static void initQueryLogic(String logicName,QueryHelper queryHelper){
        //底层调用 file = new File ( ".", template )
        Template template = Velocity.getTemplate("/src/main/resources/logic.vm");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("domain",queryHelper);

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
//        FileUtil.writeFile("/com.wuss.logic/SpRiskRecordLogic.java",stringWriter.toString());
        FileUtil.writeFile(logicName+".java",stringWriter.toString());
    }

    /**
     * 生成 qry
     * @param queryName
     * @param queryHelper
     */
    public static void initQueryQry(String queryName,QueryHelper queryHelper){
        Template template = Velocity.getTemplate("/src/main/resources/qry.vm");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("domain",queryHelper);

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
//        FileUtil.writeFile("/com.wuss.logic/SpRiskRecordLogic.java",stringWriter.toString());
        FileUtil.writeFile(queryName+".java",stringWriter.toString());
    }




}
