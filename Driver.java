import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
	public static void main(String[] args) throws Exception {
		/* Example of run:
		 * 
		 * 3, 3, 3, 4, 7, 8, 9, 12, 13, 15  
		 * 3, 3, 3, 3, 9, 12, 15, 24, 50 
		 * 3, 3, 3, 9, 9, 12, 13, 24, 65, 78
		 * 2, 3, 3, 3, 3, 3, 9, 12, 14, 15, 44, 78
		 *
		 * Common elements would be: [3 3 3 9 12].
		 */

		// 2D-array of integers.
		List<List<Integer>> collections = new ArrayList<List<Integer>>();
		List<List<Integer>> set = new ArrayList<List<Integer>>();
		
		// Add lists to collections.
		collections.add(0, new ArrayList<Integer>(Arrays.asList(3,4,9,8,12,15,7,13)));
		collections.add(1, new ArrayList<Integer>(Arrays.asList(15,24,50,12,3,9)));
		collections.add(2, new ArrayList<Integer>(Arrays.asList(78,65,24,13,9,3,12)));
		collections.add(3, new ArrayList<Integer>(Arrays.asList(15,78,14,3,2,9,44,12)));
		
		set.add(0, new ArrayList<Integer>(Arrays.asList(3, 4, 9, 8, 12, 15, 3, 7, 13, 3)));
		set.add(1, new ArrayList<Integer>(Arrays.asList(15, 3, 24, 3, 50, 12, 3, 9, 3)));
		set.add(2, new ArrayList<Integer>(Arrays.asList(78, 9, 3, 65, 3, 24, 13, 9, 3, 12)));
		set.add(3, new ArrayList<Integer>(Arrays.asList(3, 15, 78, 3, 14, 3, 2, 9, 3, 44, 12, 3)));
		
		List<Integer> result = CommonElements.findCommonElements(set);
		
		System.out.println(result);

		/* BST */
		TwoDTree btree = new TwoDTree();
		
		System.out.println("Building a new tree for nodes (30,40)(5,25)(10,12)(70,70)(50,30)(35,40)");
		btree.add(30, 40);
		btree.add(5,25);
		btree.add(10,12);
		btree.add(70,70);
		btree.add(50,30);
		btree.add(35,45);
		
		System.out.println("Level order traversal for this tree is: ");
		btree.levelOrderPrint();
		
		System.out.println("contains(5,25) returned " + btree.contains(5,25));
		System.out.println("contains(10,13) returned " + btree.contains(10,13));
		System.out.println("contains(35,45) returned " + btree.contains(35,45));
		
		System.out.println("Building a new tree for nodes (51,75)(25,40)(10,50)(12,10)(5,90)(70,70)(50,1)");
		btree = new TwoDTree();
		btree.add(51,75);
		btree.add(25,40);
		btree.add(10,50);
		btree.add(12,10);
		btree.add(5,90);
		btree.add(70,70);
		btree.add(50,10);
		btree.add(4,1);
		btree.add(60,80);
		
		System.out.println("Level order traversal for this tree is: ");
		btree.levelOrderPrint();
		
		System.out.println("Contains(51,75) returned: " + btree.contains(51,75));
		System.out.println("Contains(4,1) returned: " + btree.contains(4,1));
		System.out.println("Contains(4, 90) returned " + btree.contains(4,90));
		
		System.out.println("Trying to add duplicate item exception is expected");
		btree.add(60,80);
	}
}
