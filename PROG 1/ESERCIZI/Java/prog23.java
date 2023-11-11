public class prog23 {
    public static void main(String[] args) {
        int n1 = -7, n2 = -3, s = 0;
        //Numero 1
        if (n1 < 0) {
            n1 = -(n1);
            if (n1 < n2) {
                for (int i = 1; i <= n1; i++) {
                    s = s + n2;
                }
                s = -(s);
            }
        }
        else{
            if (n1 < n2) {
                for (int i = 1; i <= n1; i++) {
                    s = s + n2;
                }
            }

        }
        //Numero 2
        if (n2 < 0) {
            n2 = -(n2);
            if (n1>n2){
                for (int i = 1; i <= n2; i++) {
                    s = s + n1;
                }
                s = -(s);
            }
        }
        else{
            if (n1>n2){
                for (int i = 1; i <= n2; i++) {
                    s = s + n1;
                }
            }
           
        }
        System.out.print(n1 + "x" + n2 + "=" + s);
    }
}
