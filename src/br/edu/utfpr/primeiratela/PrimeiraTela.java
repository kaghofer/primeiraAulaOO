package br.edu.utfpr.primeiratela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class PrimeiraTela extends JFrame {

    private JTextField txtNome;
    private JTextArea taDados;
    private JLabel lbLivros;
    private JCheckBox cbJava, cbDelphi;
    private JRadioButton rbMasc, rbFem;
    private JFormattedTextField ftCPF;

    public PrimeiraTela() {
        JFrame frame = new JFrame("Primeira Tela");

        JLabel lbNome = new JLabel("Nome");
        txtNome = new JTextField();
        txtNome.setColumns(10);
        JLabel lbGenero = new JLabel("Gênero");

        rbMasc = new JRadioButton("Masculino");
        rbFem = new JRadioButton("Feminino");

        ButtonGroup bgGenero = new ButtonGroup();
        bgGenero.add(rbFem);
        bgGenero.add(rbMasc);

        lbLivros = new JLabel("Livros");
        cbJava = new JCheckBox("Java");
        cbDelphi = new JCheckBox("Delphi");
        JLabel lbCpf = new JLabel("CPF");
        ftCPF = null;
        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            ftCPF = new JFormattedTextField(mf);
            ftCPF.setColumns(15);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());
        }
        Border blackline = BorderFactory.createLineBorder(Color.black);

        JPanel pnDados = new JPanel(new GridLayout(10, 1, 5, 5));

        pnDados.setBorder(blackline);

        pnDados.add(lbNome);
        pnDados.add(txtNome);
        pnDados.add(lbGenero);
        pnDados.add(rbMasc);
        pnDados.add(rbFem);
        pnDados.add(lbLivros);
        pnDados.add(cbJava);
        pnDados.add(cbDelphi);
        pnDados.add(lbCpf);
        pnDados.add(ftCPF);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        taDados = new JTextArea();
        JScrollPane apDados = new JScrollPane(taDados);

        JPanel pnBotoes = new JPanel();
        pnBotoes.add(btnSalvar);
        pnBotoes.add(btnCancelar);

        pnBotoes.setBackground(Color.gray);

        frame.setLayout(new BorderLayout(5, 5));
        frame.add(pnDados, BorderLayout.NORTH);
        frame.add(apDados, BorderLayout.CENTER);
        frame.add(pnBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> {
            StringBuilder str = new StringBuilder();
            str.append(txtNome.getText()).append("\n")
                    .append(sexo()).append("\n")
                    .append(livros()).append("\n")
                    .append(ftCPF.getText());
            taDados.setText(str.toString());
        });

         
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    
    public String sexo(){
        String result = null;
        if(rbMasc.isSelected())
        {
            result = rbMasc.getActionCommand();
        }else if(rbFem.isSelected())
        {
            result = rbFem.getActionCommand();
        }
        else
        {
            result = ""; 
        }
                
        return result;
    }
    
    public String livros()
    {
        String result = null;
        if(cbJava.isSelected())
        {
            result = cbJava.getActionCommand();
        }if(cbDelphi.isSelected())
        {
            result += "\n" + cbDelphi.getActionCommand();
        }
        
        return result;
    }
    public static void main(String[] args) {
        new PrimeiraTela();
    }
}
