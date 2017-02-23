// Test program for some of the math functions used in the IDEA modules.

import java.util.Arrays;

public class TestIdeaMath {

public static void main (String[] args) throws Exception {
   testMulInv();
   testMul();
   testPackUnpackDataLength();
   System.out.println("OK"); }

// Test for different versions of the modulo 0x10001 inversion functions.
private static void testMulInv() throws Exception {
   System.out.println("testMulInv");
   for (int i = 0; i < 0x10000; i++) {
      int inv1 = mulInvV1(i);
      int inv2 = mulInvV2(i);
      int inv3 = mulInvV3(i);
      if (inv1 != inv2 || inv1 != inv3) {
         throw new Exception("Different mulInv(" + i + "): " + inv1 + " " + inv2 + " " + inv3); }
      if (mulV4(i, inv1) != 1) {
         throw new Exception("Wrong nullInv/mul result."); }}}

// Test for different versions of the modulo 0x10001 multiplication functions.
private static void testMul() throws Exception {
   System.out.print("testMul ");
   for (int a = 0; a < 0x10000; a++) {
      for (int b = 0; b < 0x10000; b++) {
         int r1 = mulV1(a, b);
         int r2 = mulV2(a, b);
         int r3 = mulV3(a, b);
         int r4 = mulV4(a, b);
         if (r1 != r2 || r1 != r3 || r1 != r4) {
            throw new Exception("Different mul(" + a + ", " + b + "): " + r1 + " " + r2 + " " + r3 + " " + r4 + "."); }}
      if (a > 0 && a % 0x1000 == 0) {
         System.out.print("."); }}
   System.out.println(); }

// Test for packing and unpacking the file data length.
private static void testPackUnpackDataLength() throws Exception {
   System.out.print("testPackUnpackDataLength ");
   byte[] buf = new byte[8];
   for (long i = 0; i < 0x110000000L; i++) {
      Arrays.fill(buf, (byte)0);
      packDataLength(i, buf);
      long j = unpackDataLength(buf);
      if (i != j) {
         throw new Exception("Data length pack/unpack error: " + i + " / " + j); }
      if (i > 0 && i % 0x10000000 == 0) {
         System.out.print("."); }}
   System.out.println(); }

//--- mulInv versions ----------------------------------------------------------

// ETH version "November 16, 1993" (IDEA 1.1)
private static int mulInvV1 (int x) {
   if (x <= 1) {
      return x; }
   int n1 = x;
   int N = x;
   int n2 = 0x10001;
   int a1 = 1;
   int b2 = 1;
   int a2 = 0;
   int b1 = 0;
   while (n1 != 0) {
      while ((n1 & 1) == 0) {
         if ((a1 & 1) != 0) {
            if (a1 < 0) {
               a1 += 0x10001;
               b1 -= N; }
             else {
               a1 -= 0x10001;
               b1 += N; }}
         n1 >>= 1;
         a1 >>= 1;
         b1 >>= 1; }
      if (n1 < n2) {
        while (n1 <= n2) {
           n2 -= n1;
           a2 -= a1;
           b2 -= b1;
           if (n2 == 0) {
              return a1 < 0 ? a1 + 0x10001 : a1; }
           while ((n2 & 1) == 0) {
              if ((a2 & 1) != 0) {
                 if (a2 < 0) {
                    a2 += 0x10001;
                    b2 -= N; }
                  else {
                    a2 -= 0x10001;
                    b2 += N; }}
              n2 >>= 1;
              a2 >>= 1;
              b2 >>= 1; }}}
      n1 -= n2;
      a1 -= a2;
      b1 -= b2; }
  return a2 < 0 ? a2 + 0x10001 : a2; }

// ETH version "23 April 1992"
// IDEAplus version 2.1
private static int mulInvV2 (int x) {
   if (x <= 1) {
      return x; }
   int n1 = 0x10001;
   int n2 = x;
   int b1 = 0;
   int b2 = 1;
   while (true) {
      int r = n1 % n2;
      int q = n1 / n2;
      if (r == 0) {
         if (b2 < 0) {
            b2 += 0x10001; }
         return b2; }
      n1 = n2;
      n2 = r;
      int t = b2;
      b2 = b1 - q * b2;
      b1 = t; }}

// New version
private static int mulInvV3 (int x) {
   if (x <= 1) {
      return x; }
   int y = 0x10001;
   int t0 = 1;
   int t1 = 0;
   while (true) {
      t1 += y / x * t0;
      y %= x;
      if (y == 1) {
         return 0x10001 - t1; }
      t0 += x / y * t1;
      x %= y;
      if (x == 1) {
         return t0; }}}

//--- mul versions -------------------------------------------------------------

// ETH version "November 16, 1993" (IDEA 1.1)
private static int mulV1 (int a, int b ) {
   if (a == 0) {
      return (0x10001 - b) & 0xFFFF; }
   if (b == 0) {
      return (0x10001 - a) & 0xFFFF; }
   long r = (long)a * b;
   int lo = (int)(r & 0xFFFF);
   int hi = (int)(r >>> 16);
   if (lo >= hi) {
      return (int)((r - hi) & 0xFFFF); }
    else {
      return (int)((r + 0x10001 - hi) & 0xFFFF); }}

// ETH version "23 April 1992"
private static int mulV2 (int a, int b ) {
   if (a == 0) {
      return (0x10001 - b) & 0xFFFF; }
   if (b == 0) {
      return (0x10001 - a) & 0xFFFF; }
   long q = (long)a * b;
   int lo = (int)(q & 0xFFFF);
   int hi = (int)(q >>> 16);
   int p = lo - hi;
   if (p <= 0) {
      p += 0x10001; }
   return p & 0xFFFF; }

private static int mulV3 (int a, int b ) {
   long ab = (long)a * b;
   if (ab != 0) {
      int lo = (int)(ab & 0xFFFF);
      int hi = (int)(ab >>> 16);
      return (lo - hi + (lo < hi ? 1 : 0 )) & 0xFFFF; }
   if (a != 0) {
      return (1 - a) & 0xFFFF; }
    else {
      return (1 - b) & 0xFFFF; }}

// New version
private static int mulV4 (int a, int b ) {
   long r = (long)a * b;
   if (r != 0) {
      return (int)(r % 0x10001) & 0xFFFF; }
    else {
      return (1 - a - b) & 0xFFFF; }}

//--- pack/unpack file length --------------------------------------------------

private static void packDataLength (long i, byte[] b) {
   b[7] = (byte)(i <<  3);
   b[6] = (byte)(i >>  5);
   b[5] = (byte)(i >> 13);
   b[4] = (byte)(i >> 21);
   b[3] = (byte)(i >> 29);
   b[2] = (byte)(i >> 37); }

private static long unpackDataLength (byte[] b) {
   if (b[0] != 0 || b[1] != 0 || (b[7] & 7) != 0) {
      return -1; }
   return
      (long)(b[7] & 0xFF) >>  3 |
      (long)(b[6] & 0xFF) <<  5 |
      (long)(b[5] & 0xFF) << 13 |
      (long)(b[4] & 0xFF) << 21 |
      (long)(b[3] & 0xFF) << 29 |
      (long)(b[2] & 0xFF) << 37; }

}
