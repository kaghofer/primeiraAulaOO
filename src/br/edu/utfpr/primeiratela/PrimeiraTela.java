package br.edu.utfpr.primeiratela;

import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class PrimeiraTela {
    
    public PrimeiraTela(){
        JFrame frame = new JFrame("Primeira Tela");
        
        JLabel lbNome = new JLabel("Nome");
        JTextField txtNome = new JTextField();
        txtNome.setColumns(10);
        JLabel lbGenero = new JLabel("Gênero");
        
        JRadioButton rbMasc = new JRadioButton("Masculino");
        JRadioButton rbFem = new JRadioButton("Feminino");
        
        ButtonGroup bgGenero = new  ButtonGroup();
        bgGenero.add(rbFem);
        bgGenero.add(rbMasc);
        
        JLabel lbLivros =  new JLabel("Livros");
        JCheckBox cbJava = new JCheckBox("Java");
        JCheckBox cbDelphi = new JCheckBox("Delphi");
        JLabel lbCpf = new JLabel("CPF");
        JFormattedTextField ftCPF=null;
        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            ftCPF = new JFormattedTextField(mf);
            ftCPF.setColumns(15);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());
        }
        
        
        
        
        JPanel pnDados = new JPanel();
        
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
        
        
        frame.add(pnDados);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        PrimeiraTela primeiraTela = new PrimeiraTela();
    }
}
