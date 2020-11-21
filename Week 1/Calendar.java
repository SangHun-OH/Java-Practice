public class Calendar {
 
    public static void main(String[] args) {
        
        System.out.println("\t\t   "+2020 +"년 "+ 9 +"월 달력\n"
                + "일\t월\t화\t수\t목\t금\t토");
       
        int Start = 3;
        int End = 30;
        
        for(int i = 1 ; i < Start; i++) {
            System.out.print("\t");
        }
        
        int Next_Week = Start - 1;
        for(int j = 1 ; j <= End ; j++) {
            System.out.print(j+"\t");
            Next_Week ++;
            if(Next_Week == 7) {
                Next_Week = 0;
                System.out.println("\n");
            }
        }   
    }
}