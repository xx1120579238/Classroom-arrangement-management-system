package com.ruoyi.system;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * @className: arrangeInsert
 * @author: Emiya
 * @description: 通过jdbc生成安排表数据
 * @date: 2023/1/1 13:18
 * @version: 1.0
 */
public class arrangeInsert {
    @Test
    public void getPath(){
        System.out.println(System.getProperty("user.dir"));
    }
    @Test
    public void InsertArrange() throws Exception {
        // 取得mysql连接
        String user="root";
        String password="xiejiajun";
        String url="jdbc:mysql://localhost:3306/db_keshe?useSSL=false";
        Connection conn = DriverManager.getConnection(url,user,password);
        //查询全部课程并遍历
        String queCou="select * from db_course ";
        PreparedStatement statement = conn.prepareStatement(queCou,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        Statement statement2 = conn.createStatement();
        //全部课程的集合遍历
        ResultSet cou_Set = statement.executeQuery(queCou);
        //时段数组，课室容量数组
        String []c_time= {"12","34","56"};
        int []capacity={38,42,51,108};
        //最外层循环是一周5天
        for (int i=0;i<5;i++){
            //本层循环是同一时段
            for(int j=0;j<3;j++){

                while(cou_Set.next()){
                    int stuNum= cou_Set.getInt("cr_number");
                    //合适的容量
                    int cap=0;
                    if(stuNum<=38){cap=capacity[0];}
                    else if(stuNum>38 && stuNum<=42){cap=capacity[1];}
                    else if(stuNum>42 && stuNum<=51){cap=capacity[2];}
                    else if(stuNum>51 ){cap=capacity[3];}
                    //查找合适的课室
                    String room_sql="select * from db_class where c_status=? and c_seat= ?";
                    PreparedStatement statement1 = conn.prepareStatement(room_sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

                    statement1.setString(1,"空闲");
                    statement1.setInt(2,cap);
                    ResultSet roomSet = statement1.executeQuery();
                    boolean next_room=roomSet.next();
                    //若没有最合适容量的课室，需重新匹配
                    while((next_room==false)&&cap!=108){
                        for (int k = 0; k +1< 4; k++) {
                            if(cap==capacity[k])
                                cap=capacity[k+1];
                        }
                        statement1.setInt(2,cap);
                        roomSet=statement1.executeQuery();
                        next_room=roomSet.next();
                    }
                    if(next_room) {
                        int c_id = roomSet.getInt("c_id");//教室编号
                        int cr_no = cou_Set.getInt("cr_no");//课程编号
                        String c_name = roomSet.getString("c_name");//教室名称
                        String cr_teachername=cou_Set.getString("cr_teachername");//教师名字
                        int a_week=i+1;//星期
                        String a_time=c_time[j];//节次
                        //插入安排表的值
                        String arr_sql="insert into db_arrange(c_id,cr_no,c_name,cr_teachername,a_week,a_time) "
                                + "values("+"'"+c_id+"',"+"'"+cr_no+"',"+"'"+c_name+"',"+"'"+cr_teachername+"',"
                                +a_week+","+a_time+")";
                        boolean execute = statement1.execute(arr_sql);
                        //插入后更新教室状态
                        String up_room="update db_class set c_status='忙碌' where c_id ="+c_id+";";
                        boolean execute1 = statement1.execute(up_room);
                    } else {
                        cou_Set.previous();
                        break;
                    }
                }
                //在下一个时段将所有课室更新为空闲状态
                String up_room_all="update db_class set c_status='空闲'";
                statement2.execute(up_room_all);
            }

        }
        conn.close();
    }
    public void gennerate(){

    }
}
