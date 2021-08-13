package com.itheima.dao;

import com.itheima.pojo.Province;
import com.itheima.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-07-26  15:12
 */
public class ProvinceDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    public List<Province> findAll() throws Exception {
        String sql = "select * from province";
        List<Province> provinceList = queryRunner.query(sql, new BeanListHandler<>(Province.class));
        return provinceList;
    }
}
