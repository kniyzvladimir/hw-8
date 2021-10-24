public class Main {
    public static void main(String[] args) {
        MyStack <String> ms = new MyStack<>();

        ms.push("00");
        ms.push("10");
        ms.push("20");
        ms.push("30");
        ms.push("40");
        ms.push("50");
        ms.push("60");
        System.out.println(ms);

        System.out.println(ms.size());

        ms.remove(0);
        System.out.println(ms.pop());
        System.out.println(ms.peek());
        System.out.println(ms);
    }
}
