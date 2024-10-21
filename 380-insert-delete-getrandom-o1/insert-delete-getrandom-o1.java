class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)){
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)){
            int pos=map.get(val);
            int lastElement=list.get(list.size()-1);
            list.set(pos,lastElement);
            map.put(lastElement,pos);
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random random=new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */