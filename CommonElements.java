import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommonElements {
	/** Place list items in the HashMap.
	 * 
	 * @param collection: The list to place into the HashMap.
	 * @return: The HaspMap.
	 **/	
	private static<T> HashMap<T, Integer> getHashMap(List<T> collection) {
		HashMap<T, Integer> tempMap = new HashMap<T, Integer>();
		
		// Place the values in the HashMap.
		for (int i = 0; i < collection.size(); i++) {
			if (tempMap.containsKey(collection.get(i))) {
				Integer value = tempMap.get(collection.get(i)) + 1;
				tempMap.put(collection.get(i), value);
			}
			
			// First instance of key.
			else
				tempMap.put(collection.get(i), 1);
		}

		return tempMap;
	}

	/** Finds the elements that are duplicates among the lists.
	 * 
	 * @param collections: Nested list.
	 * @return: List containing common elements.
	 * @note: Average runtime of O(kn), where n is 
	 * the size of input and k is the number of lists.
	 **/
	public static<T> List<T> findCommonElements(List<List<T>> collections) {
		HashMap<T, Integer> commonMap = getHashMap(collections.get(0));
		HashMap<T, Integer> outputMap = getHashMap(collections.get(0));
		List<T> output = new ArrayList<T>();
		
		// List at [0] is set to commonMap.
		collections.remove(0);
		
		// Find the common elements among the lists. 
		for (List<T> list : collections) {
			HashMap<T, Integer> tempMap = getHashMap(list);
			for (T key : commonMap.keySet()) {
				// Find common duplicates among the tempMap set.
				if (tempMap.containsKey(key) && outputMap.containsKey(key)) {
					Integer value = tempMap.get(key);
					Integer prevValue = commonMap.get(key);

					// Overwrite value with item counts in common.
					if (value < prevValue)
						outputMap.put(key, value);
					
					// First list value is the minimum count.
					else
						outputMap.put(key, prevValue);
				}

				// Current key is not found in common among tempMap.
				else
					outputMap.remove(key);
			}
		}

		// Assign common mapped values to list.
		int k = 0;
		for (T key : outputMap.keySet()) {
			while (outputMap.get(key) - k != 0) {
				output.add(key);
				k++;
			}
		
			k = 0;
		}
		
		return output;
	}
}
