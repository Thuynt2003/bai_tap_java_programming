package baiThi;


public class ComplexDemo {
    public static void main(String[] args){
        Complex cp1 = new Complex(1,2);
        Complex cp2 = new Complex(3,4);
        cp1.add(cp2);
        cp1.subtract(cp2);
        cp1.multiply(cp2);
        cp1.divide(cp2);
        System.out.println(cp1.add(cp2));
        System.out.println(cp1.subtract(cp2));
        System.out.println(cp1.multiply(cp2));
        System.out.println(cp1.divide(cp2));

    }
}
