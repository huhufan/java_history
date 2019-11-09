package com.demo.datapro;

public class Course {
    //课程ID、课程名、课程方向、描述、时长、操作人
    private String courseId,courseName,CoursePath,CourseDes,courseDuration,courseOperator;

    public Course(String courseId, String courseName, String coursePath, String courseDes, String courseDuration, String courseOperator) {
        this.courseId = courseId;
        this.courseName = courseName;
        CoursePath = coursePath;
        CourseDes = courseDes;
        this.courseDuration = courseDuration;
        this.courseOperator = courseOperator;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePath() {
        return CoursePath;
    }

    public void setCoursePath(String coursePath) {
        CoursePath = coursePath;
    }

    public String getCourseDes() {
        return CourseDes;
    }

    public void setCourseDes(String courseDes) {
        CourseDes = courseDes;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseOperator() {
        return courseOperator;
    }

    public void setCourseOperator(String courseOperator) {
        this.courseOperator = courseOperator;
    }
}
