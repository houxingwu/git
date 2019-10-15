import com.hou.User;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.junit.Test;

import java.util.List;

public class Demo {

    @Test
    public void demo(){
        String a = "ZD#D:\\img\\2018\\11\\14\\bzb1233.jpg#D19011813#W#04325#907#0904#RD2#090702#908#190528#912#3";
        String b = "D:\\img\\2018\\11\\14\\bzb1233.jpg";
        String s = b.replaceAll("\\\\", "/");
        System.out.println(s);

    }

    @Test
    public void demoTest(){
        ConnectionSource source = ConnectionSourceHelper.getSimple("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false", "root", "123456");
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        // 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的，
        UnderlinedNameConversion nc = new UnderlinedNameConversion();
        // 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});        //使用内置的生成的sql 新增用户，如果需要获取主键，可以传入KeyHolder
       /* User user = new User();
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
        sqlManager.updateTemplateById(newUser);

        Query<User> userQuery = sqlManager.query(User.class).andEq("name", "xiandafu");
        List<Object> params = userQuery.getParams();

        System.out.println(userQuery);
        System.out.println(params);

        List<User> select = userQuery.select();
        select.forEach(e-> System.out.println(e+">>>>>>>>>>>"));


        //模板查询
        User query = new User();
        query.setName("xiandafu");
        List<User> list = sqlManager.template(query);

        //Query查询
        Query userQuery2 = sqlManager.query(User.class);
        List<User> users = userQuery.lambda().andEq(User::getName,"xiandafy").select();*/

        //使用user.md 文件里的select语句，参考下一节。
        User query2 = new User();
        query2.setName("xiandafu");
        List<User> list2 = sqlManager.select("user.select",User.class,query2);
        list2.forEach(e-> System.out.println(e));

/*      // 这一部分需要参考mapper一章
        UserDao dao = sqlManager.getMapper(UserDao.class);
        List<com.hou.User> list3 = dao.select(query2);*/
    }
}
