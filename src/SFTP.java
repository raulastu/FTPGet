import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTP {

	public static void main(String[] args) throws Exception{
		JSch jsch = new JSch();
        Session session = null;

        String user = "rramirez";
        String pass = "pass";
        String server = "255.255.255.255";
        try {
            session = jsch.getSession(user, server, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(pass);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
//            sftpChannel.get("remotefile.txt", "localfile.txt");
            java.util.List<LsEntry> o = sftpChannel.ls("/home/dir/");
            for (LsEntry string : o) {
				System.err.println(string.getFilename());
			}
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SftpException e) {
            e.printStackTrace();
        }
	}
}
