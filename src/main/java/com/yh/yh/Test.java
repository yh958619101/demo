package com.yh.yh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yh
 * @version 1.0
 * @date 2020/7/9 0009 20:01
 */
    public class Test {

        public int stuId; // 学生学号
        public int courseId; // 课程编号
        public int score; // 分数

    public static void main(String[] args) {
        Test Test = new Test();
        Test.courseId = 11;
        Test.score = 90;
        Test.stuId = 1;
        Test Test2 = new Test();
        Test2.courseId = 22;
        Test2.score = 95;
        Test2.stuId = 1;
        Test Test3 = new Test();
        Test3.courseId = 11;
        Test3.score = 99;
        Test3.stuId = 2;
        List<Test> list = new ArrayList<>();
        list.add(Test);
        list.add(Test3);
        list.add(Test2);
        System.out.println(toMap(list));
    }
    /**
     将学生成绩列表转换成两级的Map，用于查询任意学生的任意课程成绩

     参数 list : 一个学年全部学生一学期全部课程成绩
     返回值:  两级的map，key是学生学号，value是这个学生的所有成绩的map（key是课程编号， value 该学生这门课的成绩)
     2. 假设上题中C1类对应着一张数据库中的学生成绩表，其中数据是一个年级所有学生一个学期的所有课程成绩。
     请用一条SQL语句查询出，这个学期得全优（>=90分为优）的学生中总成绩排名前10的学生。

     *
     * @return*/
    public static HashMap<Integer, HashMap<Integer, Integer>> toMap(List<Test> list) {
       // HashMap<Integer, HashMap<Integer, Integer>> map1 = new   HashMap<Integer, HashMap<Integer, Integer>>();
        HashMap<Integer, HashMap<Integer, Integer>> map1 = new HashMap<>();
        for (Test user : list) {
            if(!map1.containsKey(user.getStuId())){
                map1.put(user.getStuId(),new HashMap<Integer, Integer>());
            }
            map1.get(user.getStuId()).put(user.getCourseId(),user.getScore());
        }
        return map1;
    }

        public Test() {
            super();
        }

        public Test(int stuId, int courseId, int score) {
            this.stuId = stuId;
            this.courseId = courseId;
            this.score = score;
        }

        public int getStuId() {
            return stuId;
        }

        public void setStuId(int stuId) {
            this.stuId = stuId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "stuId=" + stuId +
                    ", courseId=" + courseId +
                    ", score=" + score +
                    '}';
        }


    }

