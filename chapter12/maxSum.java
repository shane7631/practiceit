/* Write a recursive method maxSum that accepts a list of integers L and an 
 * integer limit n as its parameters and uses backtracking to find the maximum 
 * sum that can be generated by adding elements of L that does not exceed n. 
 * Each index's element in the list can be added to the sum only once, but the 
 * same number value might occur more than once in a list, in which case each 
 * occurrence might be added to the sum. You may assume that all values in the 
 * list are non-negative. Your method may alter the contents of the list L as 
 * it executes, but L should be restored to its original state before your 
 * method returns.
 */
public int maxSum(List<Integer> list, int n) {
    return maxSum(list, 0, n, list.size());
}

public int maxSum(List<Integer> list, int i, int n, int rem) {
    if(n <= 0 || rem == 0)
        return 0;
        
    int with = list.get(i) + maxSum(list, i + 1, n - list.get(i), rem - 1);
    int withOut = maxSum(list, i + 1, n, rem - 1);
    
    if(with <= n && n - with < n - withOut)
        return with;
        
    return withOut;
}
