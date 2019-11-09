package com.demo.datapro;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class CourseService {
   // 用户登录
    public int login(String username, String password) {
        for (Map<String, String> map : CourseDaoImpl.getUsersTable()) {
            if (map.get("username") != null && map.get("password").equals(password)) {
                if (username.equals("imooc")) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }
    //普通管理员添加方法
    public void addUser(String username, String password){
        User user = new User(username, password, "普通管理员");
        Map<String,String> map=new HashMap();
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        map.put("userType",user.getUserType());
        CourseDaoImpl.getUsersTable().add(map);
        }
    //查询所有管理员：
    public List<Map<String, String>> getAllUsers(){
        return CourseDaoImpl.getUsersTable();
    }
    //删除管理员：
    public void delUser(String username){
        Iterator<Map<String,String>> it=CourseDaoImpl.getUsersTable().iterator();
        while(it.hasNext()){
            Map<String,String> map=it.next();
            if (map.get("username").equals(username))
                it.remove();
        }
    }
    //添加课程：
    public void addCourse(Course course){
        CourseDaoImpl.getCoursesTable().add(course);
    }

    //查询所有课程信息
    public List<Course> getAllCourse(){
        return CourseDaoImpl.getCoursesTable();
    }
    public List<Course> searchCourse(String s){
        List<Course> courses = new ArrayList<>();
        for (Course course : CourseDaoImpl.getCoursesTable()) {
            if (course.getCourseId().contains(s)||course.getCourseName().contains(s)||course.getCoursePath().contains(s)||
                    course.getCourseDes().contains(s)||course.getCourseDuration().contains(s)||course.getCourseOperator().contains(s)){
                courses.add(course);
            }
        }
        return courses;
    }
}
