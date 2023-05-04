
// Main.java
import java.util.Scanner;

public class GameMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Simple RPG Game!");

        // Membuat objek player dan enemy
        Player player = new Player("John", 100, 20);
        Enemy enemy = new Enemy("Skeleton", 50, 10);

        // Memulai game
        boolean isRunning = true;
        while (isRunning) {
            // Menampilkan status player dan enemy
            System.out.println("\n--- Status ---");
            player.showStatus();
            enemy.showStatus();

            // Menampilkan menu aksi
            System.out.println("\n--- Actions ---");
            System.out.println("1. Attack");
            System.out.println("2. Use Item");
            System.out.println("3. Quit");

            // Menerima input dari user
            System.out.print("\nChoose an action: ");
            int action = input.nextInt();

            // Menjalankan aksi yang dipilih
            switch (action) {
                case 1:
                    // Player menyerang enemy
                    player.attack(enemy);
                    // Enemy menyerang player
                    enemy.attack(player);
                    break;
                case 2:
                    // TODO: Implementasi use item
                    break;
                case 3:
                    // Keluar dari game
                    System.out.println("\nThanks for playing!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nInvalid action!");
            }

            // Memeriksa apakah game telah selesai
            if (player.isDead() || enemy.isDead()) {
                isRunning = false;
                System.out.println("\n--- Game Over ---");
                if (player.isDead()) {
                    System.out.println("You have been defeated!");
                } else {
                    System.out.println("You have won the battle!");
                }
            }
        }
    }
}
