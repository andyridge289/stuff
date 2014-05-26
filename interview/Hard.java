package interview;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Hard {
	
	public static void main(String[] args) {
		Hard h = new Hard();
		h.add();
	}
	
	public void add() {
		try {
			int ret = add(11, 2);
//			System.out.println(String.format("%d + %d = %d", 1, 2, ret));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int add(int a, int b) throws IOException {
		
		byte f = (byte) (a & 0xff);
		return -1;
	}
	
	public byte[] iToB(int x) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    DataOutputStream out = new DataOutputStream(bos);
		out.writeInt(x);
		out.close();
		byte[] int_bytes = bos.toByteArray();
		bos.close();
		return int_bytes;
	}

}
