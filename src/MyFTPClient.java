import java.io.IOException;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;

public class MyFTPClient {
	String str[];

	public static void main(String args[]) throws IOException, FTPException {

		FTPClient f = new FTPClient("huahcoding.com");

		f.login("lstr@huahcoding.com", "12345");

		// FTPClient f = New FTPClient("10.1.1.4");
		System.out.println("connection establish");

		f.setConnectMode(FTPConnectMode.ACTIVE);
		f.setType(FTPTransferType.ASCII);

		// System.out.println("connection establish1");
		for(String x: f.dir()){
			System.err.println(x);
		}
		byte[] w = f.get("/index.html");
		System.err.println(new String(w));

		// System.out.println("connection establish3");

		// System.out.println("connection released");

	}

}
