package jogos;

import java.util.Scanner; 

public class JogoDaForcaFunc {

	public static void main(String[] args) throws InterruptedException {
		print("Bem-vindo ao Jogo da Forca!!!"
				+ "\nInsira uma palavra para seu adversário tentar descobrir:");
		String palavra = setPalavra();
		int numLetras = palavra.length();
		String[] tracado = new String[numLetras];
		tracado = tracado(numLetras, tracado, palavra);

		String[] letras = new String[numLetras];
		letras = letras(letras, palavra);

		int contErros = 0;

		print("");
		print("Boa sorte!!!");
		print("");

		String letra;
		String[] acertos = new String[numLetras];

		while(contErros < 6) {
			switch (contErros) {
			case 0:
				JogoDaForcaInt.visual1();
				print("");
				printArr(tracado);
				print("");
				print("\nInsira uma letra que possa completar a palavra:");
				letra = setLetra(acertos);
				acertos = checarLetra(letras, tracado, letra);
				print("");
				if(acerto(acertos, tracado, letra) == false) {
					contErros++;
				}
				break;

			case 1:
				JogoDaForcaInt.visual2();
				print("");
				printArr(tracado);
				print("\nInsira uma letra que possa completar a palavra:");
				letra = setLetra(acertos);
				acertos = checarLetra(letras, tracado, letra);
				print("");
				if(acerto(acertos, tracado, letra) == false) {
					contErros++;
				}
				break;

			case 2:
				JogoDaForcaInt.visual3();
				print("");
				printArr(tracado);
				print("\nInsira uma letra que possa completar a palavra:");
				letra = setLetra(acertos);
				acertos = checarLetra(letras, tracado, letra);
				print("");
				if(acerto(acertos, tracado, letra) == false) {
					contErros++;
				}
				break;

			case 3:
				JogoDaForcaInt.visual4();
				print("");
				printArr(tracado);
				print("\nInsira uma letra que possa completar a palavra:");
				letra = setLetra(acertos);
				acertos = checarLetra(letras, tracado, letra);
				print("");
				if(acerto(acertos, tracado, letra) == false) {
					contErros++;
				}
				break;

			case 4:
				JogoDaForcaInt.visual5();
				print("");
				printArr(tracado);
				print("\nInsira uma letra que possa completar a palavra:");
				letra = setLetra(acertos);
				acertos = checarLetra(letras, tracado, letra);
				print("");
				if(acerto(acertos, tracado, letra) == false) {
					contErros++;
				}
				break;

			case 5:
				JogoDaForcaInt.visual6();
				print("");
				printArr(tracado);
				print("\nInsira uma letra que possa completar a palavra:");
				letra = setLetra(acertos);
				acertos = checarLetra(letras, tracado, letra);
				print("");
				if(acerto(acertos, tracado, letra) == false) {
					contErros++;
				}
				break;	
			}
			if(checarVitoria(acertos) == true) {
				break;
			}
		}
		if(contErros == 6) {
			JogoDaForcaInt.visual7();
			print("");
			printArr(tracado);
			print("");
			print("");
			print("Fim de jogo."
					+ "\nJogador que estava adivinhando perdeu.");
			print("A palavra era: " + palavra);
		}else{
			switch (contErros) {
			case 0:
				JogoDaForcaInt.visual1();
				print("");
				printArr(tracado);
				print("");
				print("");
				print("\nFim de jogo."
						+ "\nJogador que estava adivinhando venceu.");
				print("A palavra era: " + palavra);
				break;

			case 1:
				JogoDaForcaInt.visual2();
				print("");
				printArr(tracado);
				print("");
				print("");
				print("\nFim de jogo."
						+ "\nJogador que estava adivinhando venceu.");
				print("A palavra era: " + palavra);
				break;

			case 2:
				JogoDaForcaInt.visual3();
				print("");
				printArr(tracado);
				print("");
				print("");
				print("\nFim de jogo."
						+ "\nJogador que estava adivinhando venceu.");
				print("A palavra era: " + palavra);
				break;

			case 3:
				JogoDaForcaInt.visual4();
				print("");
				printArr(tracado);
				print("");
				print("");
				print("\nFim de jogo."
						+ "\nJogador que estava adivinhando venceu.");
				print("A palavra era: " + palavra);
				break;

			case 4:
				JogoDaForcaInt.visual5();
				print("");
				printArr(tracado);
				print("");
				print("");
				print("\nFim de jogo."
						+ "\nJogador que estava adivinhando venceu.");
				print("A palavra era: " + palavra);
				break;

			case 5:
				JogoDaForcaInt.visual6();
				print("");
				printArr(tracado);
				print("");
				print("");
				print("\nFim de jogo."
						+ "\nJogador que estava adivinhando venceu.");
				print("A palavra era: " + palavra);
				break;
			}
		}
		print("");
		jogarNovamente(args);
	}

	public static String setPalavra() {
		Scanner sc = new Scanner(System.in);
		String palavra = sc.nextLine().toLowerCase();
		return palavra;
	}

	public static String[] tracado(int numLetras, String[] tracado, String palavra) {
		for (int i = 0; i < numLetras; i++) {
			if(palavra.substring(i, i+1).contentEquals(" ")) {
				tracado[i] = " ";
			}else {
				tracado[i] = "_";
			}
		}
		return tracado;
	}

	public static String[] letras(String[] letras, String palavra) {
		for (int i = 0; i < letras.length; i++) {
			letras[i] = palavra.substring(i, i+1);
		}
		return letras;
	}

	public static String setLetra(String[] acertos) {
		Scanner sc = new Scanner(System.in);
		String letra = sc.nextLine().toLowerCase();

		while(letra.length() > 1) {
			print("Inválido, insira apenas um caracter: ");
			letra = sc.nextLine().toLowerCase();
		}
		return letra;
	}

	public static String[] checarLetra(String[] letras, String[] tracado, String letra)	{
		for (int i = 0; i < letras.length; i++) {
			if(letra.contentEquals(letras[i])) {
				tracado[i] = letra;
			}
		}
		return tracado;
	}

	public static boolean acerto(String[] acertos, String[] tracado, String letra) {
		for (int i = 0; i < acertos.length; i++) {
			if(acertos[i].contentEquals(letra)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checarVitoria(String[] acertos) {
		for (int i = 0; i < acertos.length; i++) {
			if(acertos[i].contains("_")) {
				return false;
			}
		}
		return true;
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
			JogoDaForcaFunc.main(args);
			break;
		case 2:
			Menu.menu(args);
			break;
		}
	}

	public static void printArr(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void print(String str) {
		System.out.println(str);
	}
}
