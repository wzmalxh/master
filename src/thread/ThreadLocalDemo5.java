package thread;

import java.sql.Connection;

public class ThreadLocalDemo5 {

    /**
     * 这里使用多个类调用模拟企业级开发过程中的参数传递
     */
    static  class ContextThreadLocalUtil {
        static ThreadLocal<User> userThreadLocal = new ThreadLocal<User>();
    }

    static class User{
        private int age;
        private String name;

        public User(String name, int age){
            this.age = age;
            this.name = name;
        }

        public void setName(String name1) {
            this.name = name1;
            ContextThreadLocalUtil.userThreadLocal.set(new User(name1,1));
        }

        public User getThreadLocal(){
            return ContextThreadLocalUtil.userThreadLocal.get();
        }
    }

    static class User2{
        private int age;
        private String name;

        public User getThreadLocal(){
            return ContextThreadLocalUtil.userThreadLocal.get();
        }
    }


    public static void main(String[] args) {
        User user1 = new User("wangzimeng",5);
        user1.setName("Duyan");
        User2 user2 = new User2();
        System.out.println("user1 local is:"+user1.name);
        System.out.println("User2 local get is:"+ user2.getThreadLocal().name);
    }
}
