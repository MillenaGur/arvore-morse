package listas;

import java.util.Scanner;

public class Morse {

int maximo = 0;

     // Classe interna para representar um nó da lista
    class No {
        String dado; // Valor armazenado no nó
        String dadoLetra; // Valor armazenado no nó
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
         
        String[] palavras = elemento.split(" ");
        String[] letras = letra.split("");

        try{
			if (palavras.length != letras.length);		

		}catch(Exception e){
            System.out.print("morse e letra não possuem o mesmo tamanho");

			menu();
		}
    
        for (int k = 0; k < palavras.length; k++) {  
            No novoNo = new No(palavras[k], letras[k]); 

             if (inicio == null) {
                    
                inicio = novoNo;
                maximo += 1; 
                } else {
                    
                No atual = inicio;
                
                
            
            for(int i = 0; i < palavras[k].length(); i ++){     

                if (palavras[k].charAt(i) == '.') { 
                    if (atual.esquerda == null) {
                        atual.esquerda = novoNo; 
                        maximo += 1;
                        
                        break;
                    }
                    atual = atual.esquerda; 
                } 

                if (palavras[k].charAt(i) == '-'){
                    if (atual.direita == null) {
                        atual.direita = novoNo; 
                        maximo += 1;
                        
                        break;
                    }
                    atual = atual.direita; 
                }
                
               
            }

           
        }
    }
    }

    


public void exibeLista() {
    No[] pilha = new No[maximo];
    int topo = -1; 

    No atual = inicio;

    String esq;
    String dir;

    if(topo == maximo - 1){
            System.out.print("Lista Vazia");
            System.out.println(); 
            
        }else{

    System.out.print("Lista: ");
    
    while (atual != null || topo > -1) {

       
        while (atual != null) {
            topo += 1; 
            pilha[topo] = atual; 
            atual = atual.esquerda;
        }
        atual = pilha[topo];   
        topo -= 1;

        if(atual.esquerda != null){

            esq = atual.esquerda.dado.toString();

        }else{esq = "null";}

        if(atual.direita != null){

            dir = atual.direita.dado.toString();

        }else{dir = "null";}

        
        System.out.print(atual.dadoLetra + " = " + atual.dado + "[" + esq + ", " + dir + "] ");

       
        atual = atual.direita;
    }
    System.out.println(); 
    }
}


    public void buscar(String elemento) {
    No[] pilha = new No[maximo];
    int topo = -1; 

    No atual = inicio;

    String esq;
    String dir;

     if(topo == maximo - 1){
            System.out.print("Lista Vazia");
            System.out.println(); 
            
        }else{

    System.out.print("Lista: ");
    
    while (atual != null || topo > 0) {
      
        while (atual != null) {
            topo += 1; 
            pilha[topo] = atual; 
            atual = atual.esquerda;
        }

        atual = pilha[topo];  
        topo -= 1;
        
        if(atual.esquerda != null){

            esq = atual.esquerda.dado.toString();

        }else{esq = "null";}

        if(atual.direita != null){

            dir = atual.direita.dado.toString();

        }else{dir = "null";}
        
        if (atual.dadoLetra != null && atual.dadoLetra.equals(elemento)) {
            System.out.print(atual.dadoLetra + " = " + atual.dado + "[" + esq + ", " + dir + "] ");
        }
  
        atual = atual.direita;
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
        System.out.println("3 exebir lista");
        System.out.println("0 para sair");
        
        String opcao = scanner.nextLine();

       
        if (opcao.equals("1")) {
            System.out.println("Digite o morse (digite cada morse separado por espaço):");
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
        //morse.insereElemento(". .- ... --. .--", "ABCDE");


        // Exibindo os elementos da lista
        //morse.exibeLista(); // Deve exibir: Lista: 10 20 30
        //morse.buscar(".");

    }
    


    
}
