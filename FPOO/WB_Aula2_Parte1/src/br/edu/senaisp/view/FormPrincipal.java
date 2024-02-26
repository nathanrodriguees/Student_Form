package br.edu.senaisp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.edu.senaisp.dao.AlunoDAO;
import br.edu.senaisp.model.Aluno;

public class FormPrincipal extends JFrame {

	private JButton btnNovo = new JButton("Novo");
	private JLabel lblLista = new JLabel("Lista de Alunos:");
	private JTextArea txtLista = new JTextArea();

	private List<Aluno> alunos = new ArrayList<Aluno>();

	public FormPrincipal() {
		inicializar();
		acoes();

		AlunoDAO dao = new AlunoDAO();
		alunos = dao.lerAlunos();

		preencherAlunos();
	}

	private void inicializar() {
		this.setLayout(null);
		this.btnNovo.setBounds(50, 30, 150, 20);
		this.lblLista.setBounds(50, 70, 300, 20);
		this.txtLista.setBounds(50, 90, 500, 160);

		this.getContentPane().add(btnNovo);
		this.getContentPane().add(lblLista);
		this.getContentPane().add(txtLista);

		this.setSize(800, 600);
		this.setVisible(true);
	}

	private void acoes() {
		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FormDetAluno frm = new FormDetAluno();
				frm.show();

				Aluno tmp = frm.getAluno();
				if (tmp != null) {
					alunos.add(tmp);
					AlunoDAO dao = new AlunoDAO();
					try {
						dao.gravarAlunos(alunos);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(frm, e2.getMessage());
					}
				}

				preencherAlunos();

			}
		});
	}

	private void preencherAlunos() {
		txtLista.setText("");
		for (Aluno aluno : alunos) {
			txtLista.append(aluno.getNome() + " [" + aluno.getCpf() + "]");
			txtLista.append("\n");
		}
	}
}
