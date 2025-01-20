class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer,Integer> numIndex=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            numIndex.put(arr[i],i);
        }
        int rows=mat.length;
        int cols=mat[0].length;
        int result=Integer.MAX_VALUE;
        for (int i=0;i<rows;i++){
            int lastElementIndex=Integer.MIN_VALUE;
            for (int j=0;j<cols;j++){
                int indexVal=numIndex.get(mat[i][j]);
                lastElementIndex=Math.max(lastElementIndex,indexVal);
            }
            result=Math.min(result,lastElementIndex);
        }
        for (int j=0;j<cols;j++){
            int lastElementIndex=Integer.MIN_VALUE;
            for (int i=0;i<rows;i++){
                int indexVal=numIndex.get(mat[i][j]);
                lastElementIndex=Math.max(lastElementIndex,indexVal);
            }
            result=Math.min(result,lastElementIndex);
        }
        return result;
    }
}