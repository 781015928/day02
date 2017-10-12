package cn.itcast.mybatis.mapper;


import cn.itcast.mybatis.pojo.Orders;
import cn.itcast.mybatis.pojo.OrdersCustom;
import cn.itcast.mybatis.pojo.UserCustom;

import java.util.List;

/**
 * 
 * <p>Title: OrdersMapperCustom</p>
 * <p>Description: 订单mapper</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-23上午10:28:43
 * @version 1.0
 */
public interface OrdersCustomMapper {
	List<OrdersCustom> findOrdersUser();
	List<Orders> findOrdersUserResultMap();
	List<Orders> findOrdersUserOrderDetail();
	List<Orders> findOrdersUserOrderItem();
	List<UserCustom> findUserItem();
	List<Orders> findOrderUserLazyLoading();

}
