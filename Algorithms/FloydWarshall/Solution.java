import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class Solution {
	public static void main(String arg[]){
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		int m = in.readInt();
		//System.out.println(n+" "+m);
		int mat[][] = new int[n+1][n+1];
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j < n+1; j++){
				if(i == j)
					mat[i][j] = 0;
				else
					mat[i][j] = 1000000;
			}
		}
		for(int i = 0; i < m; i++){
			int x = in.readInt();
			int y = in.readInt();
			mat[x][y] = in.readInt();
		}
		
		
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j < n+1; j++){
				for(int k = 1; k < n+1; k++){
					mat[j][k] = Math.min(mat[j][k], mat[j][i]+mat[i][k]);
				}
			}
		}
		
		
		int q = in.readInt();
		for(int i = 0; i < q; i++){
			int x = in.readInt();
			int y = in.readInt();
			//System.out.println(x+" "+y);
			if(mat[x][y] != 1000000)
				out.printLine(mat[x][y]);
			else
				out.printLine("-1");
		}
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
