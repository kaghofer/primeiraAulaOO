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

public class PrimeiraTela {

    private JTextField txtNome;
    private JTextArea taDados;
    private final JButton btnSalvar;
    private final JButton btnCancelar;
    private final JScrollPane apDados;
    private JLabel lbNome;
    private JCheckBox cbJava;
    private JCheckBox cbDelphi;
    private JLabel lbGenero;
    private JRadioButton rbMasc;
    private JRadioButton rbFem;
    private ButtonGroup bgGenero;
    private JLabel lbLivros;
    private JLabel lbCpf;
    private JFormattedTextField ftCPF;
    
    public PrimeiraTela() {
        JFrame frame = new JFrame("Primeira Tela");

        lbNome = new JLabel("Nome");
        txtNome = new JTextField();
        txtNome.setColumns(10);
        lbGenero = new JLabel("Gênero");

        rbMasc = new JRadioButton("Masculino");
        rbFem = new JRadioButton("Feminino");

        bgGenero = new ButtonGroup();
        bgGenero.add(rbFem);
        bgGenero.add(rbMasc);

        lbLivros = new JLabel("Livros");
        cbJava = new JCheckBox("Java");
        cbDelphi = new JCheckBox("Delphi");
        lbCpf = new JLabel("CPF");
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

        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        taDados = new JTextArea();
        apDados = new JScrollPane(taDados);

        JPanel pnBotoes = new JPanel();
        pnBotoes.add(btnSalvar);
        pnBotoes.add(btnCancelar);

        pnBotoes.setBackground(Color.darkGray);

        frame.setLayout(new BorderLayout(5, 5));
        frame.add(pnDados, BorderLayout.NORTH);
        frame.add(apDados, BorderLayout.CENTER);
        frame.add(pnBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> {
            taDados.setText(getDados());
        });
        
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    
    private String getGenero(){
        String genero = null;
        if(rbMasc.isSelected())
        {
            genero = rbMasc.getActionCommand();
        }else if(rbFem.isSelected())
        {
            genero = rbFem.getActionCommand();
        }
        return genero;
    }
    
    public String getLivros()
    {
        String livros = "";
        if(cbJava.isSelected())
        {
            livros = cbJava.getActionCommand() + "\n";
        }if(cbDelphi.isSelected())
        {
            livros+=cbDelphi.getActionCommand() + "\n";
        }
        return livros;
    }

    private String getDados()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(txtNome.getText()).append("\n")
                .append(getGenero()).append("\n")
                .append(getLivros())
                .append(ftCPF.getText());
        return sb.toString();        
    }
    
    public static void main(String[] args) {
        new PrimeiraTela();
    }
}
