import java.io.*;

public class FileParser {
    public static Node<String> reader(String fileName){
        String line;
        int level = 0;
		int lastLevel = 0;
        Node<String> root = null;
		Node<String> current;
        try{
            FileReader fileReader = new FileReader("src/" + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            root = new Node<String>(bufferedReader.readLine());
            current = root;

            bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null) {
            	lastLevel = level;
                level = countTabulationLevel(line);

                if(level == (lastLevel + 1)){
					current = current.children.getLast();
				}
				if(lastLevel > level){
					while(lastLevel!=level){
						current = current.parent;
						lastLevel--;
					}
				}
				current.append(line.substring(level, line.length()));

            }

            bufferedReader.close();

        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex){
            System.out.println("Error reading file '" + fileName + "'");
        }
		return root;
    }

    public static String printNodeMenu(Node<String> node){
    	String s = "";
    	int n = 1;
    	for(Node<String> i : node.children){
    		s += i.data + ": press " + n + "\n";
    		n++;
		}
		s += "To speak with an operator: press 0";
    	return s;
	}

    private static int countTabulationLevel(String s){
        int n = 0;
        char[] t = s.toCharArray();
        if(s.length() > 0){
            while(t[n] == '\t'){
                n++;
            }
        }
        return n;
    }
}
