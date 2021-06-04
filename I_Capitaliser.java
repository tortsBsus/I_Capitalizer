import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
class I_Capitaliser
{
   static StringBuilder Switch(int in, StringBuilder Line)
   {
           Line.setCharAt(in,'I');
            return Line;
   }
   static StringBuilder Check(StringBuilder Line)
   {   
      while(Line.indexOf(" i ")!=-1||Line.indexOf("i ")!=-1||Line.indexOf(".i ")!=-1||Line.indexOf(". i ")!=-1)
      {
         if(Line.indexOf("i ")!=-1) Line = Switch(Line.indexOf("i "),Line);   
         else if(Line.indexOf(" i ")!=-1) Line = Switch(Line.indexOf(" i ")+1,Line);
         else if(Line.indexOf(".i ")!=-1) Line = Switch(Line.indexOf(".i ")+1,Line);
         else if(Line.indexOf(". i ")!=-1) Line = Switch(Line.indexOf(". i ")+2,Line);
      }
      return Line;
   }
   public static void main(String args[])
   {
      try
      {
         File Input = new File("Input.txt");
         Scanner Reads =  new Scanner(Input);
         FileWriter Writes = new FileWriter("Output.txt");
         
         while(Reads.hasNextLine())
         {
            String A = Reads.nextLine();
            StringBuilder Line = new StringBuilder(A);
            Line = Check(Line);
            Writes.append(Line);
            Writes.append("\n");
         }
         Reads.close();
         Writes.close();
      }
      catch(FileNotFoundException X)
      {
         System.out.println("File doesn't exist");
         X.printStackTrace();
      }   
      catch(IOException p)
      {
         
         System.out.println("FileWriter error");
         p.printStackTrace();
      }
   }
}