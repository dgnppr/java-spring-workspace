package me.dgpr.chapter_2.item_1.grade;

public class GradeFactory {

    public static Grade getGrade(int score) {
        if (score >= 90) {
            return new GradeA();
        }

        return new GradeB();
    }
}
