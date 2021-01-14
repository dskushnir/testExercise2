import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> listOFPartitions = new ArrayList<>();
    static ArrayList<Integer> listOfNumber = new ArrayList<>();
    static int counterTotalPartition = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Input an integer positive number and a list of smaller positive numbers in one line separated by space,please ");
        String list = sc.nextLine();
        sc.close();
        String withoutWhiteSpace =list.replaceAll("\\s","");
        char[] chars = withoutWhiteSpace.toCharArray();
        listOfNumber.addAll(createListOfNumber(chars));
        int iVol= listOfNumber.get(0);
        currPart(iVol, iVol, 0);
        System.out.println("Total number of partition: " + counterTotalPartition);
    }

    static void currPart(int n, int k, int i) {
        if (n < 0) return;
        if (n == 0) {
            counterTotalPartition++;

        } else {
            if ((n >= k && !listOfNumber.contains(k))) {
                listOFPartitions.add(k);
                currPart(n - k, k, i + 1);
            }
            if (k > 1) currPart(n, k - 1, i);
        }
    }

    public static List<Integer> createListOfNumber(char[] chars) {
        List<Integer> listOfNumber = new ArrayList<>();
        for (char aChar : chars) {
            int n = Character.getNumericValue(aChar);
            if (n < 0) {
                System.out.println("Incorrect a list of numbers");
                throw new IllegalArgumentException();
            } else {
                listOfNumber.add(n);
            }
        }
        return listOfNumber;
    }
}




















































