package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.SqlSessionUtils;
import cn.itcast.mybatis.mapper.OrdersCustomMapper;
import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.pojo.Orders;
import cn.itcast.mybatis.pojo.User;
import cn.itcast.mybatis.pojo.UserCustom;
import cn.itcast.mybatis.pojo.UserQueryVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by czg on 2017/10/10.
 */

public class DaoTest {
    @Test
    public void findUserByName() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(SqlSessionUtils.getSqlSessionFactory());
        List<User> userByName = userDao.findUserByName("b");

        for (User user : userByName) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(10);
        System.out.println(user);
        User user2 = new User();
        user2.setUsername("" + (char) (Math.random() * 35535) + (char) (Math.random() * 35535) + (char) (Math.random() * 35535));
        user2.setBirthday(new Date());
        user2.setAddress("" + (char) (Math.random() * 35535) + (char) (Math.random() * 35535) + (char) (Math.random() * 35535));
        userMapper.insertUser(user2);
        sqlSession.commit();
        List<User> userByName = userMapper.findAll();
        userByName.forEach(user1 -> System.out.println(user1));
        sqlSession.close();
    }
    @Test
    public void findUserList() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("b");
       userCustom.setSex("男");
        userQueryVo.setUserCustom(userCustom);
        List<UserCustom> userList = userMapper.findUserList(userQueryVo);
        userList.forEach((user -> System.out.println(user)));
    }

    @Test
    public void findUserCount() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
       // userCustom.setUsername("b");
       // userCustom.setSex("男");
        userQueryVo.setUserCustom(userCustom);
        int userCount = userMapper.findUserCount(userQueryVo);
        System.out.println("userCount"+userCount);
    }
    @Test
    public void findUserByIdResultMap() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserByIdResultMap(22);
        System.out.println("userCount"+user);
    }
    @Test
    public void findUserByIds() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(32);
        UserCustom userCustom = new UserCustom();
         userCustom.setUsername("b");
        UserQueryVo userQueryVo = new UserQueryVo();
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustom(userCustom);
       userMapper.findUserByIds(userQueryVo).forEach((user -> System.out.println(user)));
    }
    @Test
    public void findOrdersUser() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);

        ordersCustomMapper.findOrdersUser().forEach((ordersCustom -> System.out.println(ordersCustom)));
    }
    @Test
    public void OrdersUserResultMap() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);

        ordersCustomMapper.findOrdersUserResultMap().forEach((ordersCustom -> System.out.println(ordersCustom)));
    }
    @Test
    public void findOrdersUserOrderDetail() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);

        ordersCustomMapper.findOrdersUserOrderDetail().forEach((ordersCustom -> System.out.println(ordersCustom)));
    }
    @Test
    public void findOrdersUserOrderItem() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);

        ordersCustomMapper.findOrdersUserOrderItem().forEach((ordersCustom -> System.out.println(ordersCustom)));
    }
    @Test
    public void findUserItem() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);

        ordersCustomMapper.findUserItem().forEach((userCustom -> System.out.println(userCustom)));
    }
    @Test
    public void findOrderUserLazyLoading() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        List<Orders> orderUserLazyLoading = ordersCustomMapper.findOrderUserLazyLoading();
        for (Orders orders: orderUserLazyLoading){
            User user = orders.getUser();
        }








    }
}
