package ThreadlerinYarisi;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> mainList = new ArrayList<>();

        for(int i = 1;i<=10000;i++){
            mainList.add(i);
        }

        ArrayList<Integer> list1 = new ArrayList<>(mainList.subList(0,2500));
        ArrayList<Integer> list2 = new ArrayList<>(mainList.subList(2500,5000));
        ArrayList<Integer> list3 = new ArrayList<>(mainList.subList(5000,7500));
        ArrayList<Integer> list4 = new ArrayList<>(mainList.subList(7500,10000));

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        EvenNumberThread thread1 = new EvenNumberThread(list1, evenNumbers);
        EvenNumberThread thread2 = new EvenNumberThread(list2, evenNumbers);
        EvenNumberThread thread3 = new EvenNumberThread(list3, evenNumbers);
        EvenNumberThread thread4 = new EvenNumberThread(list4, evenNumbers);

        OddNumberThread thread5 = new OddNumberThread(list1, oddNumbers);
        OddNumberThread thread6 = new OddNumberThread(list2, oddNumbers);
        OddNumberThread thread7 = new OddNumberThread(list3, oddNumbers);
        OddNumberThread thread8 = new OddNumberThread(list4, oddNumbers);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();

            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Çift Sayılar: " + evenNumbers);
        System.out.println("Tek Sayılar: " + oddNumbers);
    }
}
