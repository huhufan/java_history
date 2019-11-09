public class Test {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;
            System.out.println(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finallya");
        }
        try {
            int b = 1 / 0;
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finallya");
        }

    }
}
