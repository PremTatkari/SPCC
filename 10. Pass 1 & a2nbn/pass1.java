import java.io.*;
import java.util.Hashtable;
import java.util.Vector;

class SymTable{
    int symAddress;
    String symbol;
    SymTable(String x, int y){
        symbol = x;
        symAddress = y;
    }
    void print() {
        System.out.println(symbol + "       " + symAddress);
    }
};

class pass1 {
    public static void main(String args[]) throws Exception {
        int loc = -1;
        int z = -1;
        File file = new File(System.getProperty("user.dir") + "\\Desktop\\SPCC\\11. Pass 2 & Count\\text.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        PrintStream out = new PrintStream(new File("ic.txt"));
        PrintStream console = System.out;
        System.setOut(out);

        Hashtable<String,String> ad = new Hashtable<String,String>();
        ad.put("START", "(AD,01)");
        ad.put("END","(AD,02)");

        Hashtable<String,String> is = new Hashtable<String,String>();
        is.put("ADD", "(IS,01)");
        is.put("MOVER", "(IS,05)");
        is.put("MOVEM", "(IS,06)");
        is.put("READ", "(IS,09)");
        is.put("PRINT", "(IS,10)");

        Hashtable<String,String> dl = new Hashtable<String,String>();
        dl.put("DS","(DL,01)");

        Hashtable<String,String> reg = new Hashtable<String,String>();
        reg.put("AREG", "(RG,01)");

        Hashtable<String,String> sym = new Hashtable<String,String>();
        Hashtable<String,Integer> sym2 = new Hashtable<String,Integer>();
        
        Vector<SymTable> sy = new Vector<SymTable>();

        System.out.print("LOC | Immediate code(Pass 1)\n");
        while((st = br.readLine()) != null) {
            System.out.print(loc == -1 ? " -  | ":("\n" + loc++ + " | "));
            String[] word = st.split(" ");
            for(int i = 0; i < word.length; i++) {
                if(word[i].equals(",")) {
                    continue;
                }
                else if(ad.containsKey(word[i])) {
                    System.out.print(ad.get(word[i].strip()) + " ");
                }
                else if(is.containsKey(word[i])) {
                    System.out.print(is.get(word[i].strip()) + " ");
                }
                else if(dl.containsKey(word[i])) {
                    System.out.print(dl.get(word[i].strip()) + " ");
                }
                else if(reg.containsKey(word[i])) {
                    System.out.print(reg.get(word[i].strip()) + " ");
                }
                else {
                    try {
                        int num = Integer.parseInt(word[i].strip());
                        if(loc == -1) {
                            loc = num;
                        }
                        System.out.print("(C," + num + ") ");
                    } catch (Exception e) {
                        if(!sym.containsKey(word[i])){
                            z++; 
                            String z1 = String.valueOf(z); 
                            sym.put(word[i],z1);
		    int a = loc - 1;	
                            sy.addElement(new SymTable(word[i], a)); 
                            sym2.put(z1,a);
                        }
                        System.out.print("(S," + sym.get(word[i].strip()) + ") ");
                        
                    }
                        
                }
                
            }
            
        }
        System.setOut(console);


        File file1 = new File(System.getProperty("user.dir") + "\\ic.txt");
        br.close();
        br = new BufferedReader(new FileReader(file1));
        
        
        st = "";
        while((st = br.readLine()) != null) {
            System.out.println(st);
        }
        br.close();
        br = new BufferedReader(new FileReader(file1));
        st = "";

        System.out.print("\nMachine Code (Pass 2)");
        while((st = br.readLine()) != null) {
            String[] word = st.split(" ");
            boolean seq = st.contains("AD");
            boolean seq0 = st.contains("DL");
            int rflag = 0;
            if(seq || seq0) {
                System.out.println("  ---   ");
                continue;
            }

            else if(!st.contains("RG")) {
                rflag = 1;
            }

            for(int i = 0; i < word.length; i++) {
                boolean seq1 = word[i].contains("IS");
                boolean seq2 = word[i].contains("RG");
                boolean seq3 = word[i].contains("S");
                String rg = "00 ";

                if(seq1) {
                    String str = word[i];  
                    str = str.replaceAll("[^0-9]+", "");
                    int num1 = Integer.parseInt(str);
                    System.out.print(String.format("%02d",num1) + " ");

                    if(rflag == 1) {
                        System.out.print(rg);
                        rflag = 0;
                    }
                }

                if(seq2) {
                    String str = word[i];   
                    str = str.replaceAll("[^0-9]+", "");
                    int num1 = Integer.parseInt(str);
                    rg = String.format("%02d",num1) + " ";
                    System.out.print(rg);
                }

                if(seq3) {
                    if(seq1 == false) {
                        String str = word[i];  
                        str = str.replaceAll("[^0-9]+", "");
                        System.out.print(sym2.get(str) + " ");
                    }
                }
            }
            System.out.println();
        }
    
        System.out.println("\nSymbol Table\nIndex  Symbol  Address");
        for(int i=0; i< sy.size(); i++) { 
            System.out.print(i + "      ");
            sy.get(i).print();
        }
        
        br.close();  
    }
}
	