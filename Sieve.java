import java.util.Scanner;
import java.lang.Math;

public class Sieve
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter int >= 2 : ");
        int sieveEnd = input.nextInt();
        boolean[] numbers = createSequence(sieveEnd);
        System.out.println(sieveEnd);
        System.out.println(sequenceToString(numbers));
        for (int i = 0; i < Math.sqrt(numbers.length); i++) {
            if (!numbers[i]) {
                crossOutHigherMultiples(numbers, i);
                System.out.println(sequenceToString(numbers));
            }
        }
        System.out.println(nonCrossedOutSubseqToString(numbers).substring(0, nonCrossedOutSubseqToString(numbers).length()-2));

    }

    public static boolean[] createSequence(int sieveEnd) {
        boolean[] numbers = new boolean[sieveEnd+1];
        for (int i = 0; i <= sieveEnd ; i++) {
            numbers[i] = false;
        }
        numbers[0] = true;
        numbers[1] = true;
        return numbers;
    }

    public static void crossOutHigherMultiples(boolean[] numbers, int factor) {
        for (int i = factor+1; i < numbers.length; i++) {
            if (i%factor == 0 && i != factor) {
                numbers[i] = true;
        }
    }
    }

    public static String sequenceToString(boolean[] numbers) {
        StringBuilder outputString = new StringBuilder();
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i]) {
                outputString.append("[").append(i).append("]");
            }
            else {
                outputString.append(i);
            }
            if (i < numbers.length-1) {
                outputString.append(", ");
            }
        }
        return outputString.toString();
    }

    public static String nonCrossedOutSubseqToString(boolean[] numbers)
    {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
        if (!numbers[i]) {
            outputString.append(i);
            outputString.append(", ");
        }
    }
        return outputString.toString();
    }

}
