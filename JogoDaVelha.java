package jogos;

import java.util.Arrays;
import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner (System.in);
		char[] inter = inter();
		boolean[] posFilled = posFilledArr();

		short rodada = 1;
		short pos;

		print("Bem-vindo ao Jogo da Velha!!!");
		print("Antes de dar início a partida, veja este exemplo de como escolher a posição \n"
				+ "da jogada. Basta escolher o número correspondente a posição.");
		print("");
		visualExemplo();
		print("");

		print("Quem deseja começar, X ou O?");
		char primeiro = comecar();

		pos = posJogada(primeiro, rodada);
		posFilled[pos - 1] = true;
		inter = jogada(inter,primeiro, pos, rodada);
		printInt(inter);
		print("");
		rodada++;

		while(!(inter[1] != ' ' && inter[1] == inter[5] && inter[5] == inter[9]) && !(inter[23] != ' ' && inter[23] == inter[27] && inter[27] == inter[31]) && !(inter[45] != ' ' && inter[45] == inter[49] && inter[49] == inter[53]) &&
				!(inter[1] != ' ' && inter[1] == inter[23] && inter[23] == inter[45]) && !(inter[5] != ' ' && inter[5] == inter[27] && inter[27] == inter[49]) && !(inter[9] != ' ' && inter[9] == inter[31] && inter[31] == inter[53]) &&
				!(inter[1] != ' ' && inter[1] == inter[27] && inter[27] == inter[53]) && !(inter[9] != ' ' && inter[9] == inter[27] && inter[27] == inter[45]) &&
				!(posFilled[0] == true && posFilled[1] == true && posFilled[2] == true && posFilled[3] == true && posFilled[4] == true && posFilled[5] == true && 
				posFilled[6] == true && posFilled[7] == true && posFilled[8] == true)) {
			pos = posJogada(primeiro, rodada);
			while(posFilled[pos - 1] == true) {
				print("Posição já ocupada, escolha outra: ");
				pos = checkPos();
			}
			posFilled[pos - 1] = true;
			inter = jogada(inter,primeiro, pos, rodada);
			printInt(inter);
			print("");
			rodada++;
		}

		if((inter[1] == 'X' && inter[1] == inter[5] && inter[5] == inter[9]) || (inter[23] == 'X' && inter[23] == inter[27] && inter[27] == inter[31]) || (inter[45] == 'X' && inter[45] == inter[49] && inter[49] == inter[53]) ||
				(inter[1] == 'X' && inter[1] == inter[23] && inter[23] == inter[45]) || (inter[5] == 'X' && inter[5] == inter[27] && inter[27] == inter[49]) || (inter[9] == 'X' && inter[9] == inter[31] && inter[31] == inter[53]) ||
				(inter[1] == 'X' && inter[1] == inter[27] && inter[27] == inter[53]) || (inter[9] == 'X' && inter[9] == inter[27] && inter[27] == inter[45])) {
			print("X venceu!!!");
		}else if((inter[1] == 'O' && inter[1] == inter[5] && inter[5] == inter[9]) || (inter[23] == 'O' && inter[23] == inter[27] && inter[27] == inter[31]) || (inter[45] == 'O' && inter[45] == inter[49] && inter[49] == inter[53]) ||
				(inter[1] == 'O' && inter[1] == inter[23] && inter[23] == inter[45]) || (inter[5] == 'O' && inter[5] == inter[27] && inter[27] == inter[49]) || (inter[9] == 'O' && inter[9] == inter[31] && inter[31] == inter[53]) ||
				(inter[1] == 'O' && inter[1] == inter[27] && inter[27] == inter[53]) || (inter[9] == 'O' && inter[9] == inter[27] && inter[27] == inter[45])) {
			print("O venceu!!!");
		}else {
			print("Ninguém venceu");
		}
		jogarNovamente(args);
	}
	
	public static char[] inter() {
		char[] inter = {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '-', '-', '-', '|'
				,'-', '-', '-', '|', '-', '-', '-',' ', ' ', ' ', '|', ' ', ' ', ' ', '|',' ', ' ', ' '
				, '-', '-', '-', '|', '-', '-', '-', '|', '-', '-', '-',
				' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '};
		return inter;
	}
	
	public static boolean[] posFilledArr() {
		boolean[] posFilled = new boolean[9];
		Arrays.fill(posFilled, false);
		return posFilled;
	}

	public static char comecar() {
		Scanner sc = new Scanner (System.in);
		String comeca = sc.nextLine();
		comeca = comeca.toUpperCase();
		print("");
		while(!(comeca.contentEquals("X") || comeca.contentEquals("O"))) {
			print("Responda apenas com X ou O, quem deseja começar?");
			comeca = sc.nextLine();
			comeca = comeca.toUpperCase();
			print("");
		}
		return comeca.charAt(0);
	}

	public static short posJogada(char primeiro, short rodada) {
		Scanner sc = new Scanner (System.in);
		short pos = 0;

		if(String.valueOf(primeiro).contentEquals("X")) {
			if(rodada == 1) {
				print("O primeiro a jogar é o " + primeiro);
				print("Escolha a posição da jogada: ");
				pos = sc.nextShort();
				print("");
			}else if (rodada % 2 != 0){
				print("Vez de X");
				print("Escolha a posição da jogada: ");
				pos = sc.nextShort();
				print("");
			}else {
				print("Vez de O");
				print("Escolha a posição da jogada: ");
				pos = sc.nextShort();
				print("");
			}
		}else {
			if(rodada == 1) {
				print("O primeiro a jogar é o " + primeiro);
				print("Escolha a posição da jogada: ");
				pos = sc.nextShort();
				print("");
			}else if (rodada % 2 != 0){
				print("Vez de O");
				print("Escolha a posição da jogada: ");
				pos = sc.nextShort();
				print("");
			}else {
				print("Vez de X");
				print("Escolha a posição da jogada: ");
				pos = sc.nextShort();
				print("");
			}
		}

		while(pos != 1 && pos != 2 && pos != 3 && pos != 4 && pos != 5 && pos != 6 && pos != 7 && pos != 8 && pos != 9) {
			print("A posição da jogada deve ser escolhida de 1 a 9, escolha novamente: ");
			pos = sc.nextShort();
		}
		return pos;
	}

	public static short checkPos() {
		Scanner sc = new Scanner (System.in);
		short pos = sc.nextShort();
		print("");
		while(pos != 1 && pos != 2 && pos != 3 && pos != 4 && pos != 5 && pos != 6 && pos != 7 && pos != 8 && pos != 9) {
			print("A posição da jogada deve ser escolhida de 1 a 9, escolha novamente: ");
			pos = sc.nextShort();
			print("");
		}
		return pos;
	}

	public static char[] jogada(char[] inter, char primeiro, short pos, short rodada) {

		if(String.valueOf(primeiro).contentEquals("X")) {
			if(rodada % 2 != 0) {
				switch (pos) {
				case 1:
					inter[1] = primeiro;
					return inter;

				case 2:
					inter[5] = primeiro;
					return inter;

				case 3:
					inter[9] = primeiro;
					return inter;

				case 4:
					inter[23] = primeiro;
					return inter;	

				case 5:
					inter[27] = primeiro;
					return inter;	

				case 6:
					inter[31] = primeiro;
					return inter;	

				case 7:
					inter[45] = primeiro;
					return inter;	

				case 8:
					inter[49] = primeiro;
					return inter;	

				case 9:
					inter[53] = primeiro;
					return inter;	
				}
			}else {
				switch (pos) {
				case 1:
					inter[1] = 'O';
					return inter;

				case 2:
					inter[5] = 'O';
					return inter;

				case 3:
					inter[9] = 'O';
					return inter;

				case 4:
					inter[23] = 'O';
					return inter;	

				case 5:
					inter[27] = 'O';
					return inter;	

				case 6:
					inter[31] = 'O';
					return inter;	

				case 7:
					inter[45] = 'O';
					return inter;	

				case 8:
					inter[49] = 'O';
					return inter;	

				case 9:
					inter[53] = 'O';
					return inter;
				}
			}
		}else {
			if(rodada % 2 != 0) {
				switch (pos) {
				case 1:
					inter[1] = primeiro;
					return inter;

				case 2:
					inter[5] = primeiro;
					return inter;

				case 3:
					inter[9] = primeiro;
					return inter;

				case 4:
					inter[23] = primeiro;
					return inter;	

				case 5:
					inter[27] = primeiro;
					return inter;	

				case 6:
					inter[31] = primeiro;
					return inter;	

				case 7:
					inter[45] = primeiro;
					return inter;	

				case 8:
					inter[49] = primeiro;
					return inter;	

				case 9:
					inter[53] = primeiro;
					return inter;	
				}
			}else {
				switch (pos) {
				case 1:
					inter[1] = 'X';
					return inter;

				case 2:
					inter[5] = 'X';
					return inter;

				case 3:
					inter[9] = 'X';
					return inter;

				case 4:
					inter[23] = 'X';
					return inter;	

				case 5:
					inter[27] = 'X';
					return inter;	

				case 6:
					inter[31] = 'X';
					return inter;	

				case 7:
					inter[45] = 'X';
					return inter;	

				case 8:
					inter[49] = 'X';
					return inter;	

				case 9:
					inter[53] = 'X';
					return inter;
				}
			}
		}
		return inter;
	}	

	public static void visualExemplo() {
		print(  " 1 | 2 | 3 "
				+ "\n---|---|---"
				+ "\n 4 | 5 | 6 "
				+ "\n---|---|---"
				+ "\n 7 | 8 | 9 ");

	}
	
	public static void jogarNovamente(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		print("Jogar novamente?"
				+ "\n1) Sim"
				+ "\n2) Não");
		short choice = sc.nextShort();
		while(choice != 1 && choice != 2){
			print("Escolha apenas a opção 1 ou 2.");
			choice = sc.nextShort();
		}
		switch(choice) {

		case 1:
			JogoDaVelha.main(args);
			break;
		case 2:
			Menu.menu(args);
			break;
		}
	}

	public static void print(String str) {
		System.out.println(str);
	}

	public static void printInt(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i == 10 || i == 21 || i == 32 || i == 43 || i == 54) {
				System.out.println();
			}
		}
	}
}