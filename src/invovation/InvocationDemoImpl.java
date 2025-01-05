package invovation;

public class InvocationDemoImpl implements InvocationDemo{
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
