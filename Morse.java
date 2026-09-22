package listas;
import java.util.ArrayList;

public class Morse {

     // Classe interna para representar um nó da lista
    class No {
        String dado; // Valor armazenado no nó
        No proximo; // Referência para o próximo nó

        No esquerda; // Referência para o próximo nó
        No direita; // Referência para o próximo nó

        // Construtor do nó
        No(String elemento) {
            this.dado = elemento;
            this.proximo = null;

            this.esquerda = null;
            this.direita = null;
        }
    }

    No inicio = null; 
    public void insereElemento(String elemento) {
         
        String[] palavras = elemento.split(" ");
        

        for (String palavra : palavras) {  
            No novoNo = new No(palavra); 

             if (inicio == null) {
                    
                    inicio = novoNo;
                    } else {
                        
                        No atual = inicio;
                
                
            
            for(int i = 0; i < palavra.length(); i ++){ 
                
               

                if (palavra.charAt(i) == '.') { 
                    if (atual.esquerda == null) {
                        atual.esquerda = novoNo; 
                        break;
                    }
                    atual = atual.esquerda; 
                } 
                // Se for -, vai para a direita
                if (palavra.charAt(i) == '-'){
                    if (atual.direita == null) {
                        atual.direita = novoNo; 
                        break;
                    }
                    atual = atual.direita; 
                }
                
               
            }

           
        }
    }
    }

    
    public void exibeLista() {
        ArrayList<No> pilha = new ArrayList<No>();
        No atual = inicio;


        System.out.print("Lista: ");
        while (atual != null || !pilha.isEmpty()) {


            while (atual != null) {
                pilha.add(atual); 
                atual = atual.esquerda; 
            }

            
            atual = pilha.remove(pilha.size() - 1);

            
            String esq = (atual.esquerda != null) ? String.valueOf(atual.esquerda.dado) : "null";
            String dir = (atual.direita != null) ? String.valueOf(atual.direita.dado) : "null";

           
            System.out.print(atual.dado + "[" + esq + ", " + dir + "] ");

            
            atual = atual.direita;
        }
        System.out.println(); 
    }


    public void buscar(String elemento) {
        ArrayList<No> pilha = new ArrayList<No>();
        No atual = inicio;


        System.out.print("Lista: ");
        while (atual != null || !pilha.isEmpty()) {

            

            while (atual != null) {
                pilha.add(atual); 
                atual = atual.esquerda; 
            }

            
            atual = pilha.remove(pilha.size() - 1);

            
            String esq = (atual.esquerda != null) ? String.valueOf(atual.esquerda.dado) : "null";
            String dir = (atual.direita != null) ? String.valueOf(atual.direita.dado) : "null";

           
            if (atual.dado == elemento){
                System.out.print(atual.dado + "[" + esq + ", " + dir + "] ");
            }; 
            

            
            atual = atual.direita;
        }
        System.out.println(); 
    }



    public static void main(String[] args) {
        Morse morse = new  Morse();

        // Inserindo elementos na lista
        morse.insereElemento(". .- ... --. .--");

        


        // Exibindo os elementos da lista
        morse.exibeLista(); // Deve exibir: Lista: 10 20 30
        //morse.buscar(".");

    }
    


    
}
