package euler;

public class P5 implements Runnable{
    final int t = 20;

    public void run() {
        int i = 10;
        while(!isEvenlyDivisible(i, t)){
            i += 2;
        }
        System.out.println(i);
    }
    boolean isEvenlyDivisible(int a, int b){
        for (int i = 2; i <= b; i++) {
            if (a % i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    	long t = System.nanoTime();
        new P5().run();
        System.out.println(System.nanoTime() - t);
    }
}
