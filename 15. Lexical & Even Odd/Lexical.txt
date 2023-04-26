import java.util.Scanner;
import java.util.Vector;

public class Lexical {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter line: ");
        String line = sc.nextLine();
        String words[] = line.split(" ");

        Vector<String> symtab = new Vector<String>();
        System.out.println();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("If") || words[i].equals("then")) {
                System.out.print("(k)");
            }

            else if (words[i].equals("like") || words[i].equals("hate")) {
                System.out.print("(v)");
            }

            else if (words[i].equals("they")) {
                System.out.print("(a)");
            }

            else if (words[i].equals("$")) {
                System.out.print("<eof>");
            }

            else {
                String str = words[i];
                if (words[i].contains(".")) {
                    int j = words[i].indexOf(".");
                    str = words[i].substring(0, j);
                }

                if (!symtab.contains(str)) {
                    symtab.add(str);
                }
                System.out.print("(n," + (symtab.indexOf(str) + 1) + ")" + (words[i].contains(".") ? "(op)" : ""));
            }
        }
        System.out.println("\n\nSymbol table\n" + symtab);
        for (int i = 0; i < symtab.size(); i++) {
            System.out.print("  [" + (i + 1) + "] ");
        }
    }
}
//If dogs hate cats then they chase. If cats like milk then they drink. $
