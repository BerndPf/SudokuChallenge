import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Sudoku {

  static int sudokuAtLine = 2;
  
  byte [] sudoku = new byte [81];
  boolean [] immutables = new boolean [81];
  
  public Sudoku (String sudStr) {
    String sudNmbrs = sudStr.replaceAll("[^0-9]", "");
    if(sudNmbrs.length() != sudoku.length){
      System.out.println("The following sudoku is invalid. Fix Sudokus.csv.");
      System.out.println(sudStr);
      return;
    }
    for(int i=0; i < sudoku.length; i++){
      byte value = (byte) (sudNmbrs.charAt(i) - 48); //ASCII conversion
      sudoku [i] = value;
      if(value == 0){
      	immutables[i] = false;
      }else {
      	immutables[i] = true;
      }
    }
  }
  
  public byte get (int rowID, int columnID){
    int idx = (rowID - 1) * 9 + columnID;
    return sudoku[idx];
  }
  
  public boolean set (int rowID, int columnID, int value){
    int idx = (rowID - 1) * 9 + columnID ;
    if (immutables [idx]){
    	return false;
    }
    sudoku[idx] = (byte) value;
    return true;
  }
  
  @Override
  public String toString (){
    String str="-------------------\n";
    for(int i=0; i<9; i++){
      str += "|";
      for(int j=0; j<9; j++){
        str += sudoku[i * 9 + j];
    	str += (j==2 || j==5) ? "\u2225" : "|";
      }
      str += (i==2 || i==5) ? "\n===================\n" : "\n-------------------\n";
    }
    return str;
  }
  
  public static void main (String [] args){
    String csvSudoku = "Sudokus.csv";
    if(new File("../Sudokus.csv").exists()) csvSudoku = "../Sudokus.csv";
    BufferedReader br = null;
    String line = "";
    List <Sudoku> sudokus = new ArrayList<>();
    try {
      br = new BufferedReader(new FileReader(csvSudoku));
      while ((line = br.readLine()) != null){
        if(!line.equals("")){
    	  sudokus.add(new Sudoku(line));
    	}
      }
    } catch (Exception e) {
    	e.printStackTrace();
    }
    
    System.out.println("Initial sudoku:");
    System.out.println(sudokus.get(sudokuAtLine).toString());
    
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future <?> future = executor.submit(new Runnable() {
      @Override
      public void run() {
        long start = System.currentTimeMillis();
        SudokuSolver.solve(sudokus.get(sudokuAtLine));
        SudokuSolver.verify();
        long end = System.currentTimeMillis();
        System.out.println("Solving finished in: " + (end - start) + " ms\n");
      }
    });
    executor.shutdown();
    try{
      future.get(83930, TimeUnit.MILLISECONDS);
    }catch(TimeoutException e){
      System.out.println("Maximum execution time exceeded");
      System.out.println("Try again :)");
      System.exit(1);
    }catch(Exception e){
      e.printStackTrace();
      System.exit(2);
    }
    
    System.out.println("Final sudoku:");
    System.out.println(sudokus.get(sudokuAtLine).toString());
    
    if(SudokuSolver.isVerified()){
      System.out.println("Mission success!");
    }else{
      System.out.println("Failed: Just try again :) .");
    }
  }
}//endClass
