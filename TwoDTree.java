import java.util.*;

public class TwoDTree {
	TwoDTreeNode root;

	/**	Constructor. */
	TwoDTree() {
		root = null;
	}

	/**	Adds a new node with the given 
	 *	x and y coordinates to the TwoDTree.
	 * 
	 * 	@param x: X-coordinate of node.
	 * 	@param y: Y-coordinate of node.
	 *  @throws Exception error if duplicate node.
	 **/
	public void add(int x, int y) throws Exception {
		TwoDTreeNode node = new TwoDTreeNode(x, y); 

		// The tree is empty.
		if (root == null) {
			root = node;
			return;
		}
		
		// Check if the point exists in the tree.
		else if (contains(x, y))
			throw new Exception("Cannot add duplicate node to the tree.");

		// Find a null child in the tree.
		else {
			// Copy of the root node for the traversal.
			TwoDTreeNode temp = root;
			boolean flag = false;

			// Process until reaching null child.
			while (temp != null) {
				// Check the coordinates of the root and new nodes.
				if (temp.xCoord > node.xCoord && !flag)
					 temp = placeNode(temp, node);
				
				// Alternating to the y-coordinate.
				else if (temp.yCoord > node.yCoord && flag)
					 temp = placeNode(temp,  node);

				// Traverse right subtree.
				else {
					// The position to place the point is found.
					if (temp.right == null) {
						temp.right = node;
						temp = null;
					}

					// Continue down the right subtree.
					else
						temp = temp.right;
				}

				// Alternate cases for x and y after comparing the nodes.
				if (!flag)
					flag = true;
				else
					flag = false;
			}
		}
	}

	/**	Finds the next position to place the node.
	 * 
	 * 	@param temp: Temporary copy of the root node.
	 * 	@param node: Data to add onto the tree.
	 * 	@return The updated position.
	 **/
	public TwoDTreeNode placeNode(TwoDTreeNode temp, TwoDTreeNode node) {
		// The position to place the point is found.
		if (temp.left == null) {
			temp.left = node;
			temp = null;
		}

		// Continue down the left subtree.
		else
			temp = temp.left;
		
		return temp;
	}

	/**	Check if coordinate-pair exists within the tree.
	 * 
	 * 	@param x: X-coordinate of node.
	 * 	@param y: Y-coordinate of node.
	 * 	@return True if a node with the given x and y 
	 *	coordinates exist in the tree.
	 **/
	public boolean contains(int x, int y) {
		TwoDTreeNode node = new TwoDTreeNode(x, y); 

		// The tree is empty.
		if (root == null)
			return false;

		// Find duplicate node in the tree.
		else {
			// Temporary node to traverse the tree.
			TwoDTreeNode temp = root;
			boolean flag = false;

			// Process until reaching the duplicate node.
			while (temp != null) {
				// Check if the nodes are equal.
				if (x == temp.xCoord && y == temp.yCoord)
					return true;
				
				// Move to left subtree.
				else if (temp.xCoord > node.xCoord && !flag)
					temp = temp.left;

				// Comparing the y-coordinate.
				else if (temp.yCoord > node.yCoord && flag)
					temp = temp.left;

				// Traverse right subtree.
				else
					temp = temp.right;

				// Alternate cases for x and y after comparing the nodes.
				if (!flag)
					flag = true;
				else
					flag = false;
			}
		}
		
		// Tree contains no duplicate node with the parameters.
		return false;
	}

	/**	A method which prints a level order traversal of the tree. */
	public void levelOrderPrint() {
		Queue<TwoDTreeNode> queue = new LinkedList<TwoDTreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TwoDTreeNode node = queue.poll();
			System.out.print("(" + node.xCoord + "," + node.yCoord + ")");	
		
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}

		System.out.println();
	}

	/**	A nested class encapsulating a node in the TwoDTree. */
	private static class TwoDTreeNode {
		int xCoord;
		int yCoord;
		TwoDTreeNode right;
		TwoDTreeNode left;

		/** Constructor. */
		TwoDTreeNode(int x, int y) {
			xCoord = x;
			yCoord = y;
		}

		/** Constructor. */
		TwoDTreeNode(int x, int y, TwoDTreeNode leftChild, TwoDTreeNode rightChild) {
			xCoord = x;
			yCoord = y;
			left = leftChild;
			right = rightChild;
		}
	}
}
