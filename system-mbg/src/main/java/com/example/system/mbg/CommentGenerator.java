package com.example.system.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义注释生成器
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;
    private boolean addSwaggerAnnotate = false;
    private static final String EXAMPLE_SUFFIX="Example";
    private static final String[] API_MODEL_PROPERTY_FULL_CLASS_NAMES = {
            "io.swagger.annotations.ApiModel",
            "io.swagger.annotations.ApiModelProperty"
    };

    /**
     * 载入配置文件
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));//获取generatorConfig中配置的参数
        this.addSwaggerAnnotate = StringUtility.isTrue(properties.getProperty("addSwaggerAnnotate"));
    }

    /**
     * 给类添加注释
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String remarks = introspectedTable.getRemarks();
        topLevelClass.addJavaDocLine("@ApiModel(\""+remarks+"\")");
    }

    /**
     * 给属性添加注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        if(!StringUtility.stringHasValue(remarks)) return;
        //数据库中特殊字符需要转义
        if(remarks.contains("\"")){
            remarks = remarks.replace("\"","'");
        }
        //根据参数和备注信息判断是否添加备注信息
        if(addRemarkComments){
            addFieldJavaDoc(field, remarks);
        }
        if(addSwaggerAnnotate){
            field.addJavaDocLine("@ApiModelProperty(value = \""+remarks+"\")");
        }
    }

    /**
     * 添加注释
     */
    private void addFieldJavaDoc(Field field, String remarks) {
        //文档注释开始
        field.addJavaDocLine("/**");
        //获取工作系统的换行符
        String line = System.getProperty("line.separator");
        //获取数据库字段的备注信息
        String[] remarkLines = remarks.split(line);
        for (String remarkLine : remarkLines) {
            field.addJavaDocLine(" * " + remarkLine);
        }
        addJavadocTag (field, false);
        field.addJavaDocLine(" */");
    }

    /**
     * 给文件添加东西
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        //只给model中类名没有"Example"的添加swagger注解类的导入
//        if(!compilationUnit.isJavaInterface()&&!compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)){
        if(!compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)){
            if(addSwaggerAnnotate) {
                for (String item : API_MODEL_PROPERTY_FULL_CLASS_NAMES) {
                    compilationUnit.addImportedType(new FullyQualifiedJavaType(item));
                }
            }
        }
    }

}