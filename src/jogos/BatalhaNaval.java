package jogos;

import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) throws InterruptedException {
		//variáveis e arrays

		char[][] inter1 = createInter();
		char[][] inter2 = createInter();		

		boolean[][] posFilled1 = createPosFilledArr();
		boolean[][] posFilled2 = createPosFilledArr();

		boolean[][] posStruck1 = createPosStruckArr();
		boolean[][] posStruck2 = createPosStruckArr();

		int line = 0, column = 0, round = 0;

		//posicionamento dos navios	jogador 1

		printInter(inter1);

		print("");
		print("Jogador 1, posicione seus navios");
		print("");
		print("A posição do porta-aviões (5 espaços) deve ser escolhida baseada nas linhas e colunas respectivamente");
		posFilled1 = setPosPortaAvioes(posFilled1);
		print("");

		print("A posição dos navios-tanque (4 espaços) deve ser escolhida baseada nas linhas e colunas respectivamente");
		for (int i = 1; i <= 2; i++) {
			if(i == 2) {
				print("Posicione o segundo navio-tanque");
			}
			posFilled1 = setPosNavioTanque(posFilled1);
			print("");
		}

		print("A posição dos contratorpedeiros (3 espaços) deve ser escolhida baseada nas linhas e colunas respectivamente");
		for (int i = 1; i <= 3; i++) {
			if(i == 2) {
				print("Posicione o segundo contratorpedeiro");
			}else if(i == 3) {
				print("Posicione o terceiro contratorpedeiro");
			}
			posFilled1 = setPosContratorpedeiro(posFilled1);
			print("");
		}

		print("A posição dos submarinos (2 espaços) deve ser escolhida baseada nas linhas e colunas respectivamente");
		for (int i = 1; i <= 4; i++) {
			if(i == 2) {
				print("Posicione o segundo submarino");
			}else if(i == 3) {
				print("Posicione o terceiro submarino");
			}else if(i == 4) {
				print("Posicione o quarto submarino");
			}
			posFilled1 = setPosSubmarino(posFilled1);
			print("");
		}

		//posicionamento dos navios	jogador 2

		printInter(inter2);

		print("");
		print("Jogador 2, posicione seus navios");
		print("A posição do porta-aviões (5 espaços) deve ser escolhida baseada nas linhas e colunas respectivamente");
		posFilled2 = setPosPortaAvioes(posFilled2);
		print("");

		print("A posição dos navios-tanque (4 espaços) deve ser escolhida baseada nas linhas e colunas respectivamente");
		for (int i = 1; i <= 2; i++) {
			if(i == 2) {
				print("Posicione o segundo navio-tanque");
			}
			posFilled2 = setPosNavioTanque(posFilled2);
			print("");
		}

		print("A posição dos contratorpedeiros (3 espaços) deve ser escolhida baseada nas linhas e colunas respectivamente");
		for (int i = 1; i <= 3; i++) {
			if(i == 2) {
				print("Posicione o segundo contratorpedeiro");
			}else if(i == 3) {
				print("Posicione o terceiro contratorpedeiro");
			}
			posFilled2 = setPosContratorpedeiro(posFilled2);
			print("");
		}

		print("A posição dos submarinos (2 espaços) deve ser escolhida baseada nas linhas e colunas respectivamente");
		for (int i = 1; i <= 4; i++) {
			if(i == 2) {
				print("Posicione o segundo submarino");
			}else if(i == 3) {
				print("Posicione o terceiro submarino");
			}else if(i == 4) {
				print("Posicione o quarto submarino");
			}
			posFilled2 = setPosSubmarino(posFilled2);
			print("");
		}

		//"tutorial"

		print("Ao efetuar a jogada:" + 
				"\nO = posição atacada contém um navio" +
				"\nX = posição atacada não contém um navio\n");

		//efetuar a jogada

		do {
			if(round % 2 == 0) {

				print("Escolha uma posição para atirar usando as linhas e as colunas respectivamente");
				print("");
				print("Vez do jogador 1");
				printInter(inter2);
				line = setLine();
				column = setColumn();

				while(!(checkShotPos(posStruck2, line, column))){
					print("Posição fora dos limites do tabuleiro ou já atacada, tente outra");
					line = setLine();
					column = setColumn();
				}

				posStruck2 = shot(posStruck2, line, column);
				inter2 = interAfterShot(posFilled2, inter2, line, column);
				print("Campo inimigo após a jogada:");
				printInter(inter2);
				print("");
				sleep();
				round++;
			}else {

				print("Escolha uma posição para atirar usando as linhas e as colunas respectivamente");
				print("");
				print("Vez do jogador 2");
				printInter(inter1);
				line = setLine();
				column = setColumn();
				while(!(checkShotPos(posStruck1, line, column))){
					print("Posição fora dos limites do tabuleiro ou já atacada, tente outra");
					line = setLine();
					column = setColumn();
				}

				posStruck1 = shot(posStruck1, line, column);
				inter1 = interAfterShot(posFilled1, inter1, line, column);
				print("Campo inimigo após a jogada:");
				printInter(inter1);
				print("");
				sleep();
				round++;
			}
		}while(!(checkVictory1(posFilled2, posStruck2)) && !(checkVictory2(posFilled1, posStruck1)));

		if(checkVictory1(posFilled2, posStruck2)){
			print("Jogador 1 venceu!!!");
		}else {
			print("Jogador 2 venceu!!!");
		}
		jogarNovamente(args);
	}

	//métodos para posicionar os navios

	public static boolean[][] setPosSubmarino(boolean[][] posFilled) {
		Scanner sc = new Scanner(System.in);
		int line = 0, column = 0;
		int line1 = 0, column1 = 0;

		do {
			print("Escolha um espaço que será uma extremidade do navio:");
			do {
				line = sc.nextInt();
				while(line < 0 || line > 9) {
					print("Escolha uma linha de 0 a 9 apenas");
					line = sc.nextInt();
				}	
				column = sc.nextInt();
				while(column < 0 || column > 9) {
					print("Escolha uma coluna de 0 a 9 apenas");
					column = sc.nextInt();
				}
				if(posFilled[line][column] == true) {
					print("Posição já ocupada, escolha novamente");
				}
			}while(posFilled[line][column] == true);

			print("Escolha uma espaço para a outra extremidade do navio:");
			do {
				line1 = sc.nextInt();
				while(line1 < 0 || line1 > 9) {
					print("Escolha uma linha de 0 a 9 apenas");
					line1 = sc.nextInt();
				}
				column1 = sc.nextInt();
				while(column1 < 0 || column1 > 9) {
					print("Escolha uma coluna de 0 a 9 apenas");
					column1 = sc.nextInt();
				}
				if(posFilled[line1][column1] == true) {
					print("Posição já ocupada, escolha novamente");
				}
			}while(posFilled[line1][column1] == true);

			if(!(checkPosSubmarino(posFilled, line, column, line1, column1))) {
				print("Posição inválida, repita o processo");
				print("");
			}
		}while(!(checkPosSubmarino(posFilled, line, column, line1, column1)));

		posFilled = posFiller(posFilled, line, column, line1, column1);
		return posFilled;
	}

	public static boolean checkPosSubmarino(boolean[][] posFilled, int line, int column, int line1, int column1) {
		if(line == line1) {
			if((column - column1) == 1 || (column1 - column) == 1){
				for (int j = column; j <= column1; j++) {
					if(posFilled[line][j] == true) {
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}else if(column == column1) {
			if((line - line1) == 1 || (line1 - line) == 1){
				for (int i = line; i <= line1; i++) {
					if(posFilled[i][column] == true) {
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public static boolean[][] setPosContratorpedeiro(boolean[][] posFilled) {
		Scanner sc = new Scanner(System.in);
		int line = 0, column = 0;
		int line1 = 0, column1 = 0;

		do {
			print("Escolha um espaço que será uma extremidade do navio:");
			do {
				line = sc.nextInt();
				while(line < 0 || line > 9) {
					print("Escolha uma linha de 0 a 9 apenas");
					line = sc.nextInt();
				}	
				column = sc.nextInt();
				while(column < 0 || column > 9) {
					print("Escolha uma coluna de 0 a 9 apenas");
					column = sc.nextInt();
				}
				if(posFilled[line][column] == true) {
					print("Posição já ocupada, escolha novamente");
				}
			}while(posFilled[line][column] == true);

			print("Escolha uma espaço para a outra extremidade do navio:");
			do {
				line1 = sc.nextInt();
				while(line1 < 0 || line1 > 9) {
					print("Escolha uma linha de 0 a 9 apenas");
					line1 = sc.nextInt();
				}
				column1 = sc.nextInt();
				while(column1 < 0 || column1 > 9) {
					print("Escolha uma coluna de 0 a 9 apenas");
					column1 = sc.nextInt();
				}
				if(posFilled[line1][column1] == true) {
					print("Posição já ocupada, escolha novamente");
				}
			}while(posFilled[line1][column1] == true);

			if(!(checkPosContratorpedeiro(posFilled, line, column, line1, column1))) {
				print("Posição inválida, repita o processo");
				print("");
			}
		}while(!(checkPosContratorpedeiro(posFilled, line, column, line1, column1)));

		posFilled = posFiller(posFilled, line, column, line1, column1);
		return posFilled;
	}

	public static boolean checkPosContratorpedeiro(boolean[][] posFilled, int line, int column, int line1, int column1) {
		if(line == line1) {
			if((column - column1) == 2 || (column1 - column) == 2){
				for (int j = column; j <= column1; j++) {
					if(posFilled[line][j] == true) {
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}else if(column == column1) {
			if((line - line1) == 2 || (line1 - line) == 2){
				for (int i = line; i <= line1; i++) {
					if(posFilled[i][column] == true) {
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public static boolean[][] setPosNavioTanque(boolean[][] posFilled) {
		Scanner sc = new Scanner(System.in);
		int line = 0, column = 0;
		int line1 = 0, column1 = 0;

		do {
			print("Escolha um espaço que será uma extremidade do navio:");
			do {
				line = sc.nextInt();
				while(line < 0 || line > 9) {
					print("Escolha uma linha de 0 a 9 apenas");
					line = sc.nextInt();
				}	
				column = sc.nextInt();
				while(column < 0 || column > 9) {
					print("Escolha uma coluna de 0 a 9 apenas");
					column = sc.nextInt();
				}
				if(posFilled[line][column] == true) {
					print("Posição já ocupada, escolha novamente");
				}
			}while(posFilled[line][column] == true);

			print("Escolha uma espaço para a outra extremidade do navio:");
			do {
				line1 = sc.nextInt();
				while(line1 < 0 || line1 > 9) {
					print("Escolha uma linha de 0 a 9 apenas");
					line1 = sc.nextInt();
				}
				column1 = sc.nextInt();
				while(column1 < 0 || column1 > 9) {
					print("Escolha uma coluna de 0 a 9 apenas");
					column1 = sc.nextInt();
				}
				if(posFilled[line1][column1] == true) {
					print("Posição já ocupada, escolha novamente");
				}
			}while(posFilled[line1][column1] == true);

			if(!(checkPosNavioTanque(posFilled, line, column, line1, column1))) {
				print("Posição inválida, repita o processo");
				print("");
			}
		}while(!(checkPosNavioTanque(posFilled, line, column, line1, column1)));

		posFilled = posFiller(posFilled, line, column, line1, column1);
		return posFilled;
	}

	public static boolean checkPosNavioTanque(boolean[][] posFilled, int line, int column, int line1, int column1) {
		if(line == line1) {
			if((column - column1) == 3 || (column1 - column) == 3){
				for (int j = column; j <= column1; j++) {
					if(posFilled[line][j] == true) {
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}else if(column == column1) {
			if((line - line1) == 3 || (line1 - line) == 3){
				for (int i = line; i <= line1; i++) {
					if(posFilled[i][column] == true) {
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public static boolean[][] setPosPortaAvioes(boolean[][] posFilled) {
		Scanner sc = new Scanner(System.in);
		int line = 0, column = 0;
		int line1 = 0, column1 = 0;

		do {
			print("Escolha um espaço que será uma extremidade do navio:");
			do {
				line = sc.nextInt();
				while(line < 0 || line > 9) {
					print("Escolha uma linha de 0 a 9 apenas");
					line = sc.nextInt();
				}	
				column = sc.nextInt();
				while(column < 0 || column > 9) {
					print("Escolha uma coluna de 0 a 9 apenas");
					column = sc.nextInt();
				}
				if(posFilled[line][column] == true) {
					print("Posição já ocupada, escolha novamente");
				}
			}while(posFilled[line][column] == true);

			print("Escolha uma espaço para a outra extremidade do navio:");
			do {
				line1 = sc.nextInt();
				while(line1 < 0 || line1 > 9) {
					print("Escolha uma linha de 0 a 9 apenas");
					line1 = sc.nextInt();
				}
				column1 = sc.nextInt();
				while(column1 < 0 || column1 > 9) {
					print("Escolha uma coluna de 0 a 9 apenas");
					column1 = sc.nextInt();
				}
				if(posFilled[line1][column1] == true) {
					print("Posição já ocupada, escolha novamente");
				}
			}while(posFilled[line1][column1] == true);

			if(!(checkPosPortaAvioes(posFilled, line, column, line1, column1))) {
				print("Posição inválida, repita o processo");
				print("");
			}
		}while(!(checkPosPortaAvioes(posFilled, line, column, line1, column1)));

		posFilled = posFiller(posFilled, line, column, line1, column1);
		return posFilled;
	}

	public static boolean checkPosPortaAvioes(boolean[][] posFilled, int line, int column, int line1, int column1) {
		if(line == line1) {
			if((column - column1) == 4 || (column1 - column) == 4){
				for (int j = column; j <= column1; j++) {
					if(posFilled[line][j] == true) {
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}else if(column == column1) {
			if((line - line1) == 4 || (line1 - line) == 4){
				for (int i = line; i <= line1; i++) {
					if(posFilled[i][column] == true) {
						return false;
					}
				}
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public static boolean[][] posFiller(boolean[][] posFilled, int line, int column, int line1, int column1){
		if(line == line1) {
			if(column1 > column) {	
				for (int j = column; j <= column1; j++) {
					posFilled[line][j] = true;
				}
			}else {
				for (int j = column1; j <= column; j++) {
					posFilled[line][j] = true;
				}
			}
		}else if(column == column1) {

			if(line1 > line) {	
				for (int i = line; i <= line1; i++) {
					posFilled[i][column] = true;
				}
			}else {
				for (int i = line1; i <= line; i++) {
					posFilled[i][column] = true;
				}
			}
		}
		return posFilled;
	}

	//métodos criação arrays

	public static boolean[][] createPosStruckArr() {
		boolean[][] posStruck = new boolean[10][10];
		for (int i = 0; i < posStruck.length; i++) {
			for (int j = 0; j < posStruck[i].length; j++) {
				posStruck[i][j] = false;
			}
		}
		return posStruck;
	}

	public static boolean[][] createPosFilledArr() {
		boolean[][] posFilled = new boolean[10][10];
		for (int i = 0; i < posFilled.length; i++) {
			for (int j = 0; j < posFilled[i].length; j++) {
				posFilled[i][j] = false;
			}
		}
		return posFilled;
	}

	public static char[][] createInter() {
		char[][] inter = new char[10][10];
		for (int i = 0; i < inter.length; i++) {
			for (int j = 0; j < inter[i].length; j++) {
				inter[i][j] = ' ';
			}
		}
		return inter;
	}

	//métodos de jogabilidade

	public static int setLine() {
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();
		return line;
	}

	public static int setColumn() {
		Scanner sc = new Scanner(System.in);
		int column = sc.nextInt();
		return column;
	}

	public static boolean checkShotPos(boolean[][] posStruck, int line, int column) {
		if((line < 0 || line > 9 || column < 0 || column > 9)) {
			return false;
		}else {
			if(posStruck[line][column]) {
				return  false;
			}else {
				return  true;
			}
		}
	}

	public static boolean[][] shot(boolean[][] posStruck, int line, int column) {
		posStruck[line][column] = true;
		return posStruck;
	}

	public static char[][] interAfterShot(boolean[][] posFilled, char[][] inter, int line, int column){
		if(posFilled[line][column]) {
			inter[line][column] = 'O';
		}else {
			inter[line][column] = 'X';
		}
		return inter;
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
			BatalhaNaval.main(args);
			break;
		case 2:
			Menu.menu(args);
			break;
		}
	}

	public static boolean checkVictory1(boolean[][] posFilled, boolean[][] posStruck) {
		int cont = 0;
		for (int i = 0; i < posFilled.length; i++) {
			for (int j = 0; j < posFilled[i].length; j++) {
				if(posStruck[i][j] && posFilled[i][j]) {
					cont++;
				}
			}
		}
		if(cont == 30) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean checkVictory2(boolean[][] posFilled, boolean[][] posStruck) {
		int cont = 0;
		for (int i = 0; i < posFilled.length; i++) {
			for (int j = 0; j < posFilled[i].length; j++) {
				if(posStruck[i][j] && posFilled[i][j]) {
					cont++;
				}
			}
		}
		if(cont == 30) {
			return true;
		}else {
			return false;
		}
	}

	//outros

	public static void sleep() throws InterruptedException {
		Thread.sleep(1500);
	}

	public static void printInter(char[][] arr) {
		System.out.println("     0   1   2   3   4   5   6   7   8   9");
		System.out.println("   -----------------------------------------");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(j == 0 && i == 0){
					System.out.print("0  ");
				}
				else if((j == 0 && i == 1) || (j == 0 && i == 2) || (j == 0 && i == 3) || (j == 0 && i == 4) || (j == 0 && i == 5) || 
						(j == 0 && i == 6) || (j == 0 && i == 7) || (j == 0 && i == 8) || (j == 0 && i == 9)) {
					System.out.println();
					System.out.println("   -----------------------------------------");
					switch (i) {
					case 1:
						System.out.print("1  ");
						break;

					case 2:
						System.out.print("2  ");
						break;

					case 3:
						System.out.print("3  ");
						break;

					case 4:
						System.out.print("4  ");
						break;

					case 5:
						System.out.print("5  ");
						break;

					case 6:
						System.out.print("6  ");
						break;

					case 7:
						System.out.print("7  ");
						break;

					case 8:
						System.out.print("8  ");
						break;

					case 9:
						System.out.print("9  ");
						break;
					}
				}
				System.out.print("|" + " " + arr[i][j] + " ");
			}
			System.out.print("|");
		}
		System.out.println();
		System.out.println("   -----------------------------------------");
	}

	public static void print(String str) {
		System.out.println(str);
	}
}