import java.text.*;
import java.util.*;
import java.lang.*;

class Classifier 
{
     DecimalFormat df;
     Random rand = new Random();
     ArrayList<Neuron> inputLayer = new ArrayList<Neuron>();
     ArrayList<Neuron> hiddenLayer = new ArrayList<Neuron>();
     ArrayList<Neuron> outputLayer = new ArrayList<Neuron>();
     Neuron bias = new Neuron();
     int[] layers;
     int randomWeightMultiplier = 1;
 
     double epsilon = 0.00000000001;
 
     double learningRate = 0.9f;
     double momentum = 0.7f;
 
     //read data from file
      ReadFile read = new ReadFile();
      String positiveData = read.readFile("positiveData.txt");
      String negativeData = read.readFile("negativeData.txt");
      String neutralData = read.readFile("neutralData.txt");
     
      String testData = "Chinese Beijing Chinese";

      DataSet positiveDataSet = new DataSet(positiveData); 
      DataSet negativeDataSet = new DataSet(negativeData);
      DataSet neutralDataSet = new DataSet(neutralData);
 
      TermFrequency termFrequency = new TermFrequency(positiveDataSet.getVocabulary(),negativeDataSet.getVocabulary(),neutralDataSet.getVocabulary());
     
      HashMap<String,LinkedList<Double>> weight = termFrequency.getWeight();

      ArrayList<double[]> inputs = new ArrayList<double[]>();
      ArrayList<double[]> expectedOutputs = new ArrayList<double[]>();
      ArrayList<double[]> resultOutputs = new ArrayList<double[]>();
     
      double[] tests;

      double output[];
    // for weight update all
    final HashMap<String, Double> weightUpdate = new HashMap<String, Double>();
 
      public Classifier()
      {
      
        takeValues(positiveData,new double[]{1});
        takeValues(neutralData, new double[]{0});
        takeValues(negativeData,new double[]{-1});

        NeuralNetwork(9, 9, 1);

        int maxRuns = 50000;
        double minErrorCondition = 0.001;
       
        run(maxRuns, minErrorCondition);

        runTest();
      }

    public void setInput(double inputs[]) {
        for (int i = 0; i < inputLayer.size(); i++) {
            inputLayer.get(i).setOutput(inputs[i]);
        }
    }

    public double[] getOutput() {
        double[] outputs = new double[outputLayer.size()];
        for (int i = 0; i < outputLayer.size(); i++)
            outputs[i] = outputLayer.get(i).getOutput();
        return outputs;
    }
 
   public void activate() {
        for (Neuron n : hiddenLayer)
            n.calculateOutput();
        for (Neuron n : outputLayer)
            n.calculateOutput();
    }
 
 public void applyBackpropagation(double expectedOutput[]) {
 
        // error check, normalize value ]0;1[
/*        for (int i = 0; i < expectedOutput.length; i++) {
            double d = expectedOutput[i];
            if (d <  || d > 1) {
                if (d < 0)
                    expectedOutput[i] = 0 + epsilon;
                else
                    expectedOutput[i] = 1 - epsilon;
            }
        }
*/
         
        int i = 0;
        for (Neuron n : outputLayer) {
            ArrayList<Connection> connections = n.getAllInConnections();
            for (Connection con : connections) {
                double ak = n.getOutput();
                double ai = con.leftNeuron.getOutput();
                double desiredOutput = expectedOutput[i];
 
                double partialDerivative = - 0.5 * (1 - ak)*(1 + ak) * ai
                        * (desiredOutput - ak);
                double deltaWeight = -learningRate * partialDerivative;
                double newWeight = con.getWeight() + deltaWeight;
                con.setDeltaWeight(deltaWeight);
                con.setWeight(newWeight + momentum * con.getPrevDeltaWeight());
            }
            i++;
        }
 
        // update weights for the hidden layer
        for (Neuron n : hiddenLayer) {
            ArrayList<Connection> connections = n.getAllInConnections();
            for (Connection con : connections) {
                double aj = n.getOutput();
                double ai = con.leftNeuron.getOutput();
                double sumKoutputs = 0;
                int j = 0;
                for (Neuron out_neu : outputLayer) {
                    double wjk = out_neu.getConnection(n.id).getWeight();
                    double desiredOutput = (double) expectedOutput[j];
                    double ak = out_neu.getOutput();
                    j++;
                    sumKoutputs = sumKoutputs
                            + (-(desiredOutput - ak) * 0.5 * (1 - ak) * (1 + ak) * wjk);
                }
 
                double partialDerivative = 0.5*(1 + aj) * (1 - aj) * ai * sumKoutputs;
                double deltaWeight = -learningRate * partialDerivative;
                double newWeight = con.getWeight() + deltaWeight;
                con.setDeltaWeight(deltaWeight);
                con.setWeight(newWeight + momentum * con.getPrevDeltaWeight());
            }
        }
    }

private void runTest()
{

    takeTestValues(testData);

    setInput(tests);
    activate();

    double [] finalResult = getOutput();

    System.out.println(testData);
    for(double temp : finalResult)
        System.out.println(temp);
}

private void run(int maxSteps, double minError) {

        double error = 1;

    for (int i = 0; i < maxSteps && error > minError; i++) {
            error = 0;
            for (int p = 0; p < inputs.size(); p++) {
                 
                setInput(inputs.get(p));
                 activate();
   
                output = getOutput();
                resultOutputs.set(p,output);
        
                double[] temp = expectedOutputs.get(p);

                for (int j = 0; j < temp.length; j++) {
                    double err = Math.pow(output[j] - temp[j], 2);
                    error += err;
                }
  
                applyBackpropagation(expectedOutputs.get(p));
            }
        }
        
 // printResult();
            
 // printAllWeights();
}

void printResult()
    {
        System.out.println("NN example training");
        for (int p = 0; p < inputs.size(); p++) {
            System.out.print("INPUTS: ");
                double [] tempin = inputs.get(p);
         
            for (int x = 0; x < layers[0]; x++) {
                System.out.print(tempin[x] + " ");
            }

              double [] tempex = expectedOutputs.get(p);
                
            System.out.print("EXPECTED: ");
            for (int x = 0; x < layers[2]; x++) {
                System.out.print(tempex[x] + " ");
            }

            double [] tempre = resultOutputs.get(p);
            System.out.print("ACTUAL: ");
            for (int x = 0; x < layers[2]; x++) {
                System.out.print(tempre[x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
 
private void NeuralNetwork(int input, int hidden, int output)
{

        this.layers = new int[] { input, hidden, output };
        df = new DecimalFormat("#.0#");
 
        /**
         * Create all neurons and connections Connections are created in the
         * neuron class
         */
        for (int i = 0; i < layers.length; i++) {
            if (i == 0) { // input layer
                for (int j = 0; j < layers[i]; j++) {
                    Neuron neuron = new Neuron();
                    inputLayer.add(neuron);
                }
            } else if (i == 1) { // hidden layer
                for (int j = 0; j < layers[i]; j++) {
                    Neuron neuron = new Neuron();
                    neuron.addInConnectionsS(inputLayer);
                    neuron.addBiasConnection(bias);
                    hiddenLayer.add(neuron);
                }
            }
 
            else if (i == 2) { // output layer
                for (int j = 0; j < layers[i]; j++) {
                    Neuron neuron = new Neuron();
                    neuron.addInConnectionsS(hiddenLayer);
                    neuron.addBiasConnection(bias);
                    outputLayer.add(neuron);
                }
            } else {
                System.out.println("!Error NeuralNetwork init");
            }
        }

        // initialize random weights
        for (Neuron neuron : hiddenLayer) {
            ArrayList<Connection> connections = neuron.getAllInConnections();
            for (Connection conn : connections) {
                double newWeight = getRandom();
                conn.setWeight(newWeight);
            }
        }
        for (Neuron neuron : outputLayer) {
            ArrayList<Connection> connections = neuron.getAllInConnections();
            for (Connection conn : connections) {
                double newWeight = getRandom();
                conn.setWeight(newWeight);
            }
        }
 
        // reset id counters
        Neuron.counter = 0;
        Connection.counter = 0;
}

// random
 private double getRandom() {
        return randomWeightMultiplier * (rand.nextDouble() * 2 - 1); // [-1;1[
    }

private void takeTestValues(String data)
{


tests = new double[9];

 int i = 0;
 String[] dataSplit = data.split(" ");

 
 for( String single : dataSplit)
 {
      for(double value: weight.get(single))
      {

           tests[i] = value;
           ++i;
      }
 }

}

private void takeValues(String data, double[]output)
   {

     String[] dataSplit= data.split("\n");
     
      for(String temp : dataSplit)
      {
          String[] tempSplit = temp.split(" ");

             double[] result = new double[9];
             int i=0;
      
        for(String single : tempSplit)
          {

             for(double value: weight.get(single))
             {
                result[i] = value;
                ++i;
             }
          }

         inputs.add(result); 
          expectedOutputs.add(output);
          resultOutputs.add(new double[]{-2}); 
      }

   }

public void printAllWeights() {
        System.out.println("printAllWeights");
        // weights for the hidden layer
        for (Neuron n : hiddenLayer) {
            ArrayList<Connection> connections = n.getAllInConnections();
            for (Connection con : connections) {
                double w = con.getWeight();
                System.out.println("n=" + n.id + " c=" + con.id + " w=" + w);
            }
        }
        // weights for the output layer
        for (Neuron n : outputLayer) {
            ArrayList<Connection> connections = n.getAllInConnections();
            for (Connection con : connections) {
                double w = con.getWeight();
                System.out.println("n=" + n.id + " c=" + con.id + " w=" + w);
            }
        }
        System.out.println();
    }
}


public class NeuralNetworkClassifier
{

 public static void main(String args[])
{
        Classifier classifier = new Classifier();
}

}

