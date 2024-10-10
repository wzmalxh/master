package optional;

import java.util.Optional;

public class OptionalDemo {
    static class User {
        private String name;

        private String email;

        public User(String n,String e) {
            this.email = e;
            this.name  = n;
        }

        public String getEmail() {
            return email;
        }

        public String getName(){
            return name;
        }
    }

    public static void main(String[] args) {
            User user = new User("wang","2875650822@qq.com");
            Optional.ofNullable(user).ifPresent(u -> System.out.println("User is:" + u.getEmail())
        );
    }
}
