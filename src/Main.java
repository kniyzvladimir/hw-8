public class Main {
    public static void main(String[] args) {
        MyArrayList<String> mal = new MyArrayList<>(10);
        MyLinkedList <String> mll = new MyLinkedList<>();

        mll.add("00");
        mll.add("10");
        mll.add("20");
        mll.add("30");
        mll.add("40");
        mll.add("50");
        mll.add("60");
        System.out.println(mll);

        System.out.println(mll.size());
        System.out.println(mll.get(4));

        mll.remove(5);
        System.out.println(mll);
        mll.remove(4);
        System.out.println(mll);
        mll.remove(3);
        System.out.println(mll);
        mll.remove(2);
        System.out.println(mll);
        mll.remove(1);
        System.out.println(mll);
        mll.remove(0);
        System.out.println(mll);
        mll.remove(0);
        System.out.println(mll);

    }
}
