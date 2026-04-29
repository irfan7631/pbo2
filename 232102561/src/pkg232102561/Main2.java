/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg232102561;
import java.util.Scanner;
/**
 *
 * @author Mahasiswa
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        System.out.print("Jumlah data: ");
        n = input.nextInt();

        int data[] = new int[n];

        // input
        for(int i = 0; i < n; i++){
            System.out.print("Masukkan data: ");
            data[i] = input.nextInt();
        }

        // tampil
        System.out.println("Data:");
        for(int i = 0; i < n; i++){
            System.out.print(data[i] + " ");
        }

        int max = data[0];
        int min = data[0];
        int total = 0;

        for(int i = 0; i < n; i++){
            if(data[i] > max) max = data[i];
            if(data[i] < min) min = data[i];
            total += data[i];
        }

        double rata = (double) total / n;

        System.out.println("\nMax: " + max);
        System.out.println("Min: " + min);
        System.out.println("Total: " + total);
        System.out.println("Rata-rata: " + rata);
    }
    
}
