package RateLimiter;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RateLimiter {
    public static void main(String[] args) throws Exception {
        RateLimiter rt = new RateLimiter();

        rt.logger(new Message("hello",getCurrentTime()));
        rt.logger(new Message("hello",getCurrentTime()));
        rt.logger(new Message("hello",getCurrentTime()));
        TimeUnit.SECONDS.sleep(1);
        rt.logger(new Message("hello",getCurrentTime()));
        rt.logger(new Message("hello",getCurrentTime()));
        rt.logger(new Message("hello",getCurrentTime()));
        rt.logger(new Message("hello",getCurrentTime()));
        
    }

    static final int SIZE = 3;
    static final int TIMESPAN =1;


    Map<String,Queue<Message>> map = new HashMap<>();

    public void logger(Message input) throws Exception {
        Queue<Message> queue;

        if(map.containsKey(input.str)){
            queue = map.get(input.str);
            if( queue.size() + 1 > SIZE ) {


                int firstTime = queue.peek().time;
                if( input.time < firstTime + TIMESPAN ){
                    //throw new Exception("Overflow");
                    System.out.print("Too rush");
                } else {
                    queue.poll();
                    queue.add(input);
                }
            } else {
                queue.add(input);
                map.put(input.str,queue);


            }
        } else{
            queue = new LinkedList<>();
            queue.add(input);
            map.put(input.str,queue);
        }

    }

    public static int getCurrentTime(){
        return  (int) new Date().getTime() / 1000 ;
    }


    static class Message{
        String str;
        int time;
        public Message(String str,int time){
            this.str = str;
            this.time = time;
        }
    }

}
