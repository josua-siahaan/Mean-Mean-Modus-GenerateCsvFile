import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Rumus {
    private ArrayList<Float> mean, median;
    private ArrayList<Integer> modus;

    private ArrayList<ArrayList<String>> datasekolah;

    public Rumus(ArrayList<ArrayList<String>> datasekolah) {
        this.datasekolah = datasekolah;
    }

    public ArrayList<Float> getMean() {
        return mean;
    }

    private void setMean(ArrayList<Float> mean) {
        this.mean = mean;
    }

    public ArrayList<Integer> getModus() {
        return modus;
    }

    public void setModus(ArrayList<Integer> modus) {
        this.modus = modus;
    }

    public ArrayList<Float> getMedian() {
        return median;
    }

    public void setMedian(ArrayList<Float> median) {
        this.median = median;
    }

    public ArrayList<ArrayList<String>> getDatasekolah() {
        return datasekolah;
    }

    public void setDatasekolah(ArrayList<ArrayList<String>> datasekolah) {
        this.datasekolah = datasekolah;
    }

    public ArrayList<Float> hitungMean(){
        ArrayList<Float> Mean = new ArrayList<>();
        float tempjumlah = 0;
        float temprata2 = 0;

        for (int i = 0; i < datasekolah.size(); i++) {
            ArrayList<String> dataperkelas = datasekolah.get(i);

            for (int j = 1; j < dataperkelas.size(); j++) {
                tempjumlah = tempjumlah + Float.parseFloat(dataperkelas.get(j));
            }

            temprata2 = tempjumlah / (datasekolah.get(i).size()-1);
            Mean.add(temprata2);

            tempjumlah = 0;
            temprata2 = 0;
        }
        setMean(Mean);
        return Mean;
    }

    public ArrayList<Integer> hitungModus(){
        ArrayList<Integer> Modus = new ArrayList<>();

        for (int i = 0; i < datasekolah.size(); i++) {
            ArrayList<String> dataperkelas = datasekolah.get(i);
            HashMap<Integer, Integer> FrekuensiNilai = new HashMap<>();

            for (int j = 1; j < dataperkelas.size(); j++) {
                int num = Integer.parseInt(dataperkelas.get(j));
                if (FrekuensiNilai.containsKey(num)){
                    FrekuensiNilai.put(num, FrekuensiNilai.get(num) + 1);
                }
                else {
                    FrekuensiNilai.put(num, 1);
                }
            }

            int FrekuensiTerbanyak = 0;
            for (int j = 1; j < dataperkelas.size(); j++) {
                int num = Integer.parseInt(dataperkelas.get(j));
                int frekuensi = FrekuensiNilai.get(num);
                if (frekuensi > FrekuensiTerbanyak){
                    FrekuensiTerbanyak = frekuensi;
                }
            }

            int NilaiModus;
            for (int j = 1; j < dataperkelas.size(); j++) {
                int num = Integer.parseInt(dataperkelas.get(j));
                int frekuensi = FrekuensiNilai.get(num);
                if (frekuensi == FrekuensiTerbanyak){
                    NilaiModus = num;
                    Modus.add(NilaiModus);
                }
                FrekuensiNilai.put(num, 0);
            }
            FrekuensiTerbanyak = 0;
            NilaiModus = 0;
        }
        setModus(Modus);

        return Modus;
    }

    public ArrayList<Float> hitungMedian(){
        ArrayList<Float> Median = new ArrayList<>();
        for (int i = 0; i < datasekolah.size(); i++) {
            ArrayList<String> dataperkelas = datasekolah.get(i);
            List<Integer> datas = new ArrayList<>();

            float median =0;
            for (int j = 1; j < dataperkelas.size(); j++) {
                datas.add(Integer.valueOf(dataperkelas.get(j)));
            }
            Collections.sort(datas);
            if (datas.size() % 2 == 0){
                median = Float.valueOf(datas.get(Integer.valueOf(datas.size())/2) + datas.get(Integer.valueOf(datas.size())/2) + 1)/2;
            }
            else{
                median = datas.get(Integer.valueOf(datas.size())/2);
            }
            Median.add(median);
            median = 0;
            datas = null;
        }
        setMedian(Median);
//        System.out.println(Median);
        return Median;
    }
}
