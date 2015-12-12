import java.net.*;
import java.io.*;

class Whios 
{
  public static  void main(String args[]) throws Exception
  {
     int c;

     //Create a socket connect to internic.net, port 43.
     Socket s = new Socket("internic.net", 43);

     //Obtain input and out streams.
      InputStream in = s.getInputStream();
      OutputStream out = s.getOutputStream();

      String str = (args.length == 0 ? "osborne.com" :args[0]) + "\n";

      //Convert to bytes.
      byte buf[] = str.getBytes();

      //Send request
      out.write(buf);

      //Read and display response.
      while((c = in.read()) != -1)
                    System.out.print((char)c);

      s.close();
  }
}

