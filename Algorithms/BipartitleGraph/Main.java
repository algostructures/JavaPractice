import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;
public class Main {
	
	public static void main(String arg[]){
		InputReader in = new InputReader(System.in);
		int n = in.readInt();
		int e = in.readInt();
		Node[] ar = new Node[n];
		for(int i = 0; i < n; i++){
			ar[i] = new Node(i);
		}
		for(int i = 0; i < e; i++){
			int v1 = in.readInt()-1;
			int v2 = in.readInt()-1;
			ar[v1].adj.add(v2);
			ar[v2].adj.add(v1);
		}
		Bipartition(ar,n);
	}

	private static void Bipartition(Node[] ar, int n) {
		OutputWriter out = new OutputWriter(System.out);
		ar[0].color = 0;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(ar[0]);
		boolean flag = true;
		outer : while(queue.size() != 0){
			Node u = queue.poll();
			
			for(Integer i : u.adj){
				if(ar[i].color == -1){
					ar[i].color = 1-u.color;
					queue.push(ar[i]);
				}
				
				else if(ar[i].color == u.color){
					flag = false;
					break outer;
				}
			}
		}
		
		
		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();
		int count1= 0;
		int count2=0;
		if(flag){
			for(int i = 0; i < n; i++){
				if(ar[i].color == 1){
					s1.append((i+1)+" ");
					count1++;
				}
				else{
					s2.append((i+1)+" ");
					count2++;
				}
			}
			
		out.printLine(count1);
		out.printLine(s1.toString());
		out.printLine(count2);
		out.printLine(s2.toString());
			
			
		}
		else{
			out.printLine("-1");
		}
		
		out.flush();
		out.close();
	}
}

class Node{
	int ind;
	int color;
	ArrayList<Integer> adj;
	Node(int ind){
		adj = new ArrayList<Integer>();
		this.ind = ind;
		color = -1;
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
 
		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
 
		public void printLine(Object...objects) {
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
 
