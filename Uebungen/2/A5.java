class A5 {
    public static void main(String[] args) {
        if (args.length != 10) {
            System.out.println("Aufruf mit 10 ganzen Zahlen");
        } else {
            int i, wert = 1;
            int[] folge = new int[10];
            for (i = 0; i < args.length; i++)
                folge[i] = Integer.parseInt(args[i]);
            System.out.println("Wert vor erstem Funktionsaufruf: " + wert);
            pluseins(wert);
            System.out.println("Wert nach erstem Funktionsaufruf: " + wert);
            wert = maxsegsum(folge, args.length);
            System.out.println("Maximale Segmentsumme: " + wert);
        }
    }
    
    static void pluseins(int a) {
        a = a + 1;
    }
    static int maxsegsum(int b[], int n) {
        int s = 0, h = 0, c = 0;
        while (h != n) {
            if (c + b[h] > 0)
            c += b[h];
            else 
                c = 0;
            if (c > s)
                s = c;
            h++;
        }
        return s;
    }
}
