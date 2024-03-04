import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filecsv = "D:\\Java\\GenerateFileCsv\\data_sekolah.csv";
        String TxtHasilModus = "D:\\Java\\GenerateFileCsv\\Modus.txt";
        String TxtHasilMeandanMedian = "D:\\Java\\GenerateFileCsv\\Mean&Median.txt";
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data = ReadFile.Read(filecsv);

        Rumus rumus = new Rumus(data);



        Scanner scanner = new Scanner(System.in);

        int pilihan =0;
        do {
            GarisPutusPutus();
            System.out.println("\nAplikasi Pengolah Nilai Siswa");
            GarisPutusPutus();
            System.out.println("\nLetakkan file csv dengan nama file data_sekolah di direkori ");
            System.out.print("berikut : " + filecsv + "\n");
            System.out.println("pilih menu:");
            System.out.println("1. Generate txt untuk menampilkan modus");
            System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
            System.out.println("3. Generate kedua file");
            System.out.println("0. Exit");

            System.out.print("Masukkan Pilihan Anda : ");
            pilihan = scanner.nextInt();
            switch (pilihan){
                case 1:
                    //Membuat file Modus
                    rumus.hitungModus();
                    String HasilModus = GenerateModus(rumus, data);
                    WriteFile.write(TxtHasilModus, HasilModus);

                    break;
                case 2:
                    //membuat fil Median&Mean
                    rumus.hitungMedian();
                    rumus.hitungMean();
                    String HasilMediandanMean = GenereteMeandanMedian(rumus, data);
                    WriteFile.write(TxtHasilMeandanMedian, HasilMediandanMean);
                    break;
                case 3:
                    //membuat file Modus dan file Mean&Median
                    rumus.hitungMean();
                    rumus.hitungMedian();
                    rumus.hitungModus();
                    String HasilMediandanmean = GenereteMeandanMedian(rumus, data);
                    String Hasilmodus = GenerateModus(rumus, data);
                    WriteFile.write(TxtHasilMeandanMedian, HasilMediandanmean);
                    WriteFile.write(TxtHasilModus, Hasilmodus);
                    break;
                default:
                    System.out.println("Pilihan Anda Salah\nHarap memasukkan pilihan yang benar");
                    System.out.print("\nMasukkan Pilihan Anda : ");
                    pilihan = scanner.nextInt();
                    break;
            }
            if (pilihan != 0){
                GarisPutusPutus();
                System.out.println("\nAplikasi Pengolah Nilai Mahasiswa");
                GarisPutusPutus();
                System.out.println("\nFile telah di generate di C://temp/direktori\nsilahkan cek");
                System.out.println("\n1. Kembali ke menu utama");
                System.out.println("0. Exit");
                System.out.print("\nMasukkan Pilihan Anda : ");
                pilihan = scanner.nextInt();
            }
        }
        while (pilihan != 0);
        scanner.close();


    }

    public static String GenereteMeandanMedian(Rumus rumus, ArrayList<ArrayList<String>> Data){
        String Hasil = "Hasil\t\t Mean \t\t Median";
        ArrayList<Float> Mean = rumus.getMean();
        ArrayList<Float> Median = rumus.getMedian();

        for (int i = 0; i < Mean.size(); i++) {
            ArrayList<String> temp = Data.get(i);
            Hasil = Hasil + "\n" + temp.get(0) + "\t\t" + Mean.get(i) + "\t  " + Median.get(i);
        }
        return Hasil;
    }

    public static String GenerateModus(Rumus rumus, ArrayList<ArrayList<String>>Data){
        String Hasil = "Hasil Modus \t Modus \t";
        ArrayList<Integer> Modus = rumus.getModus();

        for (int i = 0; i < Modus.size(); i++) {
            ArrayList<String> temp = Data.get(i);
            Hasil = Hasil + "\n" + temp.get(0) + "\t\t      " + Modus.get(i);
        }
        return Hasil;
    }
    public static String GenerateMedian(Rumus rumus, ArrayList<ArrayList<String>> Data){
        String Hasil = "Hasil Median \t Median";
        ArrayList<Float> Median = rumus.getMedian();

        for (int i = 0; i < Data.size(); i++) {
            ArrayList<String> temp = Data.get(i);
            Hasil = Hasil + "\n" + temp.get(0) + "\t\t  " + Median.get(i);
        }
        return Hasil;
    }

    public static void GarisPutusPutus(){
        for (int i = 0; i < 58; i++) {
            System.out.print("-");
        }
    }
}