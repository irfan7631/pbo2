import javax.swing.*;
import java.awt.event.*;

public class Main3 extends JFrame {

    JTextField txtNim, txtNama, txtIpk;
    JLabel lblAngkatanHasil, lblJurusanHasil, lblGradeHasil;

    public Main3() {
        setTitle("Data Mahasiswa");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Judul
        JLabel lblTitle = new JLabel("Data Mahasiswa", JLabel.CENTER);
        lblTitle.setBounds(100, 10, 250, 30);
        add(lblTitle);

        // Input
        JLabel lblNim = new JLabel("NIM Mahasiswa");
        lblNim.setBounds(30, 60, 120, 25);
        add(lblNim);

        txtNim = new JTextField();
        txtNim.setBounds(170, 60, 200, 25);
        add(txtNim);

        JLabel lblNama = new JLabel("Nama Mahasiswa");
        lblNama.setBounds(30, 100, 120, 25);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(170, 100, 200, 25);
        add(txtNama);

        JLabel lblIpk = new JLabel("IPK");
        lblIpk.setBounds(30, 140, 120, 25);
        add(lblIpk);

        txtIpk = new JTextField();
        txtIpk.setBounds(170, 140, 200, 25);
        add(txtIpk);

        // Output
        JLabel lblAngkatan = new JLabel("Angkatan");
        lblAngkatan.setBounds(30, 180, 120, 25);
        add(lblAngkatan);

        lblAngkatanHasil = new JLabel("Tahun");
        lblAngkatanHasil.setBounds(170, 180, 200, 25);
        add(lblAngkatanHasil);

        JLabel lblJurusan = new JLabel("Jurusan");
        lblJurusan.setBounds(30, 210, 120, 25);
        add(lblJurusan);

        lblJurusanHasil = new JLabel("...");
        lblJurusanHasil.setBounds(170, 210, 200, 25);
        add(lblJurusanHasil);

        JLabel lblGrade = new JLabel("Grade");
        lblGrade.setBounds(30, 240, 120, 25);
        add(lblGrade);

        lblGradeHasil = new JLabel("A, B, C, D");
        lblGradeHasil.setBounds(170, 240, 200, 25);
        add(lblGradeHasil);

        // Tombol
        JButton btnHitung = new JButton("Kalkulasi");
        btnHitung.setBounds(30, 280, 100, 25);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(160, 280, 100, 25);
        add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(290, 280, 80, 25);
        add(btnExit);

        // EVENT: Kalkulasi (sesuai PPT → langsung pakai model)
        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mahasiswa m = new Mahasiswa();

                m.nim = txtNim.getText();
                m.nama = txtNama.getText();
                m.ipk = Float.parseFloat(txtIpk.getText());

                lblAngkatanHasil.setText(m.getAngkatan());
                lblJurusanHasil.setText(m.getJurusan());
                lblGradeHasil.setText(m.getGrade());
            }
        });

        // RESET
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNim.setText("");
                txtNama.setText("");
                txtIpk.setText("");
                lblAngkatanHasil.setText("Tahun");
                lblJurusanHasil.setText("...");
                lblGradeHasil.setText("A, B, C, D");
            }
        });

        // EXIT
        btnExit.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new Main3().setVisible(true);
    }
}

// ================= MODEL SESUAI PPT =================
class Mahasiswa {
    String nim;
    String nama;
    float ipk;

    // getAngkatan (ambil 2 digit awal)
    String getAngkatan() {
        return "20" + nim.substring(0, 2);
    }

    // getJurusan (PERSIS PPT - pakai switch)
    String getJurusan() {
        String jurusan;
        String namaJurusan;

        jurusan = nim.substring(2, 4);

        switch (jurusan) {
            case "10":
                namaJurusan = "Manajemen Informatika";
                break;
            case "11":
                namaJurusan = "Sistem Informasi";
                break;
            case "21":
                namaJurusan = "Teknik Informatika";
                break;
            default:
                namaJurusan = "Salah Jurusan";
        }

        return namaJurusan;
    }

    // getGrade
    String getGrade() {
        if (ipk >= 3.5) return "A";
        else if (ipk >= 3.0) return "B";
        else if (ipk >= 2.5) return "C";
        else return "D";
    }
}