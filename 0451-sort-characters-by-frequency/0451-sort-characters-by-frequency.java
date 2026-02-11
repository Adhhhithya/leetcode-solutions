class Solution {
    public String frequencySort(String s) {
        Pair[] freq = new Pair[128];

        for(int i=0;i<128;i++){
            freq[i]=new Pair(0,(char)(i));
        }

        for(char ch:s.toCharArray()){
            freq[ch].freq++;
        }

        Arrays.sort(freq, (p1, p2) -> p2.freq - p1.freq);

        StringBuilder res = new StringBuilder();
        for(Pair p : freq){
            if(p.freq==0) break;
            for(int i=0;i<p.freq;i++){
                res.append(p.ch);
            }
        }
        return res.toString();
    }
}
class Pair{
    int freq;
    char ch;
    Pair(int f,char c){
        this.freq =f;
        this.ch =c;
    }
}