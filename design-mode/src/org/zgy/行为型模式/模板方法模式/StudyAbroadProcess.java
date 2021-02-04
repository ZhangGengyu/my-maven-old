package org.zgy.行为型模式.模板方法模式;

public class StudyAbroadProcess {
    public static void main(String[] args) {
        StudyAbroad studyAbroad = new StudyinAmerica();
    }
}

abstract class StudyAbroad {
    // 模板方法
    public void templateMethod() {
        lookingForSchool(); // 索取学校资料
        applyForEnrol(); // 入学申请
        applyForPassport(); // 办理因私出国护照、出境卡和公证
        applyForVisa(); // 申请签证
        readyGoAbroad(); // 体检、订机票、准备行装
        arriving(); // 抵达
    }

    public void applyForPassport() {
        System.out.println("三.办理因私出国护照、出境卡和公证：");
    }
    public void applyForVisa() {
        System.out.println("四.申请签证：");
    }
    public void readyGoAbroad() {
        System.out.println("五.体检、订机票、准备行装：");
    }

    public abstract void lookingForSchool();
    public abstract void applyForEnrol();
    public abstract void arriving();
}

class StudyinAmerica extends StudyAbroad {
    @Override
    public void lookingForSchool() {
        System.out.println("一.索取学校以下资料：");
    }
    @Override
    public void applyForEnrol() {
        System.out.println("二.入学申请：");
    }
    @Override
    public void arriving() {
        System.out.println("六.抵达目标学校：");
    }
}






