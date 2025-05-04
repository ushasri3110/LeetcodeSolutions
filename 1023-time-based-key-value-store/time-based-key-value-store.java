class TimeStampedValue{
    public int timestamp;
    public String value;
    public TimeStampedValue(int timestamp,String value){
        this.timestamp=timestamp;
        this.value=value;
    }
}
class TimeMap {
    Map<String,ArrayList<TimeStampedValue>> timeMap;
    public TimeMap() {
        timeMap=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) timeMap.put(key,new ArrayList<>());
        TimeStampedValue ts=new TimeStampedValue(timestamp,value);
        ArrayList<TimeStampedValue> timestampedValues=timeMap.get(key);
        timestampedValues.add(ts);
    }
    
    public String get(String key, int timestamp) {
        String result="";
        if (timeMap.containsKey(key)){
            ArrayList<TimeStampedValue> timestampedValues=timeMap.get(key);
            int low=0;
            int high=timestampedValues.size()-1;
            while (low<=high){
                int mid=(low+high)/2;
                TimeStampedValue ts=timestampedValues.get(mid);
                if (ts.timestamp==timestamp){
                    return ts.value;
                }
                else if (ts.timestamp>timestamp){
                    high=mid-1;
                }
                else {
                    result = ts.value;
                    low=mid+1;
                }

            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */