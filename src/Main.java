import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList <String> mal = new MyArrayList<>(10);

        mal.add("ljj");
        mal.add("ljj");
        mal.add("ljj");

        System.out.println(mal.size());
        System.out.println(mal);

        mal.clear();
        System.out.println(mal);

        mal.add("bbb");

        System.out.println(mal.getCapacity());

    }
}
