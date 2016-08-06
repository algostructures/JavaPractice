import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class Solution {
	static final int infinity = Integer.MAX_VALUE;
	static int t , nodes, edges;
	static int[] distance;
	static ArrayList<Edge> list[];
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);
	
	public static void main(String arg[]){
		int t = in.readInt();
		while(t > 0){
			t -= 1;
			nodes = in.readInt();
			edges = in.readInt();
			
			createGraph();
			int start = in.readInt()-1;
			findShortest(start);
			for(int i = 0; i < nodes; i++){
				if(i == start)
					continue;
				else{
					if(distance[i] != Integer.MAX_VALUE)
						out.print(distance[i]+ " ");
					else
						out.print(-1 + " ");
				}
			}
			out.printLine();
		}
		out.flush();
		
	}
	
	private static void createGraph() {
		list = new ArrayList[nodes];
		
		for(int i = 0; i < edges; i++){
			int from, to, weight;
			
			from = in.readInt()-1;
			to = in.readInt()-1;
			weight = in.readInt();
			
			if(list[from] == null)
				list[from] = new ArrayList<>();
			list[from].add(new Edge(to, weight));
			
			if(list[to] == null)
				list[to] = new ArrayList<>();
				
			list[to].add(new Edge(from, weight));
		}
		
	}

	static void findShortest(int node){
		distance = new int[nodes];
		
		for(int i = 0; i < nodes; i++)
			distance[i] = Integer.MAX_VALUE;
		
		
		distance[node] = 0;
		
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Node(node, 0));
		while(priorityQueue.size() > 0){
			Node min = priorityQueue.poll();
			Iterator<Edge> iterator = list[min.node].iterator();
			
			while(iterator.hasNext()){
				Edge curr = iterator.next();
				if(distance[min.node] + curr.weight < distance[curr.to]){
					distance[curr.to] = distance[min.node] + curr.weight;
					priorityQueue.add(new Node(curr.to, distance[curr.to]));
				}
			}
		}
	}

}


class Edge{
	int to, weight;
	public Edge(int to, int weight){
		this.to = to;
		this.weight = weight;
	}

}

class Node implements Comparable<Node>{
	int node, shortestWeight;
	
	public Node(int node, int shortestWeight){
		this.node = node;
		this.shortestWeight = shortestWeight;
	}

	@Override
	public int compareTo(Node obj) {
		return Integer.compare(shortestWeight, obj.shortestWeight);
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
