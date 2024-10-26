class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new ArrayList<>();
        List<String> currentLine=new ArrayList<>();
        int currentLength=0;
        for (String str:words){
            if (currentLength+str.length()+currentLine.size()>maxWidth){
                result.add(justifyLine(currentLine,currentLength,maxWidth));
                currentLine=new ArrayList<>();
                currentLength=0;
            }
            currentLine.add(str);
            currentLength+=str.length();
        }
        result.add(leftJustifyLine(currentLine,currentLength,maxWidth));
        return result;
    }
    public String justifyLine(List<String> words,int currentLength,int maxWidth){
        int totalSpaces=maxWidth-currentLength;
        int gaps=words.size()-1;
        StringBuilder sb=new StringBuilder();
        if (gaps==0){
            sb.append(words.get(0));
            for (int i=0;i<totalSpaces;i++){
                sb.append(" ");
            }
            return sb.toString();
        }
        int spacesBetweenWords=totalSpaces/gaps;
        int extraSpaces=totalSpaces%gaps;
        for (int i=0;i<words.size();i++){
            sb.append(words.get(i));
            if (i<gaps){
                for (int j = 0; j < spacesBetweenWords + (i < extraSpaces ? 1 : 0); j++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
    private String leftJustifyLine(List<String> words,int currentLength,int maxWidth){
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            line.append(words.get(i));
            if (i < words.size() - 1) line.append(" ");
        }
        while (line.length() < maxWidth) {
            line.append(" ");
        }
        return line.toString();
    }
}