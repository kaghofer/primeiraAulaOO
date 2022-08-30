package br.edu.utfpr.primeiratela;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author kagho
 */
public class DlgDados extends JDialog {

    private JTextArea taSaida;
    private JButton btFechar;

    public DlgDados(PrimeiraTela tela, boolean modal) {
        super(tela, modal);
        super.setTitle("Dados");

        taSaida = new JTextArea();
        JScrollPane spDados = new JScrollPane(taSaida);

        btFechar = new JButton("Fechar");
        JPanel pnBotoes = new JPanel();
        pnBotoes.add(btFechar);

        this.add(spDados, BorderLayout.CENTER);
        this.add(pnBotoes, BorderLayout.SOUTH);

        taSaida.setText(tela.getDados());
        btFechar.addActionListener(e -> dispose());
        super.setSize(400, 300);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

    }

}
