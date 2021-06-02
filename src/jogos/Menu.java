package jogos;
import java.util.Scanner;
public class Menu {
	public static void main(String[] args) throws InterruptedException {
		menu(args);
	}

	public static void menu(String[] args) throws InterruptedException {
		Scanner ent = new Scanner(System.in);
		print("Seja bem vindo! Digite o número equivalente para selecionar um dos jogos para jogar!"
				+ "\n1) Jogo da Forca"
				+ "\n2) Jogo da Velha"
				+ "\n3) Batalha Naval"
				+ "\n4) Sair");
		int jogo = ent.nextInt();
		while (jogo!=1 && jogo!=2 && jogo!=3 && jogo!=4){
			print("Número inserido de forma incorreta, insira um número de 1 a 4 para seleção do jogo.");
			jogo = ent.nextInt();
		}
		switch (jogo) {
		case 1:
			print("Jogo escolhido: Jogo da Forca.");
			print("");
			JogoDaForcaFunc.main(args);
			break;
		case 2:
			print("Jogo escolhido: Jogo da Velha.");
			print("");
			JogoDaVelha.main(args);
			break;
		case 3:
			print("Jogo escolhido: Batalha Naval.");
			print("");
			BatalhaNaval.main(args);
			break;
		case 4:
			print("Obrigado por jogar!");
			System.exit(0);
			break;
		} 
	}

	public static void print(String txt) {
		System.out.println(txt);
	}
}

