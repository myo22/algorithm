class RandomizedSet {
    
    private List<Integer> nums;
    private Map<Integer, Integer> locs;
    private Random rand;

    public RandomizedSet() {
        nums = new ArrayList();
        locs = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (locs.containsKey(val)) {
            return false;
        }
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!locs.containsKey(val)) {
            return false;
        }
        int idx = locs.get(val);
        int lastVal = nums.get(nums.size() - 1);
        
        nums.set(idx, lastVal);
        locs.put(lastVal, idx);
        
        nums.remove(nums.size() - 1);
        locs.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(nums.size());
        
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
