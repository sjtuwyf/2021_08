package com.itheima.dao;

import com.itheima.pojo.Role;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
public interface RoleDao {
    Role findRoleUserByRid(int rid);
}
