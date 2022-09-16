package hellojpa;

public class ValueMain {
    public static void main(String[] args) {

//        Integer a = new Integer(10);
//        Integer b = a;
//
//        System.out.println("a = " + a); // 10
//        System.out.println("b = " + b); // 20

        int a = 10;
        int b = 10;

        System.out.println("a == b " + (a == b));   // true

        Address address1 = new Address("city", "street", "100");
        Address address2 = new Address("city", "street", "100");

        System.out.println("address1 == address2 " + (address1 == address2)); // false
        System.out.println("address1 equals address2: " + (address1.equals(address2))); // false

    }
}
