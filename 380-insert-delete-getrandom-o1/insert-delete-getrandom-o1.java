class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int indexToRemove=map.get(val);
        int lastElement=list.get(list.size()-1);
        list.set(indexToRemove,lastElement);
        map.put(lastElement,indexToRemove);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */