package javatest.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortStudentDemo {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setAge(10);
        stu1.setName("Wang Yu");

        Student stu2 = new Student();
        stu2.setAge(20);
        stu2.setName("Du Yan");

        Student stu3 = new Student();
        stu3.setAge(30);
        stu3.setName("Chen Xiang");

        Student stu4 = new Student();
        stu4.setAge(50);
        stu4.setName("Wang Zimeng");

        Student stu5 = new Student();
        stu5.setAge(50);
        stu5.setName("Wang Zidan");

        List<Student> st = new ArrayList<>();
        st.add(stu1);
        st.add(stu2);
        st.add(stu3);
        st.add(stu4);
        st.add(stu5);

        st.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getAge() < o2.getAge()){
                    return -1;
                }else if(o1.getAge() > o2.getAge()){
                    return 1;
                }else{
                    //年龄相等，比较名字的首字母
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

        for(int i = 0; i< st.size(); i++){
            System.out.println(st.get(i).getName() + "," + st.get(i).getAge() +";");
        }
    }
}
