package net.wanho.test;

import net.wanho.mapper.UserMapper;
import net.wanho.pojo.User;
import net.wanho.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public class Testmybaties {
    private  SqlSession sqlSession;
    private UserMapper mapper;
         @Before
    public void before(){
//             InputStream inputStream = Testmybaties.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//             SqlSessionFactory sf= new SqlSessionFactoryBuilder().build(inputStream);
//               sqlSession= sf.openSession();
                sqlSession=MybatisUtil.getSession();
              mapper = sqlSession.getMapper(UserMapper.class);

         }


          @Test
    public  void add(){
              User user=new User();
              user.setGender("男");
              user.setPassword("123");
              user.setUsername("张超");
              user.setPid(20);
//              sqlSession.update("net.wanho.mapper.UserMapper.addUser",user);
//              sqlSession.commit();
//              sqlSession.close();
              SqlSession session = MybatisUtil.getSession();
              session.update("net.wanho.mapper.UserMapper.addUser",user);
              session.commit();
//              sqlSession.close();
              MybatisUtil.close();

          }

          @Test
         public void getallUser(){
              SqlSession session = MybatisUtil.getSession();
           List list= session.selectList("net.wanho.mapper.UserMapper.getAllUser");
              System.out.println(list);
              session.close();

          }

          @Test
    public  void BYIdUser(){
//              SqlSession session = MybatisUtil.getSession();
//              User user=session.selectOne("net.wanho.mapper.UserMapper.selectuserById",15);
//              System.out.println(user);
//              session.close();
              User user = mapper.selectuserById(15);
              System.out.println(user);
              sqlSession.close();



          }
          @Test
          public  void test03(){
              List<User> user = mapper.Selectlike("张");
              System.out.println(user);
              sqlSession.close();

          }
    @Test
    public  void test04(){
        User user=new User();
        user.setGender("男");
        user.setPassword("123");
        user.setUsername("张超");
        user.setPid(20);
        mapper.adduserReturn(user);
        System.out.println(user.getId());



    }
    @Test
    public  void test05() {
        User user = new User();
        user.setGender("男");
        user.setPassword("123");
        user.setUsername("张超");
        user.setPid(20);
        mapper.adduserReturn2(user);
        System.out.println(user.getId());
        sqlSession.close();
    }
    @Test
    public  void test06(){
//        User user = new User();
//        user.setGender("0");
//        user.setPassword("123");
//        user.setUsername("张超2222");
        mapper.updateUserById("隔壁老张","女",31);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void test07(){
//        User user = new User();
//        user.setGender("0");
//        user.setPassword("123");
//        user.setUsername("张超2222");
        mapper.updateUserById("隔壁老张","女",29);
        sqlSession.commit();
        sqlSession.close();

    }

}
