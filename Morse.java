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

    No inicio = null; // Referência para o primeiro nó da lista

    // Método para inserir um elemento no final da lista
    public void insereElemento(String elemento) {
         
        String[] palavras = elemento.split(" ");
        

        for (String palavra : palavras) {  
            No novoNo = new No(palavra); // Cria um novo nó com o elemento fornecido

             if (inicio == null) {
                    // Caso a lista esteja vazia, o início aponta para o novo nó
                    inicio = novoNo;
                    } else {
                        // Caso contrário, percorre a lista até o final
                        No atual = inicio;
                
                
            
            for(int i = 0; i < palavra.length(); i ++){ // mesmo codigo da arvore binaria agora é um for que ira passar pra cada
                //carctere da string
                
               

                if (palavra.charAt(i) == '.') { // se o char do for for . ira para a esquerda
                    if (atual.esquerda == null) {
                        atual.esquerda = novoNo; // se for nulo, o valor e colocado ali
                        break;
                    }
                    atual = atual.esquerda; // Avança para o no para esquerda
                } 
                // Se for -, vai para a direita
                if (palavra.charAt(i) == '-'){
                    if (atual.direita == null) {
                        atual.direita = novoNo; // se for nulo o valor e colocado ali
                        break;
                    }
                    atual = atual.direita; // Avança para o no para direita
                }
                
               
            }

           
        }
    }
    }

    // não foi implementado para a arvore binaria


    // Método para exibir os elementos da lista (para teste)
    public void exibeLista() {
        ArrayList<No> pilha = new ArrayList<No>();
        No atual = inicio;


        System.out.print("Lista: ");
        while (atual != null || !pilha.isEmpty()) {

            // vai para o nó da esquerda o maislonge

            while (atual != null) {
                pilha.add(atual); //adiciona na pilha e vá pro proximo a esquerda ate chegar no ultimo
                atual = atual.esquerda; 
            }

            // Remove o no da pilha
            atual = pilha.remove(pilha.size() - 1);

            // formatação para o print se não ira aparecer o endereço.
            String esq = (atual.esquerda != null) ? String.valueOf(atual.esquerda.dado) : "null";
            String dir = (atual.direita != null) ? String.valueOf(atual.direita.dado) : "null";

            //imprime o atual
            System.out.print(atual.dado + "[" + esq + ", " + dir + "] ");

            // depois começa a acessar a da direita.
            atual = atual.direita;
        }
        System.out.println(); 
    }


    public void buscar(String elemento) {
        ArrayList<No> pilha = new ArrayList<No>();
        No atual = inicio;


        System.out.print("Lista: ");
        while (atual != null || !pilha.isEmpty()) {

            // vai para o nó da esquerda o maislonge

            while (atual != null) {
                pilha.add(atual); //adiciona na pilha e vá pro proximo a esquerda ate chegar no ultimo
                atual = atual.esquerda; 
            }

            // Remove o no da pilha
            atual = pilha.remove(pilha.size() - 1);

            // formatação para o print se não ira aparecer o endereço.
            String esq = (atual.esquerda != null) ? String.valueOf(atual.esquerda.dado) : "null";
            String dir = (atual.direita != null) ? String.valueOf(atual.direita.dado) : "null";

            //imprime o atual
            if (atual.dado == elemento){
                System.out.print(atual.dado + "[" + esq + ", " + dir + "] ");
            }; //mesmo codigo da arvore binaria porem so imprime se for igual o elemento
            

            // depois começa a acessar a da direita.
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
