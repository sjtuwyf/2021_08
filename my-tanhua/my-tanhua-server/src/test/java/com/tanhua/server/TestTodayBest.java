package com.tanhua.server;

import com.tanhua.server.service.RecommendUserService;
import com.tanhua.server.service.TodayBestService;
import com.tanhua.server.vo.PageResult;
import com.tanhua.server.vo.RecommendUserQueryParam;
import com.tanhua.server.vo.TodayBest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTodayBest {

    @Autowired
    private TodayBestService todayBestService;

    @Autowired
    private RecommendUserService recommendUserService;

//    @Test
//    public void testQueryTodayBest(){
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJtb2JpbGUiOiIxNzYwMjAyNjg2OCIsImlkIjoxfQ.OzoVY9yavYS-albcNGlYg1kKK2pp3QffrmcopfI3IhY";
//        TodayBest todayBest = this.todayBestService.queryTodayBest(token);
//        System.out.println(todayBest);
//    }
//
//    @Test
//    public void testQueryTodayBestList(){
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJtb2JpbGUiOiIxNzYwMjAyNjg2OCIsImlkIjoxfQ.OzoVY9yavYS-albcNGlYg1kKK2pp3QffrmcopfI3IhY";
//        PageResult pageResult = this.todayBestService.queryRecommendUserList(new RecommendUserQueryParam(), token);
//        System.out.println(pageResult);
//    }

    @Test
    public void testQueryTodayBest0(){
        TodayBest todayBest = this.recommendUserService.queryTodayBest(1L);
        System.out.println(todayBest);
    }


}
