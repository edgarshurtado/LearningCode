/*
    Exercise description
*/

package edgarsanchezhurtadonumerosenlletra;

import java.io.*;
import static java.lang.Math.round;
import java.util.Random;

/**
 *
 * @author Edgar S. Hurtado
 */


public class EdgarSanchezHurtadoNumerosEnLletra {

    static int intImput(){
        //Function for allow keyboard integer inputs
        BufferedReader dataIn = new BufferedReader
                (new InputStreamReader(System.in));
        int tempInt = 0;
        boolean correctInput = false;
        while(!correctInput){
            try {
                tempInt = Integer.parseInt(dataIn.readLine());
                correctInput = true;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Bad input, try again");
            }
        }
        return tempInt;
    } 
    
    static int randomNumber(int maxNum){
        int randomNumber;
        
        Random randomGenerator = new Random();
        
        randomNumber = randomGenerator.nextInt(maxNum);
        
        return randomNumber;
    }
    
    static int digitUnitats(int q){
        int unitat;
        
        unitat = q % 10;
        
        return unitat;
    }
    
    static int digitDesenes(int q){
        int desenes;
        
        desenes = (q / 10) % 10;
        
        return desenes;
    }
    
    static int digitCentenes(int q){
        int centenes;
        
        centenes = q / 100;
        
        return centenes;
    }
    
    static String desenaEnLletres(int dig){
        String desena;
        
        switch (dig) {
            case 1:
                desena = "deu";
                break;
            case 2:
                desena = "vint";
                break;
            case 3:
                desena = "trenta";
                break;
            case 4:
                desena = "quaranta";
                break;
            case 5:
                desena = "cincuanta";
                break;
            case 6:
                desena = "seixanta";
                break;
            case 7:
                desena = "setanta";
                break;
            case 8:
                desena = "huitanta";
                break;
            case 9:
                desena = "noranta";
                break;
            case 0:
                desena = "";
                break;
            default:
                throw new AssertionError();
        }
        return desena;
    }
    
    static String digitEnLletres(int dig){
        
        String digit;
        
        switch (dig) {
            case 1:
                digit = "ú";
                break;
            case 2:
                digit = "dos";
                break;
            case 3:
                digit = "tres";
                break;
            case 4:
                digit = "quatre";
                break;
            case 5:
                digit = "cinq";
                break;
            case 6:
                digit = "sis";
                break;
            case 7:
                digit = "set";
                break;
            case 8:
                digit = "huit";
                break;
            case 9:
                digit = "nou";
                break;
            case 0:
                digit = "zero";
                break;
            case 10:
                digit = "deu";
                break;
            case 11:
                digit = "onze";
                break;
            case 12:
                digit = "dotze";
                break;
            case 13:
                digit = "tretze";
                break;
            case 14:
                digit = "catortze";
                break;
            case 15:
                digit = "quinze";
                break;
            case 16:
                digit = "setze";
                break;
            case 17:
                digit = "deset";
                break;
            case 18:
                digit = "dihuit";
                break;
            case 19:
                digit = "déneu";
                break;
            default:
                throw new AssertionError();
        }
        return digit;
    }
    
    static String deuDeneu(int q){
        String numero;
        
        switch (q) {
            case 0:
                numero = "deu";
                break;
            case 1:
                numero = "onze";
                break;
            case 2:
                numero = "dotze";
                break;
            case 3:
                numero = "tretze";
                break;
            case 4:
                numero = "catortze";
                break;
            case 5:
                numero = "quinze";
                break;
            case 6:
                numero = "setze";
                break;
            case 7:
                numero = "deset";
                break;
            case 8:
                numero = "dihuit";
                break;
            case 9:
                numero = "déneu";
                break;
            default:
                throw new AssertionError();
        }
        return numero;
    }
    
    static String tresDigitsEnLletres(int q3){
        
        String unitatsLletra;
        String desenesLletra;
        String centenesLletra;
        String numeroSencer;
        
        int unitatsNumero;
        int desenesNumero;
        int centenesNumero;
        
        //Construcció del nº en lletres
        if (q3 == 0) {
            numeroSencer = "zero";
        } else {
            //Descomposició del número
            unitatsNumero = digitUnitats(q3);
            desenesNumero = digitDesenes(q3);
            centenesNumero = digitCentenes(q3);
            numeroSencer = "";

            //Lògica de construcción de la cadena resultat.
            if (centenesNumero != 0) {
                if (centenesNumero == 1) {
                    numeroSencer += "cent ";
                } else {
                    numeroSencer += digitEnLletres(centenesNumero) + "-cents ";
                }
            }
            if (desenesNumero != 0) {
                if (desenesNumero == 1) {
                    numeroSencer += digitEnLletres(10 + unitatsNumero);
                } else {
                    numeroSencer += desenaEnLletres(desenesNumero);
                    if (unitatsNumero != 0) {
                        if (desenesNumero == 2) {
                            numeroSencer += "-i-";
                        } else {
                            numeroSencer += "-";
                        }
                        numeroSencer += digitEnLletres(unitatsNumero);
                    }
                }
            } else if (unitatsNumero != 0) {
                numeroSencer += digitEnLletres(unitatsNumero);
            }
        }
        return numeroSencer;
    }
    
    static String nouDigitsEnLletres(int q9){
        //Evitar la introducció de nº iguals o més grans de 10^9.
        if ((int) (q9 / (Math.pow(10, 9))) != 0) throw new IllegalArgumentException();
        
        int cents;
        int milers;
        int milions;
        String numeroSencer = "";
        
        if (q9 < 0){ //Per si es negatiu
            numeroSencer += "menys ";
            q9 *= -1; //Per evitar que se escriguen mes voltes la paraula menys
        } 
        //Descomposició del número
        cents = (int) (q9 % Math.pow(10, 3));
        milers =(int) ((q9 % Math.pow(10, 6)) / Math.pow(10, 3));
        milions = (int) (q9 / Math.pow(10, 6));
        
        //Creació de la cadena a retornar
        
        if (milions != 0) {
            if (milions == 1) {
                numeroSencer += "1 milió ";
            } else {
                numeroSencer += tresDigitsEnLletres(milions) + " milions ";
            }
        }
        
        if (milers != 0) {
            if (milers == 1) {
                numeroSencer += " mil ";
            } else {
            numeroSencer += tresDigitsEnLletres(milers) + " mil ";
            }
        }
        
        if (milions == 0 & milers == 0) {
            //evita escriure la paraula zero quan no cal
            numeroSencer += tresDigitsEnLletres(cents);
        } else if (cents != 0) {
            numeroSencer += tresDigitsEnLletres(cents);
        }
        return numeroSencer;
    }
    
    public static void main(String[] args) {
        int numero;
        //Generació de números aleatoris
        for (int i = 0; i < 10; i++) {
            numero = randomNumber(1000000000);
            System.out.println(numero + " " + nouDigitsEnLletres(numero));
        }
        //Introducció del nº per l'usuari.
        System.out.println("Introduix un número: ");
        numero = intImput();
        System.out.println(nouDigitsEnLletres(numero));       
    }

}
