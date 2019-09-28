package test;

public class Test1 {
    public static void main(String[] args) {
        Integer i01 = 59;
        Integer i02 = Integer.valueOf(59);
        Integer i03 = 59;
        Integer i04 = new Integer(59);
        Integer i05 = 128;
        Integer i06 = Integer.valueOf(128);
        Integer i07 = 128;
        Integer i08 = new Integer(128);
        System.out.println(i01 == i02);
        System.out.println(i01 == i03);
        System.out.println(i01 == i04);
        System.out.println(i05 == i06);
        System.out.println(i05 == i07);
        System.out.println(i05 == i08);
    }
}
