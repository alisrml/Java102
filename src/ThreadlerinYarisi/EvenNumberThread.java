package ThreadlerinYarisi;

import java.util.ArrayList;

public class EvenNumberThread extends Thread {
    private ArrayList<Integer> inputList;
    private ArrayList<Integer> evenNumbers;

    public EvenNumberThread(ArrayList<Integer> inputList, ArrayList<Integer> evenNumbers) {
        this.inputList = inputList;
        this.evenNumbers = evenNumbers;
    }

    @Override
    public void run() {
        synchronized (evenNumbers) {
            for (Integer num : inputList) {
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                }
            }
        }
    }
}