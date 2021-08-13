package com.itheima.web.servlet;

import com.itheima.entry.ResultBean;
import com.itheima.pojo.Province;
import com.itheima.service.ProvinceService;
import com.itheima.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 包名:${PACKAGE_NAME}
 *
 * @author Leevi
 * 日期2020-07-26  15:07
 */
@WebServlet("/province")
public class ProvinceServlet extends HttpServlet {
    private ProvinceService provinceService = new ProvinceService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求参数action的值
        String action = request.getParameter("action");
        try {
            Class clazz = this.getClass();
            //根据方法名获取方法
            Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     * @param request
     * @param response
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultBean resultBean = new ResultBean(true);
        try {
            //1. 调用业务层的方法，查询所有联系人
            List<Province> provinceList = provinceService.findAll();
            //2. 将要响应的数据封装到ResultBean对象中
            resultBean.setData(provinceList);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean.setFlag(false);
            resultBean.setErrorMsg("查询失败");
        }

        //将resultBean对象转换成json字符串
        JsonUtils.printResult(response,resultBean);
    }
}
