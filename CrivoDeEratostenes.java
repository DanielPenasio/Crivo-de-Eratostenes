/*


https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes


*/
public class CrivoDeEratostenes {

    public static void main(String[] args) {
        //Define at� que n�mero ser� procurado os n�meros primos
        boolean[] primos = crivoEratostenes(100);
        mostrar(primos);
                 
    }

    private static void mostrar(boolean[] primos) {
        for (int i = 2; i < primos.length; i++) {
            //Se o n�mero for true imprime como primo.
        	if (primos[i]) {
                System.out.print(i+",");
            }
        }
    }

    private static boolean[] crivoEratostenes(int n) {
        int raiz; // Maior n�mero a ser checado. Corresponde a raiz quadrada do �ltimo n�mero da sequencia, arredondado pra baixo.
        raiz = (int)Math.floor(Math.sqrt(n));
        
        boolean[] primos = new boolean[n + 1];
        //Seta todos os n�meros como primos (true)
        for (int i = 2; i < n; i++) {
            primos[i] = true;
        }
        //Percorre o array procurando os primos(todo foram setados como true)
        for (int i = 2; i <= raiz; i++) {
            if (primos[i]) {
                //Se o �mero é true, é primo. 
                //Procura todos os m�ltiplos subsequente a ele e os exclui.
                for (int j = i; i * j <= n; j++) {
                    primos[i * j] = false;
                }
            }
        }
        return primos;
    }
}
