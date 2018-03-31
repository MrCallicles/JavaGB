//
//
// Utils.java
// Contient des fonctions utiles pour
// les calculs sur les registres
//
package JavaGB.cpu;

public class Utils{
    public static int setBit(int value,boolean input, int position){
        // Prend une valeur et modifie un bit à une position en particulier
        // le paramètre input prend true ou false, ce qui correspond à 1 ou 0
        if(input){
            return (value | 1 << position); //valeur ou 1 à la position x;
        }
        else
        {
            return (value & ~(1 << position)); //valeur et l'inverse de 1 à la position x;
        }
    }
}
