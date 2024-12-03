public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        loop(10);
    }
    public static void loop(int n){
        if(n >= 0 ){
            System.out.println(n);
            loop(n-1);
        }

    }

}