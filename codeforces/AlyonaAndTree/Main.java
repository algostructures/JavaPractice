/*
Link : http://codeforces.com/problemset/problem/682/C
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
	public static class Node{
		ArrayList<Node> children;
		ArrayList<Long> edge;
		int index;
		public Node(int index){
			this.children = new ArrayList<Node>();
			this.edge = new ArrayList<Long>();
			this.index = index;
		}
	}
	
	public static int countNodes(int source, Node[] tree, int from){
		int count = 0;
		ArrayList<Integer> queue = new ArrayList<Integer>();
		boolean[] visited = new boolean[tree.length];
		visited[source] = true;
		queue.add(source);
		int start = 0;
		while(start <= queue.size()-1){
			source = queue.get(start);
			count++;
			start++;
			for(int i = 0; i < tree[source].children.size(); i++){
				int index = tree[source].children.get(i).index;
				if(!visited[index] && index != from){
					queue.add(index);
					visited[index] = true;
				}
			}
		}
		return count;
	}
	
	public static int solve(Node[] tree, long[] u){
		int source = 0;
		ArrayList<Integer> queue = new ArrayList<Integer>();
		boolean[] visited = new boolean[u.length];
		visited[source] = true;
		queue.add(source);
		long[] path = new long[u.length];
		long[] maxPath = new long[u.length];
		
		int start = 0;
		int ans = 0;
		while(start <= queue.size()-1){
			source = queue.get(start);
			start++;
			for(int i = 0; i < tree[source].children.size(); i++){
				int index = tree[source].children.get(i).index;
				if(!visited[index]){
					path[index] = path[source] + tree[source].edge.get(i);
					maxPath[index] = Math.max(tree[source].edge.get(i), maxPath[source]+tree[source].edge.get(i));
					if(maxPath[index] > u[index]){
						ans+=countNodes(index, tree, source);
					}
					else{
						queue.add(index);
					}
					visited[index] = true;
				}
			}
		}
		return ans;
		
	}
	
	public static void main(String arg[]){
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		long[] u = new long[n];
		Node[] tree = new Node[n];
		for(int i = 0; i < n; i++){
			u[i] = in.readInt();
			tree[i] = new Node(i);
		}
		for(int i = 0; i < n-1; i++){
			int p = in.readInt();
			long c = Long.parseLong(in.readString());
			tree[i+1].children.add(tree[p-1]);
			tree[i+1].edge.add(c);
			tree[p-1].children.add(tree[i+1]);
			tree[p-1].edge.add(c);
		}
		out.printLine(solve(tree,u));
		out.flush();
		out.close();
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
 
