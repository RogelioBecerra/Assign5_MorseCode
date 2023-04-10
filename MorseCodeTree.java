import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The MorseCodeTree class
 * @author rogeliobecerra
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root = new TreeNode<>("");

	/**
	 * constructor
	 */
	public MorseCodeTree() { 
		buildTree();
	}
	
	
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}

	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		//base case
		if(code.length() == 0)
			return;
		
		//rec case
		TreeNode<String> temp = root;
		if(code.charAt(0) == '-')
		{
			if(temp.right == null)
			{
				temp.right = new TreeNode<String>(letter);
			}
			else {
				temp = temp.right;
			}
		}
		else if(code.charAt(0) == '.')
		{
			if(temp.left == null)
			{
				temp.left = new TreeNode<String>(letter);
			}
			else {
				temp = temp.left;
			}
		}
		
		String newCode = "";
		for(int i = 1; i< code.length();i++) {
			newCode += code.charAt(i);
		}
		
		addNode(temp,newCode,letter);
		
	}

	@Override
	public String fetch(String code) {
		
		return fetchNode(root,code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		//base case
		if(code.length() == 0) {
			if(root != null)
				return root.getData();
			else
				return "Not Found";
		}
				
		//rec case
		TreeNode<String> temp = root;
		if(code.charAt(0) == '-')
		{
			temp = temp.right;
		}
		else if(code.charAt(0) == '.')
		{
			temp = temp.left;
		}
				
		String newCode = "";
		for(int i = 1; i< code.length();i++) {
			newCode += code.charAt(i);
		}
				
		return fetchNode(temp,newCode);
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException { // Not Needed
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException { // Not Needed
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildTree() {
		//level 1
		setRoot(new TreeNode<String>(""));
		
		//level 2
		insert(".", "e");
		insert("-", "t");
		
		//level 3
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		//level 4
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		//level 5
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
		
	}

	@Override
	public ArrayList<String> toArrayList() {
		
		ArrayList<String> list = new ArrayList<>();
		
		if(root.left != null)
			LNRoutputTraversal(root.left,list);
		
		if(!(root.getData().equals("")))
			list.add(root.getData());
		
		if(root.right != null)
			LNRoutputTraversal(root.right, list);
		
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if(root.left != null)
			LNRoutputTraversal(root.left,list);
		
		if(!(root.getData().equals("")))
			list.add(root.getData());
		
		if(root.right != null)
			LNRoutputTraversal(root.right, list);
	}
	
	
	/**
	 * Returns a string of the Tree in level Order
	 * @return a string in Level order
	 */
	public String levelOrderTraversal() {
		Queue<TreeNode<String>> q = new LinkedList<>();
		String order = "";
		
		TreeNode<String> temp = root;
		q.add(temp);
		
		while(q.size() != 0)
		{
			temp = q.remove();
			
			if(temp.left != null)
				q.add(temp.left);
			
			if(temp.right != null)
				q.add(temp.right);
			
			if(!(temp.getData().equals("")))
				order+= temp.getData() + " ";
		}
		return order;
		
	}
	
	
	
	
	
	
	
	

}
