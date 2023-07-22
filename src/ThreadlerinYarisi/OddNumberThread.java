package ThreadlerinYarisi;

import java.util.ArrayList;

public class OddNumberThread extends Thread {
    private ArrayList<Integer> inputList;
    private ArrayList<Integer> oddNumbers;

    public OddNumberThread(ArrayList<Integer> inputList, ArrayList<Integer> oddNumbers) {
        this.inputList = inputList;
        this.oddNumbers = oddNumbers;
    }

    @Override
    public void run() {
        synchronized (oddNumbers) {
            for (Integer num : inputList) {
                if (num % 2 != 0) {
                    oddNumbers.add(num);
                }
            }
        }
    }
}
