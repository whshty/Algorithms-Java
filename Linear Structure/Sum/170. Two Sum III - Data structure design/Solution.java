class TwoSum {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
	public void add(int number) {
        if(!map.containsKey(number)) list.add(number);
        map.put(number, map.getOrDefault(number,0) + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0 ; i < list.size(); i++ ){
	        int num1 = list.get(i);
	        int num2 = value - num1;
	        if ( (num1 == num2 && map.get(num1) > 1) || ( num1 != num2 && map.containsKey(num2))) return true;
	    }
	    return false;
	}
}