# GameJava
# Empat Pilar Pemrograman Berorientasi Objek

## 1. Abstraction
- Memperlihatkan fungsi utama dari Class yang dibutuhkan oleh publik dan menyembunyikan detail pelaksanaannya
- Fungsi utama dari Abstraction adalah memudahkan publik dalam menggunakan Class tersebut
- Mesin penyeduh kopi otomatis langsung menyeduhkan kopi untuk kita, kita tidak perlu lagi mengambil sachet kopi, memasukan isinnya ke air, dsb. cukup tekan tombol seduh kopi
- Penggunaan konsep **Abstraction** pada pemrograman **Java** dapat dilakukan melalui dua metode yaitu:
    - **Abstract Class**
    - **Interface**

## Abstract Class di Java
- Dideklarasikan dengan keyword abstract
- Boleh memiliki method abstract dan non abstract
- Tidak bisa langsung diinstansiasi
- Dapat memiliki constructor
- Dapat memiliki method final, yang tidak bisa lagi diubah oleh subclass

```java
// Character.java
public abstract class Character {
    protected String name;
    protected int health;
    protected int attack;

    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public abstract void attack(Character target);

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.printf("%s takes %d damage! (%d/%d HP)\n", this.name, damage, this.health, this.getMaxHealth());
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return 100;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public void showStatus() {
        System.out.printf("%s: %d/%d HP\n", this.name, this.health, this.getMaxHealth());
    }
}

```

## 2. Encapsulation
- Membungkus kode dan data yang saling terkait dalam satu unit Class
- Memberikan publik batasan akses pada Method dan Attribute dari Class
- Menggunakan konsep Set (menulis data) and Get (membaca data) dimana
    - Getter digunakan untuk membaca data
    - Setter digunakan untuk menulis data
- Filter atau logika dapat ditambahkan untuk setiap kebutuhan Set dan Get dari publik

```java
class Warga {
    private String nama;
    private int umur;
    
    public String getNama() { return this.nama; }
 
    public void setNama(String nama) { this.nama = nama; }
 
    // Umur yang ditampilkan dapat diproses terlebih dahulu jika ada aturan tambahan,
    // Misalnya tampilkan umur 9999 jika umurnya dibawah 17 tahun
    public int getUmur() {
        if(this.umur < 17) {
            return 9999;
        } else {
            return this.umur;
        }
    }
 
    public void setUmur(int umur) { this.umur = umur; }
}

public class Demo {
    public static void main(String args[]) {
        Warga warga1 = new Warga();
        warga1.setNama("Abdul");
        warga1.setUmur(21);
        
        Warga warga2 = new Warga();
        warga2.setNama("Vina");
        warga2.setUmur(12);
        
        System.out.println("Nama warga 1 tersebut, " + warga1.getNama());
        System.out.println("Umurnya, " + warga1.getUmur());
        
        System.out.println("Nama warga 2 tersebut, " + warga2.getNama());
        System.out.println("Umurnya, " + warga2.getUmur());
    }
}
```

## 3. Inheritance
- Konsep Inheritance terkait dengan penurunan sikap dan perilaku dari Orang Tua (Parent / Superclass) ke Anaknya (Child / Subclass)
- Inheritance mememungkinkan Subclass mewarisi seluruh attribute dan method dari Superclass nya sehingga tidak perlu lagi mendefinisikan ulang, atau cukup mendefinisikan attribute dan method yang berbeda dari Superclassnya
- Umumnya keyword **extends** digunakan dalam pendefinisian Subclass dari Superclass pada berbagai bahasa pemrograman berorientasi objek

```java
class Warga {
    protected String nama;
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void pilihKades () {
        System.out.println(this.nama + " memilih kades melalui kotak suara");
    }
}

class Hansip extends Warga {
    public void jagaKeamanan () {
        System.out.println(this.nama + " sedang menjaga keamanan wilayah");
    }
}

public class Demo {
    public static void main(String args[]) {
        Warga warga1 = new Warga();
        warga1.setNama("Wati");
        warga1.pilihKades();
        
        Hansip warga2 = new Hansip();
        warga2.setNama("Yahya");
        warga2.pilihKades();
        warga2.jagaKeamanan();
    }
}
```

## 4. Polymorphism
- Subclass dapat memiliki implementasi method yang berbeda dari Superclass nya
- Contoh sesama makhluk hidup bisa makan, tapi cara makan antara Pinguin dan Cicak Rumahan berbeda
```java
class MakhlukHidup {
    public void makan() {
        System.out.println("Makhluk hidup makan");
    }
}

class CicakRumahan extends MakhlukHidup {
    public void makan() {
        System.out.println("Cicak rumahan makan, ckrip ckrip");
    }
}

class Pinguin extends MakhlukHidup {
    public void makan() {
        System.out.println("Pinguin makan, skuiw skuiw");
    }
}

class Lutung extends MakhlukHidup {
    public void makan() {
        System.out.println("Lutung makan, kakoak kakoak");
    }
}

public class Demo {
    public static void main(String args[]) {
        MakhlukHidup cicak = new CicakRumahan();
        MakhlukHidup pinguin = new Pinguin();
        MakhlukHidup lutung = new Lutung();
        
        cicak.makan();
        pinguin.makan();
        lutung.makan();
    }
}
```

## Challenge
- Buat contoh penggunaan sederhana dari keempat pilar pemrograman berorientasi objek tersebut
- Impelemtasikan penggunaan keempat pilar pemrograman berorientasi objek tersebut pada perancangan produk digital yang dipilih

## Referensi
- [OOP Concepts in Java - Stackify](https://stackify.com/oops-concepts-in-java/)
- [The Four Pillars of Object-Oriented Programming - FreeCodeCamp](https://www.freecodecamp.org/news/four-pillars-of-object-oriented-programming/)
- [Four Pillars of Object-Oriented Programming(Oops) - Codingninjas](https://www.codingninjas.com/codestudio/library/four-pillars-of-oops)
- [Four Main Object Oriented Programming Concepts of Java - GeeksForGeeks](https://www.geeksforgeeks.org/four-main-object-oriented-programming-concepts-of-java/)
- [The Four Pillars of Object Oriented Programming - Key Lime Interactive](https://info.keylimeinteractive.com/the-four-pillars-of-object-oriented-programming)
- [Abstraction - Tutorialspoint](https://www.tutorialspoint.com/java/java_abstraction.htm)
- [Abstraction](https://stackify.com/oop-concept-abstraction/)
- [Encapsulation](https://stackify.com/oop-concept-for-beginners-what-is-encapsulation/)
