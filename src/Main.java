public class Main {
    public static void main(String[] args) {
        MyArrayList<String> mal = new MyArrayList<>(10);

        mal.add("00");
        mal.add("10");
        mal.add("20");
        mal.add("30");
        mal.add("40");
        mal.add("50");
        mal.add("60");
        mal.remove(1);
        mal.remove(5);
        System.out.println(mal);

        System.out.println(mal.getCapacity());

    }
}
