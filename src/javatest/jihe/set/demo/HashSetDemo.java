package javatest.jihe.set.demo;

import javatest.jihe.set.demo.People;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
      /*  Set<String> st = new HashSet<>();
        st.add("wang");
        st.add("du");
        st.add(null);
        st.add("zi");
        st.add("du");
        System.out.println(st);*/
        HashSet hs = new HashSet();

        hs.add(new People("a1",11));
        hs.add(new People("a2",12));
        hs.add(new People("a3",13));
        hs.add(new People("a2",12));
        hs.add(new People("a4",14));

        Iterator it = hs.iterator();

        while(it.hasNext()) {
            People p = (People) it.next();
            System.out.println(p.getName() + ":" + p.getAge());

        }
    }
}
