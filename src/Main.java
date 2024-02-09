import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static ArrayList<String> words = new ArrayList<String>();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean done = false;
        words.addAll(Arrays.asList("dogs", "cats", "emory", "george", "crap", "point dexter", "i'm going to jail!", "fraud", "devin", "bail bonds"));
        System.out.println(words);
        while (!done) {
            String input = InputHelper.getRegExString(scan, "Options: \nA - Add an item to the list\nD - delete item from the list\nP - prints list\nQ - quit the program", "[AaDdPpQq]");
            if (input.equalsIgnoreCase("a")) {
                add();
            }
            else if (input.equalsIgnoreCase("d")) {
                delete();
            }
            else if (input.equalsIgnoreCase("p")) {
                printList();
            }
            else if (input.equalsIgnoreCase("q")) {
                quit();
            }
        }

    }
    public static void add(){
       String word = InputHelper.getNonZeroLenString(scan, "Please enter a string to insert into the list");
       int index = InputHelper.getRangedInt(scan, "Please enter the index at which you would like the add the String", 0, words.size()-1);
        words.add(index, word);
    }
    public static void delete(){
        int index = InputHelper.getRangedInt(scan, "Please enter the index at which you would like the remove the String", 0, words.size()-1);
        words.remove(index);
    }
    public static void printList(){
        for (int i = 0; i < words.size(); i++) {
            System.out.println(i + " - " + words.get(i));
        }
    }
    public static void quit(){
        if (InputHelper.getYNConfirm(scan, "Please enter Y to continue or N to quit")) {
            System.exit(0);
        }
    }


}