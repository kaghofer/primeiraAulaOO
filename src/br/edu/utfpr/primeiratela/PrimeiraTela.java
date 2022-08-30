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
      //  JFrame frame = new JFrame("Primeira Tela");;

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

        super.setLayout(new BorderLayout(5, 5));
        super.add(pnDados, BorderLayout.NORTH);
        super.add(apDados, BorderLayout.CENTER);
        super.add(pnBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> {

            //taDados.setText(getDados());
            new DlgDados(this, true);
        });

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 500);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

    }

    private String getGenero() {
        String genero = null;
        if (rbMasc.isSelected()) {
            genero = rbMasc.getActionCommand();
        } else if (rbFem.isSelected()) {
            genero = rbFem.getActionCommand();
        }
        return genero;
    }

    public String getLivros() {
        String livros = "";
        if (cbJava.isSelected()) {
            livros = cbJava.getActionCommand() + "\n";
        }
        if (cbDelphi.isSelected()) {
            livros += cbDelphi.getActionCommand() + "\n";
        }
        return livros;
    }

    public String getDados() {
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
