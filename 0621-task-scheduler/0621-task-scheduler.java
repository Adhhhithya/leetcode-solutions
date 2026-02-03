class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freq = new HashMap<>();
        for(char task:tasks){
            freq.put(task,freq.getOrDefault(task,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int count : freq.values()){
            pq.add(count);
        }

        int time =0;

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;
            int i=0;
            
            while(i<cycle && !pq.isEmpty()){
                int cnt = pq.poll();
                cnt--;
                if(cnt>0) temp.add(cnt);

                time++;
                i++;
            }

            for(int rem:temp){
                pq.add(rem);
            }

            if(!pq.isEmpty()){
                time += (cycle-i);
            }
        }
        return time;
    }
}