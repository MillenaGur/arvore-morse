# arvore-morse

integrantes grupo: Millena Gurczakovski

**inserir elementos:** o código pega a frase de elemento (morse), divide entre eles usando espaço como indicador onde começa e termina uma palavra, salva em um lista, o mesmo para a letra.
Depois começa um for para cada palavra dessa lista de elemento e um outro for para cada letra da palavra do elemnto.
Para inserir ele vê se o valor seja ponto (menor) para esquerda ou traço (maior) para direita, caso tenha um lugar dispovivel ou seja null, é adicionado ali se não é passado pra proxima folha e continua na proxima letra da palavra até encontrar um valor nulo, também para cada nó criado e aumentado a variavel "maxima" em 1 para poder indicar o valor maximo da pilha para busca.
Possue um tratamento de erro caso a quantidade de morse não é a mesma das letras exemplo.

**Buscar elemento**: possue uma pilha e um indicador para o topo se topo == maximo - 1 retorna lista vazia caso contrario, inicia em um while enquando o atual não for nulo ou se a pilha estiver vazia, em outro while anda para esquerda o mais longe possivel ate o atual for nulo e é enpilhando os no na pilha, diminui o valor do topo e pega o elemento topo para formatação covertendo as folhas para toString ou "nulo" se for null e imprime os dado, dai passa o nó atual para a direita e recomeça o processo. Para buscar um elemento em buscar() possue um for para cada letra de morse em uma lista até achar o resultado, adicionando em uma lista e imprimido na tela quando terminado.

**menu:** Menu é iniciado quando o código é rodado possue um scanner para recereber os valores do terminal, digitando 1 para inserir, 2 para buscar, 3 para exibir a lista, 0 para sair
