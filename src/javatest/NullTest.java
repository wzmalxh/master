package javatest;

public class NullTest {
    public static void haha() {
        System.out.println("haha");
    }

    public static void main(String[] args) {
        NullTest.haha();
        ((NullTest) null).haha();
       /*** 这行代码看起来是尝试在null对象上调用一个静态方法。实际上，这是不合法的，因为静态方法不能通过null对象来调用。但是，
        由于Java编译器知道haha() 是一个静态方法，并且静态方法不需要类的实例来调用，所以编译器会优化这行代码，
        并直接调用haha() 方法，而不是尝试在null对象上调用它。
        因此，尽管((NullTest) null).haha();
        这行代码看起来像是应该抛出NullPointerException的，但实际上它不会，因为haha() 是一个静态方法，并且Java编译器会优化这种情况
                **/
        ((NullTest) null).haha();
    }
}
