import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamAssignments {

    public static void main(String[] args) throws IOException {
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
//        System.out.println(list);
//        System.out.println(positive(list));

//        //Divisible assignment
//        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(3);
//        numbers.add(2);
//        numbers.add(-17);
//        numbers.add(-5);
//        numbers.add(7);
//
//        ArrayList<Integer> divisible = divisible(numbers);
//        divisible.stream()
//                .forEach(num -> System.out.println(num));

//        //Printing User Inputs assignment
//        printingUserInputs();
        
//        //Limited numbers assignment
//        limitedNumbers();

//        //Unique Last Names assignment
//        uniqueLastNames();

        //Weighting assignments - commented out original code, replaced with new

//        //Reading Files Per Line assignment
//        List presidents = read("presidents.txt");
//        presidents.forEach(System.out::println);

//        //Books from file
//        readBooks("Books.txt");


    }

    public static List<Book> readBooks(String file) throws IOException {
        return Files.lines(Paths.get(file))
                .map(s->s.split(","))
                .map(s-> new Book(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), s[3]))
                .collect(Collectors.toList());
    }
    public static List<String> read(String file){
        List<String> presidents = new ArrayList<>();
        try{
            Files.readAllLines(Paths.get(file))
                    .forEach(presidents::add);
        }catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
        return presidents;

    }

    private static void uniqueLastNames() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lastNames = new ArrayList<>();
        while(true){
            System.out.println("Continue personal information input? \"quit\" ends");
            String reply = scanner.nextLine();
            if(reply.equalsIgnoreCase("quit")){
                System.out.println("Unique last names in alphabetical order:");
                break;
            }else{
                System.out.println("Input first name:");
                scanner.nextLine();
                System.out.println("Input last name: ");
                String last = scanner.nextLine();
                System.out.println("Input year of birth:");
                scanner.nextLine();
                lastNames.add(last);
            }
        }
        lastNames.stream()
                .distinct()
                .sorted().forEach(System.out::println);
    }

    private static void limitedNumbers() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Input new numbers, will print out your strings when you enter a negative number");
        while(true) {
            int reply = scanner.nextInt();
            if (reply<0) {
                break;
            } else {
                list.add(reply);
            }
        }
        list.stream().filter(value -> value>1 && value<=5).
                forEach(System.out::println);
    }

    private static void printingUserInputs() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Input new strings, will print out your strings when you enter nothing");
        while(true) {
            String reply = scanner.nextLine();
            if (reply.equals("")) {
                break;
            } else {
                list.add(reply);
            }
        }
        list.forEach(System.out::println);
    }

    public static ArrayList<Integer> divisible(ArrayList<Integer> numbers){
        ArrayList<Integer> values = numbers.stream()
                .filter(value -> value%3==0 || value%2==0 || value%5==0)
                .collect(Collectors.toCollection(ArrayList::new));
        return values;

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
