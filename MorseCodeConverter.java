import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * the MorseCodeConverter class
 * @author rogeliobecerra
 *
 */
public class MorseCodeConverter {
	
	static MorseCodeTree tree = new MorseCodeTree(); 
	
	/**
	 * Constructor
	 */
	public MorseCodeConverter(){
		
	}
	
	/**
	 * 	returns a string with all the data in the tree in LNR order with an space in between them.
	 * @return a string
	 */
	public static String printTree() {
		
		ArrayList<String> arr = new ArrayList<>(tree.toArrayList()); 
		
		Object[] arr2 = arr.toArray();
		
		String print = "";
		for(int i = 0; i < arr2.length;i++) {
			if(i == 12)
				print += arr2[i] + "  ";
			else if(i == arr2.length - 1)
				print += arr2[i];
			else
				print += arr2[i] + " ";
		}
		return print;
		
	}

	
	public static String fetch(String code)
	{
		return tree.fetchNode(tree.getRoot(), code);
	}
	
	
	/**
	 * Converts Morse code into English.
	 * @param code string to convert into English
	 * @return a string
	 */
	public static String convertToEnglish(String code) { 
		MorseCodeTree tree2= new MorseCodeTree();
		code += " ";
		
		//finds amount of spaces
		int space =0;
		for(int i = 0; i < code.length();i++)
		{
			if(code.charAt(i) == ' ')
				space++;
		}
		
		//array to store codes separately 
		String[] codes = new String[space +1];
		//track of how many are filled
		int index = 0;
		
		String temp = "";
		for(int i = 0; i < code.length();i++)
		{
			if(code.charAt(i) != ' ')
			{
				temp += code.charAt(i);
			}
			else if(code.charAt(i) == ' ') {
				codes[index] = temp;
				index++;
				temp = "";
			}
		}
		
		//converts code into letters
		for(int i = 0; i < codes.length;i++)
		{
			if(codes[i] != null)
			{
				if(codes[i].equals("/"))
					codes[i] = " ";
				else
					codes[i] = fetch(codes[i]);
			}
				
		}
		
		String cov = "";
		for(int i = 0; i < codes.length;i++)
		{
			if(codes[i] != null)
				cov += codes[i];
		}
		
		return cov ;
	}

	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	 * @param codeFile file to convert into English
	 * @return a string 
	 * @throws FileNotFoundException if file not found
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		
		FileReader reader = new FileReader(codeFile);
		
		Scanner sc = new Scanner(reader);
		
		String code = sc.nextLine();
		
		return convertToEnglish(code);
	}
	
}
