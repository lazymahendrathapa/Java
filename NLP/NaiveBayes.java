import java.util.*;
import java.lang.*;
import java.io.*;

class ReadFile
{

    private String line;
    private String data = "";

    public String readFile(String filename)
    {

        try
        {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine())!=null)
                  data += line + '\n';

            bufferedReader.close();

        
        }
        catch(FileNotFoundException ex)
        {
             System.out.println("File not exist" + filename);
        }
        catch(IOException ex)
        {
             System.out.println("Error reading to file " + filename);
        }
    
        return data;
    }
}

class Probability
{

private int noOfTimeClassPositiveOccur;
private int noOfTimeClassNegativeOccur;
private int noOfTimeClassNeutralOccur;
private int totalClassOfTrainingSet;

private float probOfPositive;
private float probOfNegative;
private float probOfNeutral;


        public void  setPriorsData(int noOfTimeClassPositiveOccur, int noOfTimeClassNegativeOccur, int noOfTimeClassNeutralOccur)
        {
               this.noOfTimeClassPositiveOccur = noOfTimeClassPositiveOccur;
               this.noOfTimeClassNegativeOccur = noOfTimeClassNegativeOccur;
               this.noOfTimeClassNeutralOccur = noOfTimeClassNeutralOccur;
               this.totalClassOfTrainingSet = (noOfTimeClassPositiveOccur + noOfTimeClassNegativeOccur + noOfTimeClassNeutralOccur);

               calculatePriors();

        }

        private void calculatePriors()
        {
            probOfPositive = (float)(noOfTimeClassPositiveOccur/totalClassOfTrainingSet);
            probOfNegative = (float)(noOfTimeClassNegativeOccur/totalClassOfTrainingSet);
            probOfNeutral = (float)(noOfTimeClassNeutralOccur/totalClassOfTrainingSet);
           
        }

}

class DataSet
{

    //hold the word and frequency
    private HashMap<String, Integer> vocabulary = new HashMap<String, Integer>();
    private ArrayList<String> words = new ArrayList<String>();

    //no of training data for the class   
    private int totalData = 0; 

    public HashMap<String, Integer> getVocabulary()
    {
           return vocabulary;
    }

    //get the list of words
    public void getWords(String data)
    {

            String word = "";

            for(int i=0; i<data.length(); ++i)
            {

                if(data.charAt(i)== ' ' || data.charAt(i)== '\n')
                {
                    words.add(word); 
                    word = "";
                }
                else
                {
                   word +=data.charAt(i);
                }

            }


    }

    public void getTotalData(String data)
    {

       String[] splitByLine = data.split("\n");
   
        for(String temp : splitByLine)
            ++totalData;
    }

    public void displayVocabulary()
      {

     Set<Map.Entry<String,Integer>> set = vocabulary.entrySet();

      System.out.println("Data");
      for(Map.Entry<String , Integer> me : set)
      {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());

      }

      System.out.println("total data: " + totalData);

      }

        
    public void setVocabulary(String data)
    {
            getTotalData(data);     
            getWords(data);

    for( String temp: words)
     {
          if( vocabulary.containsKey(temp))
          {
              int n = vocabulary.get(temp);
              ++n;
              vocabulary.put(temp,n);
          }
          else
          {
                vocabulary.put(temp,1); 
          }
     }

    displayVocabulary();
          
  }

}

public class NaiveBayes
{

   public static void main(String [] args)
   {
      String positiveDataFile = "positiveData.txt";
      String negativeDataFile = "negativeData.txt";
      String neutralDataFile = "neutralData.txt";
      String testDataFile = "testData.txt";

       //read data from file
      ReadFile read = new ReadFile();
      String positiveData = read.readFile(positiveDataFile);
      String negativeData = read.readFile(negativeDataFile);
      String neutralData = read.readFile(neutralDataFile);
 

      DataSet dataSet = new DataSet();
      dataSet.setVocabulary(positiveData);

   }

}
