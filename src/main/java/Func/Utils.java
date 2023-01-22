package Func;

import javafx.application.Platform;

public class Utils {

   public static final String MAIN_COLOUR = "";
   public static final String BAD_COLOUR = "";
   public static final String GOOD_COLOUR = "";
   public static final String BORDER_COLOUR = "";
   public static final String SECONDARY1_COLOUR = "";
   public static final String SECONDARY2_COLOUR = "";
   public static final String CHECKBOX_COLOUR = "";

   public static void logClose(){
      System.out.println("[APP] Application has been closed");
      Platform.exit();
   }

   /**
    * Run a python script, with specified arguments
    * @param path
    * @param args
    * @return
    */
   public static boolean runPythonScript(String path, String[] args){
      return true;
   }
}
