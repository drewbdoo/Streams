import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamAssignments {

    public static void main(String[] args) {
//        //Average of Numbers assignment
//        averageOfNumbers();

//        //Average of Selected Numbers assignment
//        averageOfSelectedNumbers();

//        //Positive numbers assignment
//        List<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(7);
//        list.add(4);
//        list.add(2);
//        list.add(6);
//        positive(list);



    }


    public static List<Integer> positive(List<Integer> numbers){
//        ArrayList<Integer> values = numbers.stream()
        List<Integer> values = numbers.stream()
                .filter(value -> value%2==0)
//                .collect(Collectors.toCollection(ArrayList::new));
                .collect(Collectors.toList());
         return values;
    }

    private static void averageOfSelectedNumbers() {

        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop");
        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                break;
            }
            inputs.add(row);
        }

        System.out.println("Print the average of the negative numbers of the positive numbers? (n/p)");
        String reply = scanner.nextLine();
        if(reply.equalsIgnoreCase("p")){
            double average = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number>0)
                    .average()
                    .getAsDouble();
            System.out.println("Average number: " + average);

        }else {
            double average = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number<0)
                    .average()
                    .getAsDouble();
            System.out.println("Average number: " + average);
        }
    }

    private static void averageOfNumbers() {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop");
        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                break;
            }
            inputs.add(row);
        }
        double average = inputs.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .average()
                .getAsDouble();
        System.out.println("Average number: " + average);
    }
}
