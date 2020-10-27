/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m10119002.pbo.latihan17;

import java.util.Scanner;

/**
 *
 * @author
 * NAMA     : Firman Sahita
 * KELAS    : IF-1
 * NIM      : 10119002
 * Deskripsi Program : Program ini berisi program tunjangan
 * 
 * 
 */
public class Tunjangan {
    private final Scanner scanner;
    public Tunjangan() {scanner = new Scanner(System.in);}
    
    private String getInput() {return scanner.nextLine();}
    
    private Integer getInteger(String test) {
        Integer temp;
        try {
            temp = Integer.parseInt(test);
        } catch (NumberFormatException ex) {
            System.err.println("Gagal proses, pastikan tidak ada titik, koma"
                    + ", apalagi huruf atau simbol!");
            return null;
        } catch (Exception ex) {
            System.err.println("Gagal proses!");
            return null;
        }
        return temp;
    }
    
    private Boolean getStatusMenikah(String test) {
        test = test.toLowerCase();
        switch (test) {
            case "menikah":
                return true;
            case "belum":
                return false;
            default:
                System.err.println("Gagal proses, masukkan tidak dikenal!");
                return null;
        }
    }
    
    private void tampilHasil(int gaji_pokok, boolean menikah) {
        Double d_gaji_pokok = (double)gaji_pokok;
        Double tunjangan = (menikah)? gaji_pokok*0.35 : 0;
        Double total = gaji_pokok + tunjangan;
        
        System.out.println("========Hasil Perhitungan Gaji Anda=========");
        System.out.println("Gaji Pokok              : Rp ".concat(d_gaji_pokok.toString()));
        System.out.println("Tunjangan               : Rp ".concat(tunjangan.toString()));
        System.out.println("Total Gaji              : Rp ".concat(total.toString()));
    }
    
    private int start() {
        String input;
        int gaji_pokok;
        boolean status_menikah;
        
        System.out.println("===========Program Tunjangan===========");
        System.out.print("Berapa gaji pokok anda perbulan?: Rp. ");
        input = getInput();
        if(getInteger(input)!=null) gaji_pokok = getInteger(input);
        else return -1;
        
        System.out.print("Status Anda? (Menikah/Belum)    : ");
        input = getInput();
        if(getStatusMenikah(input)!=null) status_menikah = getStatusMenikah(input);
        else return -1;
        
        System.out.println("");
        tampilHasil(gaji_pokok, status_menikah);
        System.out.println("(Developed by : Firman Sahita)");
        return 0;
    }
    
    public static void main(String[] args) {
        Tunjangan program = new Tunjangan();
        program.start();
    }
}
