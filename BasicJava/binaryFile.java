import java.io.*;

public class binaryFile 
{

    public static void main(String [] args)
    {

        String fileName = "temp.txt";

        try
        {

            String bytes = "Hello theren";
            byte[] buffer = bytes.getBytes();

           FileOutputStream outputStream = new FileOutputStream(fileName);

           outputStream.write(buffer);

           outputStream.close();


        }
        catch(IOException ex)
        {
             System.out.println("Error writing file " + fileName);
        }

        try
        {
            
                byte[] buffer = new byte[50];

                FileInputStream inputStream = new FileInputStream(fileName);

                int nRead = 0;

                while((nRead = inputStream.read(buffer)) != -1)
                {
                    System.out.println(new String(buffer));
                }

                inputStream.close();

        }
        catch(FileNotFoundException ex)
        {
          System.out.println("Unable to open file " + fileName);
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file" );
        }
    }

}
