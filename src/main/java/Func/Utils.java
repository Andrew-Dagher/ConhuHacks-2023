package Func;

import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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
   Process mProcess;
   public  void runPyScript(String path,String[] args) throws IOException {
      String s;
      String [] cmd = new String[args.length+2];
      cmd[0] = "python";
      cmd[1] = path;
      for (int i = 2; i < cmd.length; i++){
         cmd[i] = args[i-2];
      }
      for (String e: cmd) System.out.println(e);
      Runtime r = Runtime.getRuntime();

      Process p = r.exec(cmd);
      BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
      while((s=in.readLine()) != null){
         System.out.println(s);
      }
   }
   public boolean FindLength(String password){
      if (password.length() >= 10){
         return true;
      }
      else return false;
   }
   public boolean FindSpecialCharacter(String password){
      if (password.contains("$"+"%"+"#"+"@"+"!"+"."+"_"+"-"+","+"'"+"\""+"~"+"("+")"+"*"+"+"+"/"+":"+";"+"<"+"="+">"+"?"+"["+"]"+"^"+"`"+"{"+"}"+"|"+"\'")){
         return true;
      }
      else return false;
      }
   public boolean CapitalLetter(String password){
      if(password.toLowerCase().equals(password)) return false;
      return true;
   }

   public boolean Numbers(String password){
      for (int i = 0; i < password.length(); i++)
         if (password.substring(i,i).contains("1234567890")) return true;
      return false;
   }

}
