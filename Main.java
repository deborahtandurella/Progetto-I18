import java.util.Scanner;

public class Main {
    public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
        System.out.println("Test");
        Node<String> root = FileParser.reader("test_file");
		Node<String> current = root;
		// System.out.println(root.toString());
		int option=1;
		boolean running = true;
		while(running) {
			System.out.println(FileParser.printNodeMenu(current));
			option = scan.nextInt();
			if (option == 0) {
				System.out.println("GTFO!\n");
				running = false;
			} else {
				current = current.children.get(option - 1);
			}
		}
    }
}
