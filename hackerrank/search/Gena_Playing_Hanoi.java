import java.io.*;
import java.util.*;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

public class Gena_Playing_Hanoi {

	static BufferedReader bf = new BufferedReader(
		new InputStreamReader(System.in)
	);
	static PrintWriter writer = new PrintWriter(System.out);

	static void close() throws IOException {
		bf.close();
		writer.flush();
		writer.close();
	}

	static int i() {
		return Integer.parseInt(bf.readLine().trim());
	}

	static int[] ni() {}
}
