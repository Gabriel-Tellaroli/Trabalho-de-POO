package trabalhoDePO;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Calculo extends JFrame {

    ArrayList<Integer> valores = new ArrayList();
    ArrayList<String> operadores = new ArrayList();
    ArrayList<String> NumerosArmazenados = new ArrayList();
    String UltimoDadoDigitado;
    int resultado;
    int verificaOp = 0;
    int verificaNum = 1;


    public Calculo() {
    }

    public void Calcular(String valor) {
        try {
            if (!(valor.equals("="))) {
                if ((valor.equals("*") || valor.equals("+") || valor.equals("-") || valor.equals("/")) && verificaOp != 0) {
                    operadores.add(valor);
                    UltimoDadoDigitado = valor;
                    verificaOp = 0;
                    verificaNum = 1;
                } else {
                    if (verificaNum != 0) {
                        valores.add(Integer.parseInt(valor));
                        UltimoDadoDigitado = valor;
                        verificaOp = 1;
                        verificaNum = 0;
                    }else {
                        UltimoDadoDigitado = "";
                    }
                }
            } else {
                resultado = valores.get(0);
                int j = 0;
                for (int i = 1; i < valores.size(); i++) {
                    switch (operadores.get(j)) {
                        case "+":
                            resultado += valores.get(i);
                            j++;
                            break;
                        case "-":
                            resultado -= valores.get(i);
                            j++;
                            break;
                        case "/":
                            resultado /= valores.get(i);
                            j++;
                            break;
                        case "*":
                            resultado = valores.get(i) * resultado;
                            j++;
                            break;
                        default:
                            break;
                    }
                }
                UltimoDadoDigitado = " = " + Integer.toString(resultado) + " | " + Integer.toString(resultado);
            }
        }
        catch (Exception erro) {
            String message = "Valor Invalido!\n" + erro;
            JOptionPane.showMessageDialog(null, message);
            System.out.println(Integer.toString(verificaOp));
            UltimoDadoDigitado = "";
        }
    }

    public void Armazenar(String valor){
        NumerosArmazenados.add(valor);
    }
    
    /*public void Restaura(){
        Restaurar j = new Restaurar();
        for(String a : NumerosArmazenados){
            j.jComboBox1.addItem(a);
        }
    }*/

}
