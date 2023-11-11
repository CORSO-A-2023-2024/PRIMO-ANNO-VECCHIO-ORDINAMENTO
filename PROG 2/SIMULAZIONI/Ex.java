public class Ex {
    public static void m1()
    {
    if (true) throw new RuntimeException("m1");
    System.out.println("T");
    }

    public static void m2()
    {
    try {
        System.out.println("provo m1");
        m1();
        System.out.println("m1 OK");
    } catch (IllegalArgumentException e) {
        System.out.println("m1 EXC");
    }
    }

    public static void m3()
    {
    try {
        m2();
    } catch (Exception e) {
        System.out.println("m2 EXC");
    } finally {
        System.out.println("CLEANUP");
    }
    }

    public static void main(String[] args)
    {
    m3();
    }
}