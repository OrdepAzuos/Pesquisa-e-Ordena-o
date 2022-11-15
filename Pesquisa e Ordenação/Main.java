import java.util.*;

public class Main {
  static Scanner teclado = new Scanner(System.in);

  public static void main(String[] args) {
    int opcao;
    do {
      menu();
      opcao = teclado.nextInt();
      switch (opcao) {
        case 1:
          testeCemElementos();
          break;
        case 2:
          testeMilElementos();
          break;
        case 3:
          testeDezMilElementos();
          break;
        case 4:
          testeCemMilElementos();
          break;
        case 5:
          testeUmMilhaoElementos();
          break;
        case 6:
          System.out.println("Programa encerrado");
          feitoPor();
          break;
        default:
          System.out.println("Opção Inválida!");
          break;
      }
    } while (opcao != 6);
  }

  static int partition(int a[], int start, int end) {
    int pivot = a[end];
    int i = (start - 1);

    for (int j = start; j < end; j++) {
      if (a[j] < pivot) {
        i++;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
      }
    }
    int t = a[i + 1];
    a[i + 1] = a[end];
    a[end] = t;
    return (i + 1);
  }
  
  private static int separar(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int i = inicio + 1;
		while (i <= fim) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[fim])
				fim--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[fim];
				vetor[fim] = troca;
				i++;
				fim--;
			  }
		  }
		  vetor[inicio] = vetor[fim];
		  vetor[fim] = pivo;
		  return fim;
	  }
	
  static long quickSort(int a[], int start, int end) {
    // Quick Sort :θ(n log(n))

    long comeco = System.currentTimeMillis();
    if (start < end) {
			int posicaoPivo = separar(a, start, end);
			quickSort(a, start, end - 1);
			quickSort(a, posicaoPivo + 1, end);

		}
    long tempo = System.currentTimeMillis() - comeco;
    return tempo;
    
  }

  static void merge(int a[], int beg, int mid, int end) {
    int i, j, k;
    int n1 = mid - beg + 1;
    int n2 = end - mid;

    int LeftArray[] = new int[n1];
    int RightArray[] = new int[n2];

    for (i = 0; i < n1; i++)
      LeftArray[i] = a[beg + i];
    for (j = 0; j < n2; j++)
      RightArray[j] = a[mid + 1 + j];

    i = 0;
    j = 0;
    k = beg;

    while (i < n1 && j < n2) {
      if (LeftArray[i] <= RightArray[j]) {
        a[k] = LeftArray[i];
        i++;
      } else {
        a[k] = RightArray[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      a[k] = LeftArray[i];
      i++;
      k++;
    }
    while (j < n2) {
      a[k] = RightArray[j];
      j++;
      k++;
    }
  }

  static long mergeSort(int a[], int beg, int end) {
    // Merge Sort: θ(n log(n))
    long comeco = System.currentTimeMillis();
    if (beg < end) {
      int mid = (beg + end) / 2;
      mergeSort(a, beg, mid);
      mergeSort(a, mid + 1, end);
      merge(a, beg, mid, end);
    }
    long tempo = System.currentTimeMillis() - comeco;
    return tempo;
  }

  static long shellSort(int[] arr) {
    // Shell Sort: θ(n log(n))
    long comeco = System.currentTimeMillis();
    int n = arr.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i++) {
        int key = arr[i];
        int j = i;
        while (j >= gap && arr[j - gap] > key) {
          arr[j] = arr[j - gap];
          j -= gap;
        }
        arr[j] = key;
      }
    }
    long tempo = System.currentTimeMillis() - comeco;
    return tempo;
  }

  static long bubbleSort(int[] arr) {
    // Bubble Sort: Θ(n^2)
    long comeco = System.currentTimeMillis();
    int n = arr.length;
    int temp = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        if (arr[j - 1] > arr[j]) {
          temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
    long tempo = System.currentTimeMillis() - comeco;
    return tempo;
  }

  static long selectionSort(int[] arr) {
    // Selection Sort: Θ(n^2)
    long comeco = System.currentTimeMillis();
    for (int i = 0; i < arr.length - 1; i++) {
      int index = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[index]) {
          index = j;
        }
      }
      int smallerNumber = arr[index];
      arr[index] = arr[i];
      arr[i] = smallerNumber;
    }
    long tempo = System.currentTimeMillis() - comeco;
    return tempo;
  }

  static long insertionSort(int[] array) {
    // Insertion Sort: Θ(n^2)
    long comeco = System.currentTimeMillis();
    for (int i = 0; i < array.length; ++i) {
      int j = i;
      while (j > 0 && array[j - 1] > array[j]) {
        int key = array[j];
        array[j] = array[j - 1];
        array[j - 1] = key;
        j = j - 1;
      }
    }
    long tempo = System.currentTimeMillis() - comeco;
    return tempo;
  }

  static void gerarNumeros() {
    int aux = Integer.MAX_VALUE;
    for (int i = 0; i < 1000000; i++) {
      if (i < 100) {
        vetorCemAleatorio[i] = 1 + (int) (Math.random() * 100);
        vetorCemCrescente[i] = i;
        vetorCemDecrescente[i] = aux - 1;
      }
      if (i < 1000) {
        vetorMilAleatorio[i] = 1 + (int) (Math.random() * 1000);
        vetorMilCrescente[i] = i;
        vetorMilDecrescente[i] = aux - 1;
      }
      if (i < 10000) {
        vetorDezMilAleatorio[i] = 1 + (int) (Math.random() * 10000);
        vetorDezMilCrescente[i] = i;
        vetorDezMilDecrescente[i] = aux - 1;
      }
      if (i < 100000) {
        vetorCemMilAleatorio[i] = 1 + (int) (Math.random() * 100000);
        vetorCemMilCrescente[i] = i;
        vetorCemMilDecrescente[i] = aux - 1;
      }
      if (i < 1000000) {
        vetorMilhaoAleatorio[i] = 1 + (int) (Math.random() * 1000000);
        vetorMilhaoCrescente[i] = i;
        vetorMilhaoDecrescente[i] = aux - 1;
      }
      aux--;
    }
  }

  static void testeCemElementos() {
    gerarNumeros();

    System.out.println("==============================================");
    System.out.println("Vetor com números aleatorios (cem elementos): ");
    System.out.println("==============================================");
    System.out.println("Insertion Sort : " + insertionSort(vetorCemAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort : " + selectionSort(vetorCemAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort : " + bubbleSort(vetorCemAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort : " + shellSort(vetorCemAleatorio) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Merge Sort : " + mergeSort(vetorCemAleatorio, 0, vetorCemAleatorio.length - 1) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Quick Sort : " + quickSort(vetorCemAleatorio, 0, vetorCemAleatorio.length - 1) + " milisegundos");
    System.out.println("==============================================\n");

    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números crescentes (cem elementos): ");
    System.out.println("==============================================");
    System.out.println("Insertion Sort: " + insertionSort(vetorCemCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorCemCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorCemCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorCemCrescente) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Merge Sort: " + mergeSort(vetorCemCrescente, 0, vetorCemCrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Quick Sort: " + quickSort(vetorCemCrescente, 0, vetorCemCrescente.length - 1) + " milisegundos");
    System.out.println("==============================================\n");

    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números decrescentes (cem elementos): ");
    System.out.println("==============================================");
    System.out.println("\nInsertion Sort: " + insertionSort(vetorCemDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorCemDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorCemDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorCemDecrescente) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Merge Sort: " + mergeSort(vetorCemDecrescente, 0, vetorCemDecrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Quick Sort: " + quickSort(vetorCemDecrescente, 0, vetorCemDecrescente.length - 1) + " milisegundos");
    System.out.println("==============================================\n");
  }

  static void testeMilElementos() {
    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números aleatorios (mil elementos): ");
    System.out.println("==============================================");
    System.out.println("Insertion Sort : " + insertionSort(vetorMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort : " + selectionSort(vetorMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort : " + bubbleSort(vetorMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort : " + shellSort(vetorMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Merge Sort : " + mergeSort(vetorMilAleatorio, 0, vetorMilAleatorio.length - 1) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Quick Sort : " + quickSort(vetorMilAleatorio, 0, vetorMilAleatorio.length - 1) + " milisegundos");
    System.out.println("==============================================\n");

    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números crescentes (mil elementos): ");
    System.out.println("==============================================");
    System.out.println("\nInsertion Sort: " + insertionSort(vetorMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Merge Sort: " + mergeSort(vetorMilCrescente, 0, vetorMilCrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Quick Sort: " + quickSort(vetorMilCrescente, 0, vetorMilCrescente.length - 1) + " milisegundos");
    System.out.println("==============================================\n");

    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números decrescentes (mil elementos): ");
    System.out.println("==============================================");
    System.out.println("\nInsertion Sort: " + insertionSort(vetorMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Merge Sort: " + mergeSort(vetorMilDecrescente, 0, vetorMilDecrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out
        .println("Quick Sort: " + quickSort(vetorMilDecrescente, 0, vetorMilDecrescente.length - 1) + " milisegundos");
    System.out.println("==============================================\n");
  }

  static void testeDezMilElementos() {
    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números aleatorios (dez mil elementos): ");
    System.out.println("==============================================");
    System.out.println("Insertion Sort : " + insertionSort(vetorDezMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort : " + selectionSort(vetorDezMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort : " + bubbleSort(vetorDezMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort : " + shellSort(vetorDezMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out
        .println(
            "Merge Sort : " + mergeSort(vetorDezMilAleatorio, 0, vetorDezMilAleatorio.length - 1) + " milisegundos");
    gerarNumeros();
    System.out
        .println(
            "Quick Sort : " + quickSort(vetorDezMilAleatorio, 0, vetorDezMilAleatorio.length - 1) + " milisegundos");
    System.out.println("==============================================\n");

    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números crescentes (dez mil elementos): ");
    System.out.println("==============================================");
    System.out.println("\nInsertion Sort: " + insertionSort(vetorDezMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorDezMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorDezMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorDezMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Merge Sort: " + mergeSort(vetorDezMilCrescente, 0, vetorDezMilCrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Quick Sort: " + quickSort(vetorDezMilCrescente, 0, vetorDezMilCrescente.length - 1) + " milisegundos");
    System.out.println("==============================================\n");

    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números decrescentes (dez mil elementos): ");
    System.out.println("==============================================");
    System.out.println("\nInsertion Sort: " + insertionSort(vetorDezMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorDezMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorDezMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorDezMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Merge Sort: " + mergeSort(vetorDezMilDecrescente, 0, vetorDezMilDecrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Quick Sort: " + quickSort(vetorDezMilDecrescente, 0, vetorDezMilDecrescente.length - 1) + " milisegundos");
    System.out.println("==============================================\n");
  }

  static void testeCemMilElementos() {
    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números aleatorios (cem mil elementos): ");
    System.out.println("==============================================");
    System.out.println("Insertion Sort : " + insertionSort(vetorCemMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort : " + selectionSort(vetorCemMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort : " + bubbleSort(vetorCemMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort : " + shellSort(vetorCemMilAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Merge Sort : " + mergeSort(vetorCemMilAleatorio, 0, vetorCemMilAleatorio.length - 1) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Quick Sort : " + quickSort(vetorCemMilAleatorio, 0, vetorCemMilAleatorio.length - 1) + " milisegundos");
    System.out.println("==============================================\n");

    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números crecentes (cem mil elementos): ");
    System.out.println("==============================================");
    System.out.println("\nInsertion Sort: " + insertionSort(vetorCemMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorCemMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorCemMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorCemMilCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Merge Sort: " + mergeSort(vetorCemMilCrescente, 0, vetorCemMilCrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Quick Sort: " + quickSort(vetorCemMilCrescente, 0, vetorCemMilCrescente.length - 1) + " milisegundos");
    System.out.println("==============================================\n");

    gerarNumeros();
    System.out.println("==============================================");
    System.out.println("Vetor com números decrecentes (cem mil elementos): ");
    System.out.println("==============================================");
    System.out.println("\nInsertion Sort: " + insertionSort(vetorCemMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorCemMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorCemMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorCemMilDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Merge Sort: " + mergeSort(vetorCemMilDecrescente, 0, vetorCemMilDecrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Quick Sort: " + quickSort(vetorCemMilDecrescente, 0, vetorCemMilDecrescente.length - 1) + " milisegundos");
    System.out.println("==============================================\n");
  }

  static void testeUmMilhaoElementos() {
    gerarNumeros();
    System.out.println("====================================================");
    System.out.println("Vetor com números aleatorios (um milhao de elementos): ");
    System.out.println("====================================================");
    System.out.println("Insertion Sort : " + insertionSort(vetorMilhaoAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort : " + selectionSort(vetorMilhaoAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort : " + bubbleSort(vetorMilhaoAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort : " + shellSort(vetorMilhaoAleatorio) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Merge Sort : " + mergeSort(vetorMilhaoAleatorio, 0, vetorMilhaoAleatorio.length - 1) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Quick Sort : " + quickSort(vetorMilhaoAleatorio, 0, vetorMilhaoAleatorio.length - 1) + " milisegundos");
    System.out.println("====================================================\n");

    gerarNumeros();
    System.out.println("====================================================");
    System.out.println("Vetor com números crescentes (um milhao de elementos): ");
    System.out.println("====================================================");
    System.out.println("\nInsertion Sort: " + insertionSort(vetorMilhaoCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorMilhaoCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorMilhaoCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorMilhaoCrescente) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Merge Sort: " + mergeSort(vetorMilhaoCrescente, 0, vetorMilhaoCrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Quick Sort: " + quickSort(vetorMilhaoCrescente, 0, vetorMilhaoCrescente.length - 1) + " milisegundos");
    System.out.println("====================================================\n");

    gerarNumeros();
    System.out.println("====================================================");
    System.out.println("Vetor com números decrescentes (um milhao de elementos): ");
    System.out.println("====================================================");
    System.out.println("\nInsertion Sort: " + insertionSort(vetorMilhaoDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Selection Sort: " + selectionSort(vetorMilhaoDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Bubble Sort: " + bubbleSort(vetorMilhaoDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println("Shell Sort: " + shellSort(vetorMilhaoDecrescente) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Merge Sort: " + mergeSort(vetorMilhaoDecrescente, 0, vetorMilhaoDecrescente.length - 1) + " milisegundos");
    gerarNumeros();
    System.out.println(
        "Quick Sort: " + quickSort(vetorMilhaoDecrescente, 0, vetorMilhaoDecrescente.length - 1) + " milisegundos");
    System.out.println("====================================================\n");
  }

  static int[] vetorCemAleatorio = new int[100];
  static int[] vetorCemCrescente = new int[100];
  static int[] vetorCemDecrescente = new int[100];

  static int[] vetorMilAleatorio = new int[1000];
  static int[] vetorMilCrescente = new int[1000];
  static int[] vetorMilDecrescente = new int[1000];

  static int[] vetorDezMilAleatorio = new int[10000];
  static int[] vetorDezMilCrescente = new int[10000];
  static int[] vetorDezMilDecrescente = new int[10000];

  static int[] vetorCemMilAleatorio = new int[100000];
  static int[] vetorCemMilCrescente = new int[100000];
  static int[] vetorCemMilDecrescente = new int[100000];

  static int[] vetorMilhaoAleatorio = new int[1000000];
  static int[] vetorMilhaoCrescente = new int[1000000];
  static int[] vetorMilhaoDecrescente = new int[1000000];

  static void menu() {
    System.out.println("+-------------------------------------------------------+");
    System.out.println("|                  Escolha uma opção                    |");
    System.out.println("+-------------------------------------------------------+");
    System.out.println("|  1. Cem elementos                                     |");
    System.out.println("|  2. Mil elementos                                     |");
    System.out.println("|  3. Dez mil elementos                                 |");
    System.out.println("|  4. Cem mil elementos                                 |");
    System.out.println("|  5. Um milhão de elementos                            |");
    System.out.println("|  6. Sair                                              |");
    System.out.println("+-------------------------------------------------------+");
  }

  static void feitoPor() {
    System.out.println("Feito por Filipe Freitas Alves Rosa e Pedro Henrique de Souza Almeida");
  }
}