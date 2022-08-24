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

public class PrimeiraTela extends JFrame{

    private JTextField txtNome;
    private JTextArea taDados;

    public PrimeiraTela() {
        JFrame frame = new JFrame("Primeira Tela");

        JLabel lbNome = new JLabel("Nome");
        txtNome = new JTextField();
        txtNome.setColumns(10);
        JLabel lbGenero = new JLabel("Gênero");

        JRadioButton rbMasc = new JRadioButton("Masculino");
        JRadioButton rbFem = new JRadioButton("Feminino");

        ButtonGroup bgGenero = new ButtonGroup();
        bgGenero.add(rbFem);
        bgGenero.add(rbMasc);

        JLabel lbLivros = new JLabel("Livros");
        JCheckBox cbJava = new JCheckBox("Java");
        JCheckBox cbDelphi = new JCheckBox("Delphi");
        JLabel lbCpf = new JLabel("CPF");
        JFormattedTextField ftCPF = null;
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

            taDados.setText(txtNome.getText());
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new PrimeiraTela();
    }
}
