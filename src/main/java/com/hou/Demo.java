package com.hou;

import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;

import java.util.List;

/**
 * @Description beetl
 * @Author
 * @Date 2019-09-24 16:07
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        ConnectionSource source = ConnectionSourceHelper.getSimple("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false",
                "root", "123456");
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        // 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的，
        UnderlinedNameConversion nc = new UnderlinedNameConversion();
        // 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});


        //使用内置的生成的sql 新增用户，如果需要获取主键，可以传入KeyHolder
        User user = new User();
        user.setAge(19);
        user.setName("xiandafu");
        sqlManager.insert(user);

        //使用内置sql查询用户
        int id = 1;
        user = sqlManager.unique(User.class,id);
        System.out.println(user);

        //模板更新,仅仅根据id更新值不为null的列
        User newUser = new User();
        newUser.setId(1);
        newUser.setAge(20);
        int i = sqlManager.updateTemplateById(newUser);
        System.out.println(i);

        //模板查询
        User query = new User();
        query.setName("xiandafu");
        List<User> list = sqlManager.template(query);
        for (User user1 : list) {
            System.out.println(user1);
        }

        /*//Query查询
        Query userQuery = sqlManager.getQuery(com.hou.User.class);
        List<com.hou.User> users = userQuery.lambda().andEq(com.hou.User::getName,"xiandafy").select();
*/
        /*//使用user.md 文件里的select语句，参考下一节。
        com.hou.User query2 = new com.hou.User();
        query.setName("xiandafu");
        List<com.hou.User> list2 = sqlManager.select("user.select",com.hou.User.class,query2);

        // 这一部分需要参考mapper一章
        UserDao dao = sqlManager.getMapper(UserDao.class);
        List<com.hou.User> list3 = dao.select(query2);*/
    }
}
