# 课室安排系统

* 前端采用Vue、Element UI。

* 后端采用Spring Boot、Spring Security、Redis & Jwt。

* 环境要求:JDK1.8+,MySQL,Maven,Vue,Junit4


## 题目要求

给定Excel格式的课室,课程,教师等信息,要求将给定的数据导入数据库,然后完成课室自动安排

(1)教室表:每个教室设定编号,教室状态,课室的座位数,教室状态等

(2)课程表:上课名称,任课教师姓名,上课人数,上课时间等

要求:根据教室表和课程表进行安排,可以根据教室情况生成这个教室的安排表,可以根据教师情况生成上课表,可以查询教室在某一个时间的状态,可以预约安排教室等等.

## 数据来源

根据得到的数据,我们将数据按照题目的要求进行更新,得到的新的EXCEL表存于

 [数据.xlsx](..\课室安排系统\数据.xlsx) 

## 实现功能

1.  课室功能:将课室数据导入数据库,显示在页面上.内置增删改查功能
2.  课程功能:将课程数据导入数据库,显示在页面上,内置增删改查功能
3.  课室安排功能:通过课室和课程的数据完成课室自动安排,内置增删改查功能.

## 页面截图



## 小组成员

20计科(6)班

3120004988谢家俊

3120004974黎兆聪

3120004984王文辉

3120004970黄俊龙

