package ProducerandConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Token {
    private int val;
    private String name;
    public Token(int val , String name){
        this.val = val;
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name + " " + this.val;
    }
}


public class Bucket {
    private ArrayBlockingQueue<Token> que;
    private int RATE;
    public Bucket(int size, int rate){
        this.que = new ArrayBlockingQueue<Token>(size);
        this.RATE = rate;
    }

    public void putToken(Token token){
        try {
            Thread.sleep(this.RATE);
            que.put(token);
        } catch (InterruptedException e ){
            // TODO
            e.printStackTrace();
        }
    }

    public Token getToken(){
        try{
            Thread.sleep(1000);
            return que.take();
        } catch (InterruptedException e ){
            // Todo
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Bucket bucket = new Bucket(20,200);
        PutExecuter putExecuter = new PutExecuter(bucket);
        GetExecuter getExecuter = new GetExecuter(bucket,6);

        List<Thread> putThread = new ArrayList<>();
        for( int i = 0 ; i < 2 ; i++ ){
            putThread.add(new Thread(putExecuter));
        }

        List<Thread> getThread = new ArrayList<>();
        for( int i = 0 ; i < 3 ; i++ ){
            getThread.add(new Thread(getExecuter));
        }

        for(Thread thread : putThread){
            thread.start();
        }
        for(Thread thread : getThread){
            thread.start();
        }
    }
}

// Producer
class PutExecuter implements Runnable {
    private Bucket bucket;
    public PutExecuter(Bucket bucket){
        this.bucket = bucket;
    }
    @Override
    public void run(){
        int counter = 0;
        while( counter < 10 ){
            bucket.putToken(new Token(counter,Thread.currentThread().getName()));
            System.out.println("Put: " + Thread.currentThread().getName() + " " + counter);
            counter++;
        }
    }
}

// Consumer
class GetExecuter implements Runnable {
    public Bucket bucket;
    private int num;
    public GetExecuter(Bucket bucket , int num){
        this.bucket = bucket;
        this.num = num;
    }
    @Override
    public void run(){
        int conuter = 0;
        while( conuter < this.num ){
            System.out.println("Get: " + Thread.currentThread().getName() + " From " + bucket.getToken());
        }
    }
}


