import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Etapa 1: interfaz basica y operaciones simples (suma, resta, multiplicacion)
public class Calculadora extends JFrame implements ActionListener {

    // campos para los numeros
    JTextField campo1;
    JTextField campo2;

    // etiqueta para mostrar el resultado
    JLabel resultado;

    // botones
    JButton botonSumar;
    JButton botonRestar;
    JButton botonMultiplicar;

    public Calculadora() {
        setTitle("Calculadora - Etapa 1");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("Operaciones basicas");
        titulo.setBounds(120, 10, 200, 25);
        add(titulo);

        JLabel l1 = new JLabel("Numero 1:");
        l1.setBounds(20, 50, 80, 25);
        add(l1);

        campo1 = new JTextField();
        campo1.setBounds(110, 50, 250, 25);
        add(campo1);

        JLabel l2 = new JLabel("Numero 2:");
        l2.setBounds(20, 85, 80, 25);
        add(l2);

        campo2 = new JTextField();
        campo2.setBounds(110, 85, 250, 25);
        add(campo2);

        botonSumar = new JButton("Sumar");
        botonSumar.setBounds(20, 130, 100, 30);
        add(botonSumar);

        botonRestar = new JButton("Restar");
        botonRestar.setBounds(140, 130, 100, 30);
        add(botonRestar);

        botonMultiplicar = new JButton("Multiplicar");
        botonMultiplicar.setBounds(260, 130, 100, 30);
        add(botonMultiplicar);

        resultado = new JLabel("Resultado: ");
        resultado.setBounds(20, 180, 340, 25);
        add(resultado);

        botonSumar.addActionListener(this);
        botonRestar.addActionListener(this);
        botonMultiplicar.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // validar campos vacios
        if (campo1.getText().equals("") || campo2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debes llenar los dos campos");
            return;
        }

        double num1;
        double num2;
        try {
            num1 = Double.parseDouble(campo1.getText());
            num2 = Double.parseDouble(campo2.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Solo se permiten numeros");
            return;
        }

        double res = 0;
        if (e.getSource() == botonSumar) {
            res = num1 + num2;
        } else if (e.getSource() == botonRestar) {
            res = num1 - num2;
        } else if (e.getSource() == botonMultiplicar) {
            res = num1 * num2;
        }

        resultado.setText("Resultado: " + res);
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
