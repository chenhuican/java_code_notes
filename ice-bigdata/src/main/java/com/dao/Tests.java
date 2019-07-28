package com.dao;

import org.apache.hadoop.tools.TableListing;
import scala.reflect.internal.Trees;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * JAVA注解是元数据 相当于对JAVA的方法、类、域进行标注。
 * 如果不进行处理 那么相当于没有 ，如果进行处理，可以根据注解配置 可以用反射对原来的类、方法、域进行处理
 */
public class Tests {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("Mikkey");

        Filter f3 = new Filter();
        f3.setEmail("liu@sina.com,zh@163.com,lia@qq.com");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println("sql1 = " + sql1);
        System.out.println("sql2 = " + sql2);
        System.out.println("sql3 = " + sql3);
    }

    private static String query(Object f) {
        StringBuilder sb = new StringBuilder();
        //1、获取到class
        Class c = f.getClass();
        //2、获取table名称
        boolean exists = c.isAnnotationPresent(Table.class);
        if(!exists) {
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");

        //3、遍历表所有的字段
        Field[] fArray = c.getDeclaredFields();
        for(Field field :fArray) {
            //4.1 拿到字段名
            boolean fExists = field.isAnnotationPresent(Column.class);
            if(!fExists){
                continue;
            }

            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            //4.2 拿到字段值(利用反射：先取到方法名，然后再调用)
            String fieldName = field.getName();
            // 第一个字母大写拼接get方法
            String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);

            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = getMethod.invoke(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //4.3拼装SQL
            if(fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue == 0)) {
                continue;
            }
            sb.append(" and ").append(columnName);

            if(fieldValue instanceof String){
                if(((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" in(");
                    for(String v:values){
                        sb.append("'").append(v).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                } else {
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            }else if(fieldValue instanceof Integer) {
                sb.append("=").append(fieldValue);
            }

        }

        return sb.toString();
    }
}
