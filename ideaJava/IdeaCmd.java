// A simple command-line interface for the IDEA file encryption module.

import java.util.Arrays;
import biz.source_code.crypto.IdeaFileEncryption;

public class IdeaCmd {

public static void main (String[] args) throws Exception {
   // The syntax of the command line parameters is kept compatible with that of IDEA V1.1 (IDEA_CMD.C, ETH version).
   // It's a subset of the original command line syntax and has a very simple, fixed structure.
   if (args.length == 0) {
      System.out.println("IDEA file encryption utility.");
      System.out.println("Syntax: [-e | -d] -k keyString inputFile outputFile");
      System.out.println("Home page: http://www.source-code.biz/idea/java");
      return; }
   if (args.length != 5) {
      throw new Exception("Invalid number of command line arguments."); }
   boolean encrypt;
   if ("-e".equals(args[0])) {
      encrypt = true; }
    else if ("-d".equals(args[0])) {
      encrypt = false; }
    else {
      throw new Exception("First command line argument must be -e or -d."); }
   if (!"-k".equals(args[1])) {
      throw new Exception("Second command line argument must be -k."); }
   String charKey = args[2];
   String inputFileName = args[3];
   String outputFileName = args[4];
   IdeaFileEncryption.cryptFile(inputFileName, outputFileName, charKey, encrypt, IdeaFileEncryption.Mode.CBC); }

}
