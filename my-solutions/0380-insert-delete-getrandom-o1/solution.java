class RandomizedSet {
    
    private List<Integer> nums;
    private Random rand;

    public RandomizedSet() {
        nums = new ArrayList();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (nums.contains(val)) {
            return false;
        }
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!nums.contains(val)) {
            return false;
        }    
        nums.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        int rIndex = rand.nextInt(nums.size());
        
        return nums.get(rIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
