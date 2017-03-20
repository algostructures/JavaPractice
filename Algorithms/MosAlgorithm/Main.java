/*
 *
	 *   	  {}        *
	 *   	 {{}}       *
	 *      {{{}}}      *
	 *     {{{{}}}}     *
	 *    {{{{{}}}}}    *
	 * In Code We Trust *
 * 
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class Main {
    public static void main(String arg[]) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        
        int N, Q, BLOCK_SIZE;
        
        N = in.readInt();
        Q = in.readInt();
        
        BLOCK_SIZE = (int)(Math.sqrt(N));
        Query.BLOCK_SIZE = BLOCK_SIZE;
        int a[]= new int[N];
        long answers[] = new long[Q];
        Query[] queries = new Query[Q];
        
        for(int i = 0; i < N; i++){
            a[i] = in.readInt();
        }
        
        for(int i = 0; i < Q; i++){
            queries[i] = new Query(in.readInt(), in.readInt(), i);
        }
        Arrays.sort(queries);
        
        Mo solver = new Mo();
        
        int mo_left = 0;
        int mo_right = -1;
        
        for(Query q : queries){
            int left, right, answer_idx;
            left = q.L;
            right = q.R;
            answer_idx = q.index;
            
            while(mo_right < right){
                mo_right++;
                solver.add(a[mo_right]);
            }
            
            while(mo_right > right){
                solver.remove(a[mo_right]);
                mo_right--;
            }
            
            while(mo_left < left){
                solver.remove(a[mo_left]);
                mo_left++;
            }
            
            while(mo_left > left){
                mo_left--;
                solver.add(a[mo_left]);
            }
            
            answers[answer_idx] = solver.get_answer();
        }
        
        for(int i = 0; i < Q; i++){
            out.printLine(answers[i]);
        }
        out.printLine();
        out.flush();
        out.close();
    }
}

class Query implements Comparable<Query>{
     int index;
     int L;
     int R;
     static int BLOCK_SIZE;
     Query(int L, int R, int index){
         this.L = L;
         this.R = R;
         this.index = index;
     }
    @Override
    public int compareTo(Query o) {
        int block_x = this.L/BLOCK_SIZE;
        int block_y = o.L/BLOCK_SIZE;
        if(block_x != block_y){
            return Integer.compare(block_x, block_y);
        }
        else{
            return Integer.compare(this.L, this.R);
        }
    }    
}


class Mo{
    final static int MAX_VAL = 1005000;
    long[] cnt;
    long current_answer;
    
    void process(int number, int delta){
        current_answer -= cnt[number] * cnt[number] * number;
        cnt[number] += delta;
        current_answer += cnt[number] * cnt[number] * number;
    }
    
    Mo(){
        cnt = new long[MAX_VAL];
        Arrays.fill(cnt, 0);
    }
    
    long get_answer(){
        return current_answer;
    }
    
    void add(int number){
        process(number, 1);
    }
    
    void remove(int number){
        process(number, -1);
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }
}

class IOUtils {

    public static int[] readIntArray(InputReader in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.readInt();
        return array;
    }

}





