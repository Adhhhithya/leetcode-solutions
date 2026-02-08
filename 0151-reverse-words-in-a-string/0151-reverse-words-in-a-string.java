class Solution {
    public String reverseWords(String s) {
        int i =0;
        int n= s.length();
        List<String> words = new ArrayList<>();

        while(i<n){
            while(i<n && s.charAt(i)==' ')i++;
            if(i>=n) break;
            int start = i;
            while(i<n && s.charAt(i)!=' ')i++;
            int end = i-1;
            String word = s.substring(start,end+1);
            words.add(word);
        }
        StringBuilder res = new StringBuilder();
        for(int j = words.size()-1;j>=0;j--){
            res.append(words.get(j));
            if(j!=0) res.append(' ');
        }
        return res.toString();
    }
}