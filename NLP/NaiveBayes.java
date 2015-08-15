import java.util.*;
import java.lang.*;
import java.io.*;

class ReadFile
{

    private String line;
    private String data;

    public String readFile(String filename)
    {
         data = "";
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

class DataSet
{

    //hold the word and frequency
    private HashMap<String, Integer> vocabulary = new HashMap<String, Integer>();
    private ArrayList<String> words = new ArrayList<String>();

    //no of training data for the class   
    private int totalData = 0; 

    public DataSet(String data)
    {
        setVocabulary(data);
    }
    public HashMap<String, Integer> getVocabulary()
    {
           return vocabulary;
    }

    public int getTotaldata()
    {
         return totalData;
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

//  displayVocabulary();
          
  }

}


class Probability
{

private int noOfTimeClassPositiveOccur;
private int noOfTimeClassNegativeOccur;
private int noOfTimeClassNeutralOccur;
private int totalClassOfTrainingSet;

private HashMap<String, Integer> positiveVocabulary = new HashMap<String, Integer>();
private HashMap<String, Integer> negativeVocabulary = new HashMap<String, Integer>();
private HashMap<String, Integer> neutralVocabulary = new HashMap<String, Integer>();

private Set<String> tempWordList = new HashSet<String>();

private int totalVocabulary = 0;
private int totalPositiveVocabulary = 0;
private int totalNegativeVocabulary = 0;
private int totalNeutralVocabulary = 0;

//to hold the result of per word probability
private HashMap<String, Float> positiveWordProbability = new HashMap<String,Float>();
private HashMap<String, Float> negativeWordProbability = new HashMap<String,Float>();
private HashMap<String, Float> neutralWordProbability = new HashMap<String,Float>();

private float probOfPositive;
private float probOfNegative;
private float probOfNeutral;

        public Probability(DataSet positiveDataSet, DataSet negativeDataSet, DataSet neutralDataSet)
        {
            noOfTimeClassPositiveOccur = positiveDataSet.getTotaldata();
            noOfTimeClassNegativeOccur = negativeDataSet.getTotaldata();
            noOfTimeClassNeutralOccur = neutralDataSet.getTotaldata();

            totalClassOfTrainingSet = noOfTimeClassPositiveOccur + noOfTimeClassNegativeOccur + noOfTimeClassNeutralOccur;

            calculatePriors();

            positiveVocabulary = positiveDataSet.getVocabulary();
            negativeVocabulary = negativeDataSet.getVocabulary();
            neutralVocabulary = neutralDataSet.getVocabulary();
      
            calculateTotalVocubulary();
            calculateConditionalProbabilites();
        }

        private int getTotalVocabulary(Set<Map.Entry<String,Integer>> set )
        {
             int temp = 0;

             for(Map.Entry<String , Integer> me : set)
              {
                   tempWordList.add(me.getKey());
                   temp += me.getValue();
              }

             return temp;

        }
      
        private void calculateTotalVocubulary()
        {
         
          totalPositiveVocabulary = getTotalVocabulary(positiveVocabulary.entrySet());
          totalNegativeVocabulary = getTotalVocabulary(negativeVocabulary.entrySet());
          totalNeutralVocabulary = getTotalVocabulary(neutralVocabulary.entrySet());

          totalVocabulary = tempWordList.size();    
        
        }
        
        private void calculatePriors()
        {
            probOfPositive = (float)noOfTimeClassPositiveOccur/totalClassOfTrainingSet;
            probOfNegative = (float)noOfTimeClassNegativeOccur/totalClassOfTrainingSet;
            probOfNeutral = (float)noOfTimeClassNeutralOccur/totalClassOfTrainingSet;
           
        }

        private void calculateProblility(HashMap<String, Integer> vocabulary, HashMap<String, Float> wordProbability, int count)
        {

                for(String temp: tempWordList)
                {
                       if(vocabulary.containsKey(temp))
                       {

                            float value = (float)(vocabulary.get(temp) + 1 )/(count + totalVocabulary);
                            wordProbability.put(temp, value);

                       }
                       else
                       {
                            
                            float value = (float)1/(count + totalVocabulary);
                            wordProbability.put(temp, value);

                       }
                }
        }


        private void getResult(Set<Map.Entry<String,Float>> set )
        {

             for(Map.Entry<String , Float> me : set)
              {
                     System.out.println(me.getKey() + "   " + me.getValue());
              }
             System.out.println();

        }
       
        private void calculateConditionalProbabilites()
        {
              calculateProblility(positiveVocabulary, positiveWordProbability, totalPositiveVocabulary );
              calculateProblility(negativeVocabulary, negativeWordProbability, totalNegativeVocabulary);
              calculateProblility(neutralVocabulary, neutralWordProbability, totalNeutralVocabulary);
        }

        public void getResult(DataSet testDataSet)
        {

            HashMap<String, Integer> testVocabulary = new HashMap<String, Integer>();
           
            testVocabulary = testDataSet.getVocabulary();

              float p1 = probOfPositive;
              float p2 = probOfNegative;
              float p3 = probOfNeutral;


            Set<Map.Entry<String, Integer>> set = testVocabulary.entrySet();


             for(Map.Entry<String , Integer> me : set)
              {

                      p1 *= Math.pow(positiveWordProbability.get(me.getKey()),me.getValue());
                      p2 *= Math.pow(negativeWordProbability.get(me.getKey()),me.getValue());
                      p3 *= Math.pow(neutralWordProbability.get(me.getKey()),me.getValue());
                     
              }

             if(p1>p2 && p1>p3)
                     System.out.println("Positive");
        
             else if(p2>p3)
                    System.out.println("Negative");
         
             else
                     System.out.println("Neutral");

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
      String testData = read.readFile(testDataFile);

      //get vocabulary set
      DataSet positiveDataSet = new DataSet(positiveData);
      DataSet negativeDataSet = new DataSet(negativeData);
      DataSet neutralDataSet = new DataSet(neutralData);
      DataSet testDataSet = new DataSet(testData);

      //calculate probability
      Probability probability = new Probability(positiveDataSet, negativeDataSet, neutralDataSet);
       
      //find the result of test data
      probability.getResult(testDataSet);

   }

}
