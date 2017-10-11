package cn.itcast.mybatis.pojo;

import java.util.List;

/**
 * Created by czg on 2017/10/10.
 */

public class UserQueryVo {
    List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    private UserCustom userCustom;



    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
