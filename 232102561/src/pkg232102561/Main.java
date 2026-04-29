package pkg232102561;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        int jumlah = Integer.parseInt(
                JOptionPane.showInputDialog("Masukkan jumlah mahasiswa:")
        );

        String[] nama = new String[jumlah];
        double[] akhir = new double[jumlah];
        String[] grade = new String[jumlah];

        for (int i = 0; i < jumlah; i++) {

            nama[i] = JOptionPane.showInputDialog("Nama mahasiswa ke-" + (i + 1));

            double kehadiran = Double.parseDouble(
                    JOptionPane.showInputDialog("Nilai Kehadiran (0-100):")
            );

            double tugas = Double.parseDouble(
                    JOptionPane.showInputDialog("Nilai Tugas (0-100):")
            );

            double mid = Double.parseDouble(
                    JOptionPane.showInputDialog("Nilai MID (0-100):")
            );

            double uas = Double.parseDouble(
                    JOptionPane.showInputDialog("Nilai UAS (0-100):")
            );

            // hitung nilai akhir
            akhir[i] = (0.1 * kehadiran) +
                       (0.2 * tugas) +
                       (0.3 * mid) +
                       (0.4 * uas);

            // tentukan grade
            if (akhir[i] >= 80) {
                grade[i] = "A";
            } else if (akhir[i] >= 70) {
                grade[i] = "B";
            } else if (akhir[i] >= 60) {
                grade[i] = "C";
            } else if (akhir[i] >= 50) {
                grade[i] = "D";
            } else {
                grade[i] = "E";
            }
        }

        // output hasil
        String hasil = "===== HASIL NILAI MAHASISWA =====\n\n";

        for (int i = 0; i < jumlah; i++) {
            hasil += "Nama        : " + nama[i] + "\n";
            hasil += "Nilai Akhir : " + String.format("%.2f", akhir[i]) + "\n";
            hasil += "Grade       : " + grade[i] + "\n";
            hasil += "--------------------------\n";
        }

        JOptionPane.showMessageDialog(null, hasil);
    }
}