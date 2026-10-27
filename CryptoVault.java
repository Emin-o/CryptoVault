import java.util.Scanner;

public class CryptoVault {
    public static void main(String[] args) {

        try (Scanner klavye = new Scanner(System.in)) {

            // Giriş Kısmı 
            int kasaSifresi = 1234;
            int islemSayacı = 0;

            for (int girisHakı = 2; girisHakı > -1; girisHakı--) {
                System.out.println("Kasa sifresini giriniz: ");
                int sifre = klavye.nextInt();

                if (kasaSifresi == sifre) {
                    System.out.println("kasa açıldı\n");
                    break;
                } else if (girisHakı == 0) {
                    System.out.println("kasa kilitlendi");
                    System.exit(0);
                } else if (kasaSifresi != sifre) {
                    System.out.println("kasa açılmadı");
                    System.out.println("kalan giriş hakkı: " + girisHakı);
                }
            } // kasa giriş denetleme for bitti

            // İlk girişten kalan Enter karakterini temizlemek için
            klavye.nextLine();

            while (true) {
                // Ana Menü
                System.out.println("Ana Menüye Hoşgeldiniz\n");
                System.out.println("1 - Mesajı Şifrele");
                System.out.println("2 - Şifreli Mesajı Çöz");
                System.out.println("3 - Kasa Durumu");
                System.out.println("4 - Çıkış\n");

                System.out.print("Seçiminiz: \n");
                int secim = klavye.nextInt();
                klavye.nextLine(); 

                if (secim >= 1 && secim <= 4) {

                    switch (secim) {
                        case 1:
                            System.out.println("Mesaj şifreleniyor...");
                            String sifreliMesaj = "";

                            System.out.println("Şifrelenecek metni giriniz: ");
                            String mesaj = klavye.nextLine();

                            System.out.println("Anahtar sayınızı giriniz: ");
                            int anahtar = klavye.nextInt();
                            klavye.nextLine(); // Fazladan olan nextInt() kaldırıldı, yerine Enter temizlendi.

                            for (int i = 0; i < mesaj.length(); i++) {
                                char harf = mesaj.charAt(i);
                                char yeniharf = (char) (harf + anahtar);
                                sifreliMesaj += yeniharf;
                            }
                            
                            System.out.println("Şifreli mesajınız: " + sifreliMesaj);
                            System.out.println(" ");
                            islemSayacı++;
                            break;

                        case 2:
                            System.out.println("Şifreli mesaj çözülüyor...");
                            String sifreliMesajj = "";

                            System.out.println("Şifreli mesajınızı giriniz");
                            String cozumSifre = klavye.nextLine();

                            System.out.println("Anahtar sayınızı giriniz:");
                            int cozumanahtar = klavye.nextInt();
                            klavye.nextLine(); 

                            for (int i = 0; i < cozumSifre.length(); i++) {
                                char cozumHarf = cozumSifre.charAt(i);
                                char yeniharf = (char) (cozumHarf - cozumanahtar);
                                sifreliMesajj += yeniharf;
                            }
                            System.out.println("Çözülmüş Şifre: " + sifreliMesajj);
                            System.out.println(" ");
                            islemSayacı++;
                            break;

                        case 3:
                            System.out.println("Kasa durumu kontrol ediliyor...");
                            System.out.println("Yapılan işlem sayısı: " + islemSayacı);
                            break;

                        case 4:
                            System.out.println("Çıkış yapılıyor...");
                            System.exit(0);
                            break;
                    }

                } else {
                    System.out.println("Hatalı seçim yaptınız. Lütfen tekrar deneyiniz.");
                }
            } // while bitti
        } // klavye.close() için
    }
}
