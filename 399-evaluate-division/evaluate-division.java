class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> graph=new HashMap<>();
        for (int i=0;i<equations.size();i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            double val=values[i];
            graph.putIfAbsent(a,new HashMap<>());
            graph.putIfAbsent(b,new HashMap<>());
            graph.get(a).put(b,val);
            graph.get(b).put(a,1.0/val);
        }
        double[] res=new double[queries.size()];
        for (int i=0;i<queries.size();i++){
            String src=queries.get(i).get(0);
            String dst=queries.get(i).get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dst)) res[i]=-1.0;
            else if (src==dst) res[i]=1.0;
            else res[i]=dfs(src,dst,graph,1.0,new HashSet<>());
        }
        return res;
    }
    private double dfs(String current,String target,Map<String,Map<String,Double>> graph,double product,Set<String> visited){
        if (current.equals(target)) return product;
        visited.add(current);
        for(Map.Entry<String,Double> neighbor:graph.get(current).entrySet()){
            if (!visited.contains(neighbor.getKey())){
                double res=dfs(neighbor.getKey(),target,graph,product*neighbor.getValue(),visited);
                if (res!=-1.0) return res;
            }
        }
        return -1.0;
    }

}