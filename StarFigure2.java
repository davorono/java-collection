public class StarFigure2 {
   public static final int SIZE = 10;

   public static void main (String[] args) {
   
   int width = (8 * (SIZE - 1));
   
   // initiate variables of symbols
   int bSlash = width/2;
   int asterisk = 0;
   int fSlash = width/2;
   
      for (int h = 0; h < SIZE; h++) {
         
          // print forward slash
         for (int z = 0; z < fSlash; z++) {
            System.out.print("/");
         }
         
         // print asterisk
         for (int y = 0; y < asterisk; y++) {
            System.out.print("*");
         }
         
         // print backward slash
         for (int x = 0; x < bSlash; x++) {
            System.out.print("\\");
         } 
      
         bSlash = bSlash - 4;
         asterisk = asterisk + 8;
         fSlash = fSlash - 4;
         System.out.println();
      }
   }
}