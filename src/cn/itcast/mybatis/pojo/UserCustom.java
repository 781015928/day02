package cn.itcast.mybatis.pojo;

import java.util.List;

/**
 * Created by czg on 2017/10/10.
 */

public class UserCustom extends User {
    private List<Orders> ordersList;

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return super.toString()+"UserCustom{" +
                "ordersList=" + ordersList +
                '}';
    }
}
