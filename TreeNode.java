/**
 * The TreeNode class
 * @author rogeliobecerra
 *
 * @param <T> data type of Node
 */
public class TreeNode<T> {

	private T data;
	TreeNode<T> left = null;
	TreeNode<T> right = null;
	
	/**
	 * Constructor
	 * @param data value passed into node
	 */
	public TreeNode(T data) {
		this.data = data;
	}
	
	/**
	 * Constructor - deep copy
	 * @param copy node being copied
	 */
	public TreeNode(TreeNode<T> copy) {
		this.data = copy.data;
		this.left = copy.left;
		this.left = copy.right;
	}
	
	/**
	 * return data of Node
	 * @return data value passed into node
	 */
	T getData(){
		return data;
		
	}
}
