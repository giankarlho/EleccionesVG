package pruebas;

public class Test {
    public static void main(String[] args) {
//        for (int i=0; i<10;i=i++){
//            System.out.println("i1 " + i) ;
//            i+=1;
//            System.out.println("i2 " + i);
//            System.out.println("Hello world");
//        }
        int i=0;
        System.out.println("i=i++ " + (i=i++));
        System.out.println("i+=1 " + (i+=1));
    }
}
