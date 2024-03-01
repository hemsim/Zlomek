public class Cat implements Printable {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    @Override
    public String print(String suffix) {
        return suffix;
    }
}
