package Func;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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
   public  ArrayList<String> runPyScript(String path, String[] args) throws IOException {
      String s;
      String [] cmd = new String[args.length+2];
      cmd[0] = "python";
      cmd[1] = path;
      for (int i = 2; i < cmd.length; i++){
         cmd[i] = args[i-2];
      }
      Runtime r = Runtime.getRuntime();

      Process p = r.exec(cmd);
      BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
      ArrayList<String> returnArray = new ArrayList<String>();
      while((s=in.readLine()) != null){
         System.out.println(s);
         if (s.equals("None")) continue;
         returnArray.add(s);
      }
      return returnArray;
   }
   public boolean hasLength(JFXTextField password) {
      if (password.getText().length()>=10) return true;
      return false;
   }
   public boolean hasSpecialCharacter(JFXTextField password){
      String special_characters="._-,!#$%&'()*+/:;<=>?@[\\]^`{ |}\"~'";
      char[] passwordChar = password.getText().toCharArray();
      for (char c : passwordChar){ if (special_characters.contains(c+"")) return true; }
      return false;
   }
   public boolean hasCapitalLetter(JFXTextField password){
      if(password.getText().toLowerCase().equals(password.getText())) return false;
      return true;
   }

   public boolean hasNumbers(JFXTextField password) {
      char[] passwordChar = password.getText().toCharArray();
      for (char c : passwordChar) { if (Character.isDigit(c)) return true; }
      return false;
   }

   public boolean hasLengthP(JFXPasswordField password) {
      if (password.getText().length()>=10) return true;
      return false;
   }
   public boolean hasSpecialCharacterP(JFXPasswordField password){
      String special_characters="._-,!#$%&'()*+/:;<=>?@[\\]^`{ |}\"~'";
      char[] passwordChar = password.getText().toCharArray();
      for (char c : passwordChar){ if (special_characters.contains(c+"")) return true; }
      return false;
   }
   public boolean hasCapitalLetterP(JFXPasswordField password){
      if(password.getText().toLowerCase().equals(password.getText())) return false;
      return true;
   }

   public boolean hasNumbersP(JFXPasswordField password) {
      char[] passwordChar = password.getText().toCharArray();
      for (char c : passwordChar) { if (Character.isDigit(c)) return true; }
      return false;
   }

}
