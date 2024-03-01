public class Main {
    public static void main(String[] args) {
        Printable lambda = (s) -> "Meow" + s;
        printSomething(lambda);
    }

    static void printSomething(Printable sth) {
        sth.print("!");
    }
}