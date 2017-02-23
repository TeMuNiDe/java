// Test program for the IDEA encryption module.
// This program verifies the IDEA implementation by using published plaintext / ciphertext vectors.

import java.util.Arrays;
import biz.source_code.crypto.Idea;

public class TestIdeaVectors {

public static void main (String[] args) throws Exception {
   System.out.println("TestIdeaVectors started.");
   testOldEcbVectors();
   testNewEcbVectors();
   System.out.println("TestIdeaVectors completed."); }

// Test against the old vectors in Test_Cases_IDEA.txt (dated 1999-01-29).
private static void testOldEcbVectors() throws Exception {
   String key = "729A 27ED 8F5C 3E8B AF16 560D 14C9 0B43";
   testEcb(key, "D53F ABBF 94FF 8B5F", "1D0C B2AF 1654 820A");
   testEcb(key, "848F 8367 8093 8169", "D7E0 4682 26D0 FC56");
   testEcb(key, "8194 40CA 2065 D112", "264A 8BBA 6695 9075");
   testEcb(key, "6889 F564 7AB2 3D59", "F963 468B 52F4 5D4D");
   testEcb(key, "DF8C 6FC6 37E3 DAD1", "2935 8CC6 C838 28AE");
   testEcb(key, "AC48 5624 2B12 1589", "95CD 92F4 4BAC B72D");
   testEcb(key, "CBE4 65F2 32F9 D85C", "BCE2 4DC8 D096 1C44");
   testEcb(key, "6C2E 3617 DA2B AC35", "1569 E062 7007 B12E"); }

// Test against the new vectors in NewTestCases.txt (dated 1999-05-21).
private static void testNewEcbVectors() throws Exception {
   String key = "0000 27ED 8F5C 3E8B AF16 560D 14C9 0B43";
   testEcb(key, "D53F ABBF 94FF 8B5F", "1320 F99B FE05 2804");
   testEcb(key, "848F 8367 8093 8169", "4821 B99F 61AC EBB7");
   testEcb(key, "8194 40CA 2065 D112", "C886 0009 3B34 8575");
   testEcb(key, "6889 F564 7AB2 3D59", "61D5 3970 46F9 9637");
   testEcb(key, "DF8C 6FC6 37E3 DAD1", "EF48 99B4 8DE5 907C");
   testEcb(key, "AC48 5624 2B12 1589", "85C6 B232 294C 2F27");
   testEcb(key, "CBE4 65F2 32F9 D85C", "B67A C767 C0C0 6A55");
   testEcb(key, "6C2E 3617 DA2B AC35", "B222 9067 630F 7045"); }

private static void testEcb (String hexKey, String hexIn, String hexOut) throws Exception {
   testEcb(decodeHex(hexKey), decodeHex(hexIn), decodeHex(hexOut)); }

private static void testEcb (byte[] key, byte[] in, byte[] out) throws Exception {
   testEcb(key, in, out, true);
   testEcb(key, out, in, false); }

private static void testEcb (byte[] key, byte[] in, byte[] out, boolean direction) throws Exception {
   Idea idea = new Idea(key, direction);
   byte[] buf = in.clone();
   idea.crypt(buf);
   if (!Arrays.equals(buf, out)) {
      throw new Exception("Incorrect encryption/decryption result."); }}

private static byte[] decodeHex (String s) {
   byte[] buf = new byte[s.length() / 2];
   int p1 = 0;
   int p2 = 0;
   while (p1 < s.length()) {
      if (s.charAt(p1) == ' ') {
         p1++;
         continue; }
      buf[p2++] = (byte)Integer.parseInt(s.substring(p1, p1 + 2), 16);
      p1 += 2; }
   return Arrays.copyOf(buf, p2); }

}
