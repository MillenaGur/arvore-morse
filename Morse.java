package listas;

import java.util.Scanner;

public class Morse {

int maximo = 0; // quantidade de nó para a busca de listas.

     // Classe interna para representar um nó da lista
    class No {
        String dado; // Valor armazenado no nó
        String dadoLetra; // Valor da letra do morse
        No proximo; // Referência para o próximo nó

        No esquerda; // Referência para o próximo nó
        No direita; // Referência para o próximo nó

        // Construtor do nó
        No(String elemento,String letra) {
            this.dado = elemento;
            this.dadoLetra = letra;
            this.proximo = null;

            this.esquerda = null;
            this.direita = null;
        }
    }

    No inicio = null; 
    public void insereElemento(String elemento, String letra) {
         
        String[] palavras = elemento.split(" "); //divide o elemento utilizando o espaço para indicar onde separa
        String[] letras = letra.split(""); // divide as letras.

        try{
			if (palavras.length != letras.length);		// vê se a quantidade de morse digitado é a mesma que as letras.

		}catch(Exception e){
            System.out.print("morse ou letra não possuem o mesmo tamanho");

			menu();
		}
    
        for (int k = 0; k < palavras.length; k++) {   // for para cada palavra do morse
            No novoNo = new No(palavras[k], letras[k]); 

             if (inicio == null) { // se inicio for vazio adicionar no inicio
                    
                inicio = novoNo;
                maximo += 1; // aumenta a quantidade de nó para a busca.
                } else {
                    
                No atual = inicio;
                
                
            
            for(int i = 0; i < palavras[k].length(); i ++){      //caso não, para cada ponto e traço no morse...

                if (palavras[k].charAt(i) == '.') {  // se for ponto vá para a esquerda se for nulo adionar ali, se não vá para o proximo.
                    if (atual.esquerda == null) {
                        atual.esquerda = novoNo; 
                        maximo += 1; // aumenta a quantidade de nó para a busca.
                        
                        break;
                    }
                    atual = atual.esquerda; 
                } 
               

                if (palavras[k].charAt(i) == '-'){  // Se for traço, vai para a direita se for  nulo adionar ali, se não vá para o proximo.
                    if (atual.direita == null) {
                        atual.direita = novoNo; 
                        maximo += 1; // aumenta a quantidade de nó para a busca.
                        
                        break;
                    }
                    atual = atual.direita; 
                }
                
               
            }

           
        }
    }
    }

    


public void exibeLista() {
    // Array estático (vetor normal) para funcionar como pilha
    No[] pilha = new No[maximo];
    int topo = -1; // topo da pilha, - 1 é lista vazia

    No atual = inicio;

    String esq;
    String dir;

    if(topo == maximo - 1){ // vê se a lista está vazia
            System.out.print("Lista Vazia");
            System.out.println(); 
            
        }else{

    System.out.print("Lista: ");
    // Continua se atual não for nulo OU se a pilha não estiver vazia
    while (atual != null || topo > -1) {
        
        
        // Vai para o nó mais à esquerda possível
        while (atual != null) {
            topo += 1; 
            pilha[topo] = atual; // Empilha no vetor
            atual = atual.esquerda;
        }

   
        atual = pilha[topo];   
        topo -= 1; // remove da pilha

        // Formatação para exibição para evitar o erro de nulo.
        if(atual.esquerda != null){

            esq = atual.esquerda.dado.toString();

        }else{esq = "null";}

        if(atual.direita != null){

            dir = atual.direita.dado.toString();

        }else{dir = "null";}

        
        System.out.print(atual.dadoLetra + " = " + atual.dado + "[" + esq + ", " + dir + "] ");

       
        atual = atual.direita; // move para o nó da direita
    }
    System.out.println(); 
    }
}


    public void buscar(String elemento) {

    No[] pilha = new No[maximo]; // pilha de nos
    int topo = -1;  // topo da pilha

    No atual = inicio;

    String esq; // no da esquerda
    String dir; // no da direita

     if(topo == maximo - 1){ //vê se está vazia.
            System.out.print("Lista Vazia");
            System.out.println(); 
            
        }else{

    System.out.print("Lista: ");
    
    while (atual != null || topo > 0) {
        
      // Vai para o nó mais à esquerda possível
        while (atual != null) {
            topo += 1; 
            pilha[topo] = atual;  //Adiciona na pilha
            atual = atual.esquerda;
        }

        atual = pilha[topo];  
        topo -= 1; // remove da pilha

         // Formatação para exibição para evitar o erro de nulo.
        if(atual.esquerda != null){

            esq = atual.esquerda.dado.toString();

        }else{esq = "null";}

        if(atual.direita != null){

            dir = atual.direita.dado.toString();

        }else{dir = "null";}

        
        if (atual.dadoLetra != null && atual.dadoLetra.equals(elemento)) { // vê se o nó atual é o elemento da busca
            System.out.print(atual.dadoLetra + " = " + atual.dado + "[" + esq + ", " + dir + "] ");
            break;
        }
  
        atual = atual.direita; // move para o nó da direita
    }
    System.out.println();
}
    
    }

    public void menu() {
    Scanner scanner = new Scanner(System.in); 

    while (true) {
        
        System.out.println("Digite:");
        System.out.println("1 para inserir");
        System.out.println("2 para buscar");
        System.out.println("3 exibir lista");
        System.out.println("0 para sair");
        
        String opcao = scanner.nextLine();

       
        if (opcao.equals("1")) {
            System.out.println("Digite o morse (digite cada letra por espaço exemplo [--- ..]):");
            String morse = scanner.nextLine();

            System.out.println("Digite a letra (tudo junto ou separado):");
            String letra = scanner.nextLine();

            insereElemento(morse, letra);

        } else if (opcao.equals("2")) {
            System.out.println("Digite a letra:");
            String elemento = scanner.nextLine();
            buscar(elemento);

        } else if (opcao.equals("3")) {
            exibeLista();

        }else if (opcao.equals("0")) {
            break; 
        }
    }

    scanner.close(); 
}



    public static void main(String[] args) {
        Morse morse = new  Morse();

        morse.menu();

        // Inserindo elementos na lista
        //morse.insereElemento(". .- ... --. .--", "A B C D E");

        


        // Exibindo os elementos da lista
        //morse.exibeLista(); // Deve exibir: Lista: 10 20 30
        //morse.buscar(".");

    }
    


    
}
