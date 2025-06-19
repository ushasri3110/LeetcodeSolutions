class Solution {
    private String findParent(Map<String,String> parent,String s){
        if (!parent.get(s).equals(s)){
            parent.put(s,findParent(parent,parent.get(s)));
        }
        return parent.get(s);
    }
    private void union(Map<String,String> parent,String a,String b){
        String pa=findParent(parent,a);
        String pb=findParent(parent,b);
        if (!pa.equals(pb)){
            parent.put(pb,pa);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> parent=new HashMap<>();
        Map<String,String> emailToName=new HashMap<>();
        for (List<String> account:accounts){
            String name=account.get(0);
            for (int i=1;i<account.size();i++){
                String email=account.get(i);
                parent.putIfAbsent(email,email);
                emailToName.put(email,name);
                union(parent,account.get(1),email);
            }
        }
        Map<String,TreeSet<String>> merged=new HashMap<>();
        for (String email:parent.keySet()){
            String root=findParent(parent,email);
            merged.putIfAbsent(root,new TreeSet<>());
            merged.get(root).add(email);
        }
        List<List<String>> result=new ArrayList<>();
        for (String root:merged.keySet()){
            List<String> group=new ArrayList<>();
            group.add(emailToName.get(root));
            group.addAll(merged.get(root));
            result.add(group);
        }
        return result;
    }
}