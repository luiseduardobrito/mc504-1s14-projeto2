Problema dos filósofos famintos
===================

Nomes:
<br>
Danilo Perina Mendes - 135434
<br>
Luis Eduardo Brito - 138760


===================

<b>Descrição</b>: Resolução do problema multithread clássico denominado "Filósofos Famintos". O problema está explicado no livro "The Little Book on Semaphores", de Allen B. Downey.
<br>
<br>
<b>Solução:</b>A solução elaborada pela dupla, em Java, consiste em utilizar a biblioteca java.util.concurrent.locks e em especial a interface pública Lock. Ela permite utilizar os métodos lock() e unlock() sobre todos os garfos, de modo que nenhum garfo será utilizado por dois filósofos ao mesmo tempo. Além disso, eles possuem uma  Para melhor teste da solução, o tempo que os filósofos levam para pensar e comer é aleatório e o número de filósofos pode ser mudado através da variável NUM_PHILOSOPHERS, da classe Application.
<br>
A interface de visualização foi feita utilizando as bibliotecas de java JFrame e JLabel.






