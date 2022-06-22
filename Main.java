import java.util.Scanner;

public class Main {
    public static void main(String[] args ){
        readInput();
    }

    private static void readInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the data you are interested in Wiki");
        Parser parser = new Parser(scan.nextLine());
        parser.start();
    }
}