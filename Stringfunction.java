
import java.util.Scanner;

public class Stringfunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1. Length of a string");
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        System.out.println("Length = " + str.length());
        System.out.println("\n2.Character at a given index");
        System.out.print("Enter String: ");
        str = sc.nextLine();
        System.out.print("Enter index: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.println("Character = " + str.charAt(index));
        System.out.println("\n3. Two strings are equals or not");
        System.out.print("Enter String 1: ");
        String s1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        String s2 = sc.nextLine();
        System.out.println("Equals = " + s1.equals(s2));
        System.out.println("\n4.  Two strings are equals or not by ignoring case");
        System.out.print("Enter String 1: ");
        s1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        s2 = sc.nextLine();
        System.out.println("Equals Ignore Case = " + s1.equalsIgnoreCase(s2));
        System.out.println("\n5.String contains a   specific word");
        System.out.print("Enter String: ");
        str = sc.nextLine();
        System.out.print("Enter word to search: ");
        String search = sc.nextLine();
        System.out.println("Contains = " + str.contains(search));
        System.out.println("\n6. Substring");
        System.out.print("Enter String: ");
        str = sc.nextLine();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        sc.nextLine();
        System.out.println("Substring = " + str.substring(start, end));
        System.out.println("\n7. Replacing a word in the string");
        System.out.print("Enter String: ");
        str = sc.nextLine();
        System.out.print("Enter old word: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter new word: ");
        String newWord = sc.nextLine();
        System.out.println("Result = " + str.replace(oldWord, newWord));
        System.out.println("\n8. Removing spaces");
        System.out.print("Enter String with spaces: ");
        str = sc.nextLine();
        System.out.println("Trim = '" + str.trim() + "'");
        System.out.println("\n9. Splitting a string ");
        System.out.print("Enter String: ");
        str = sc.nextLine();
        System.out.print("Enter delimiter: ");
        String delimiter = sc.nextLine();
        String arr[] = str.split(delimiter);
        System.out.println("Split Result:");
        for (String word : arr) {
            System.out.println(word);
        }
        System.out.println("\n10. To uppercase");
        System.out.print("Enter String: ");
        str = sc.nextLine();
        System.out.println("Upper Case = " + str.toUpperCase());
        System.out.println("\n11.To lowercase");
        System.out.print("Enter String: ");
        str = sc.nextLine();
        System.out.println("Lower Case = " + str.toLowerCase());
        System.out.println("\n12.  The string starts with a given word");
        System.out.print("Enter String: ");
        str = sc.nextLine();
        System.out.print("Enter a word to check: ");
        String prefix = sc.nextLine();
        System.out.println("Starts With = " + str.startsWith(prefix));
        System.out.println("\n13. The string ends with a given word");
        System.out.print("Enter String: ");
        str = sc.nextLine();
        System.out.print("Enter suffix: ");
        String suffix = sc.nextLine();
        System.out.println("Ends With = " + str.endsWith(suffix));
        sc.close();
    }
}
