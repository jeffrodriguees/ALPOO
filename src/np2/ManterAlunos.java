package np2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRootPane;

public class ManterAlunos implements ActionListener {
    JFrame jframe = new JFrame();

    JButton Consultar, Incluir, Alterar, Excluir, Cancelar, Sair, Salvar;

    JLabel cadastro, aluno, endereço, ra, nome, nomeCurso, dataMat, dataNasc,
            cidadeNasc, ufNasc, rua, setor, cidade,
            uF, cep, nomePai, nomeMae;

    JTextField txtRa, txtNome, txtCurso, txtDataMat, txtDataNasc,
            txtCidadeNatal, txtUfNatal, txtRua, txtSetor, txtCidade,
            txtCep, txtPai, txtMae;
    
    JComboBox combo1, combo = new JComboBox(new Object[]{""});
    
    private EAlunos eAlunos = null;
    private NAlunos nAlunos = new NAlunos();

    public void abrirJanela() throws ParseException {
                
        // Cria a Janela
        jframe.setTitle("CADASTRO DE ALUNOS");
        jframe.setLocation(50, 100);
        jframe.setSize(600, 600);
        jframe.setLayout(null);
        jframe.setUndecorated(false);
        jframe.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
        jframe.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));

        // Adiciona o Titulo
        cadastro = new JLabel();
        cadastro.setLocation(210, 10);
        cadastro.setSize(220, 15);
        cadastro.setFont(new Font("Sans Serif", Font.BOLD, 15));
        cadastro.setText("CADASTRO DE ALUNOS");

        aluno = new JLabel();
        aluno.setLocation(250, 90);
        aluno.setSize(150, 15);
        aluno.setFont(new Font("Sans Serif", Font.BOLD, 14));
        aluno.setText("DADOS ALUNO");

        ra = new JLabel();
        ra.setLocation(15, 115);
        ra.setSize(400, 20);
        ra.setText("R.A.: ");

        txtRa = new JTextField();
        txtRa.setLocation(90, 115);
        txtRa.setSize(100, 20);
        txtRa.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtRa.setEnabled(false);

        nome = new JLabel();
        nome.setLocation(15, 140);
        nome.setSize(100, 20);
        nome.setText("NOME: ");

        txtNome = new JTextField();
        txtNome.setLocation(90, 140);
        txtNome.setSize(400, 20);
        txtNome.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtNome.setEnabled(false);

        nomeCurso = new JLabel();
        nomeCurso.setLocation(15, 165);
        nomeCurso.setSize(100, 20);
        nomeCurso.setText("CURSO: ");

        txtCurso = new JTextField();
        txtCurso.setLocation(90, 165);
        txtCurso.setSize(400, 20);
        txtCurso.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtCurso.setEnabled(false);

        dataMat = new JLabel();
        dataMat.setLocation(15, 190);
        dataMat.setSize(150, 20);
        dataMat.setText("DATA MATRÍCULA: ");

        txtDataMat = new JTextField();
        txtDataMat.setLocation(125, 190);
        txtDataMat.setSize(120, 20);
        txtDataMat.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtDataMat.setEnabled(false);

        dataNasc = new JLabel();
        dataNasc.setLocation(250, 190);
        dataNasc.setSize(150, 20);
        dataNasc.setText("DATA NASCIMENTO: ");

        txtDataNasc = new JTextField();
        txtDataNasc.setLocation(370, 190);
        txtDataNasc.setSize(120, 20);
        txtDataNasc.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtDataNasc.setEnabled(false);

        cidadeNasc = new JLabel();
        cidadeNasc.setLocation(15, 215);
        cidadeNasc.setSize(150, 20);
        cidadeNasc.setText("CIDADE: ");

        txtCidadeNatal = new JTextField();
        txtCidadeNatal.setLocation(90, 215);
        txtCidadeNatal.setSize(300, 20);
        txtCidadeNatal.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtCidadeNatal.setEnabled(false);

        ufNasc = new JLabel();
        ufNasc.setLocation(410, 215);
        ufNasc.setSize(150, 20);
        ufNasc.setText("UF: ");

        /*UfNasc = new JTextField();
        UfNasc.setLocation(450, 215 );
        UfNasc.setSize(40, 20);
        UfNasc.setFont(new Font("Sans Serif", Font.BOLD, 12));
        UfNasc.setEnabled(false);*/
        combo = new JComboBox();
        combo.addItem(" ");
        combo.addItem("GO");
        combo.addItem("MG");
        combo.addItem("SP");
        combo.addItem("TO");
        combo.setLocation(435, 215);
        combo.setSize(55, 20);
        combo.setEnabled(false);

        nomePai = new JLabel();
        nomePai.setLocation(15, 240);
        nomePai.setSize(100, 20);
        nomePai.setText("NOME DO PAI: ");

        txtPai = new JTextField();
        txtPai.setLocation(100, 240);
        txtPai.setSize(390, 20);
        txtPai.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtPai.setEnabled(false);

        nomeMae = new JLabel();
        nomeMae.setLocation(15, 265);
        nomeMae.setSize(100, 20);
        nomeMae.setText("NOME DA MÃE: ");

        txtMae = new JTextField();
        txtMae.setLocation(100, 265);
        txtMae.setSize(390, 20);
        txtMae.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtMae.setEnabled(false);

        endereço = new JLabel();
        endereço.setLocation(250, 300);
        endereço.setSize(150, 20);
        endereço.setFont(new Font("Sans Serif", Font.BOLD, 14));
        endereço.setText("ENDEREÇO");

        rua = new JLabel();
        rua.setLocation(15, 340);
        rua.setSize(100, 20);
        rua.setText("RUA: ");

        txtRua = new JTextField();
        txtRua.setLocation(90, 340);
        txtRua.setSize(400, 20);
        txtRua.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtRua.setEnabled(false);

        setor = new JLabel();
        setor.setLocation(15, 365);
        setor.setSize(100, 20);
        setor.setText("SETOR: ");

        txtSetor = new JTextField();
        txtSetor.setLocation(90, 365);
        txtSetor.setSize(400, 20);
        txtSetor.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtSetor.setEnabled(false);

        cidade = new JLabel();
        cidade.setLocation(15, 390);
        cidade.setSize(100, 20);
        cidade.setText("CIDADE: ");

        txtCidade = new JTextField();
        txtCidade.setLocation(90, 390);
        txtCidade.setSize(300, 20);
        txtCidade.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtCidade.setEnabled(false);

        uF = new JLabel();
        uF.setLocation(410, 390);
        uF.setSize(150, 20);
        uF.setText("UF: ");

        /*UF = new JTextField();
        UF.setLocation(450, 390);
        UF.setSize(40, 20);
        UF.setFont(new Font("Sans Serif", Font.BOLD, 12));
        UF.setEnabled(false);*/
        combo1 = new JComboBox();
        combo1.addItem(" ");
        combo1.addItem("GO");
        combo1.addItem("MG");
        combo1.addItem("SP");
        combo1.addItem("TO");
        combo1.setLocation(435, 390);
        combo1.setSize(55, 20);
        combo1.setEnabled(false);

        cep = new JLabel();
        cep.setLocation(15, 415);
        cep.setSize(400, 20);
        cep.setText("CEP: ");

        txtCep = new JTextField();
        txtCep.setLocation(90, 415);
        txtCep.setSize(100, 20);
        txtCep.setFont(new Font("Sans Serif", Font.BOLD, 12));
        txtCep.setEnabled(false);

        Consultar = new JButton();
        Consultar.setText("CONSULTAR");
        Consultar.setSize(80, 25);
        Consultar.setLocation(40, 45);
        Consultar.setFont(new Font("Sans Serif", Font.BOLD, 11));
        Consultar.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.black));
        Consultar.setEnabled(true);
        Consultar.addActionListener(this);
        Consultar.setMnemonic(KeyEvent.VK_C); //ALT+C

        Incluir = new JButton();
        Incluir.setText("INCLUIR");
        Incluir.setSize(80, 25);
        Incluir.setLocation(125, 45);
        Incluir.setFont(new Font("Sans Serif", Font.BOLD, 11));
        Incluir.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.black));
        Incluir.setEnabled(true);
        Incluir.addActionListener(this);
        Incluir.setMnemonic(KeyEvent.VK_I); //ALT+I

        Alterar = new JButton();
        Alterar.setText("ALTERAR");
        Alterar.setSize(80, 25);
        Alterar.setLocation(210, 45);
        Alterar.setFont(new Font("Sans Serif", Font.BOLD, 11));
        Alterar.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.black));
        Alterar.setEnabled(true);
        Alterar.addActionListener(this);
        Alterar.setMnemonic(KeyEvent.VK_A); //ALT+A

        Excluir = new JButton();
        Excluir.setText("EXCLUIR");
        Excluir.setSize(80, 25);
        Excluir.setLocation(295, 45);
        Excluir.setFont(new Font("Sans Serif", Font.BOLD, 11));
        Excluir.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.black));
        Excluir.setEnabled(true);
        Excluir.addActionListener(this);
        Excluir.setMnemonic(KeyEvent.VK_E); //ALT+E

        Cancelar = new JButton();
        Cancelar.setText("CANCELAR");
        Cancelar.setSize(80, 25);
        Cancelar.setLocation(380, 45);
        Cancelar.setFont(new Font("Sans Serif", Font.BOLD, 11));
        Cancelar.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.black));
        Cancelar.setEnabled(true);
        Cancelar.addActionListener(this);
        Cancelar.setMnemonic(KeyEvent.VK_L); //ALT+L

        Sair = new JButton();
        Sair.setText("SAIR");
        Sair.setSize(80, 25);
        Sair.setLocation(465, 45);
        Sair.setFont(new Font("Sans Serif", Font.BOLD, 11));
        Sair.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.black));
        Sair.setEnabled(true);
        Sair.addActionListener(this);
        Sair.setMnemonic(KeyEvent.VK_S); //ALT+S

        Salvar = new JButton();
        Salvar.setText("SALVAR");
        Salvar.setSize(80, 25);
        Salvar.setLocation(250, 450);
        Salvar.setFont(new Font("Sans Serif", Font.BOLD, 11));
        Salvar.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.black));
        Salvar.setEnabled(true);
        Salvar.addActionListener(this);
        Salvar.setVisible(false);
        Salvar.setMnemonic(KeyEvent.VK_R); //ALT+R

        jframe.add(Consultar);
        jframe.add(combo1);
        jframe.add(combo);
        jframe.add(Incluir);
        jframe.add(Alterar);
        jframe.add(Excluir);
        jframe.add(Cancelar);
        jframe.add(Sair);
        jframe.add(Salvar);
        jframe.add(cadastro);
        jframe.add(aluno);
        jframe.add(ra);
        jframe.add(txtRa);
        jframe.add(nome);
        jframe.add(txtNome);
        jframe.add(nomeCurso);
        jframe.add(txtCurso);
        jframe.add(dataMat);
        jframe.add(txtDataMat);
        jframe.add(dataNasc);
        jframe.add(txtDataNasc);
        jframe.add(cidadeNasc);
        jframe.add(txtCidadeNatal);
        jframe.add(ufNasc);
        //jframe.add(UfNasc);
        jframe.add(nomePai);
        jframe.add(txtPai);
        jframe.add(nomeMae);
        jframe.add(txtMae);
        jframe.add(endereço);
        jframe.add(rua);
        jframe.add(txtRua);
        jframe.add(setor);
        jframe.add(txtSetor);
        jframe.add(cidade);
        jframe.add(txtCidade);
        jframe.add(uF);
        jframe.add(cep);
        jframe.add(txtCep);

        jframe.addWindowListener(new Janela());

        jframe.setVisible(true);
    }

    public void habilita() {
        txtRa.setEnabled(true);
        txtNome.setEnabled(true);
        txtCurso.setEnabled(true);
        txtDataMat.setEnabled(true);
        txtDataNasc.setEnabled(true);
        txtCidadeNatal.setEnabled(true);
        //UfNasc.setEnabled(true);
        txtRua.setEnabled(true);
        txtSetor.setEnabled(true);
        txtCidade.setEnabled(true);
        txtCep.setEnabled(true);
        txtPai.setEnabled(true);
        txtMae.setEnabled(true);
        Salvar.setVisible(true);
        combo1.setEnabled(true);
        combo.setEnabled(true);

    }

    public void desabilita() {
        txtRa.setEnabled(false);
        txtNome.setEnabled(false);
        txtCurso.setEnabled(false);
        txtDataMat.setEnabled(false);
        txtDataNasc.setEnabled(false);
        txtCidadeNatal.setEnabled(false);
        //UfNasc.setEnabled(false);
        txtRua.setEnabled(false);
        txtSetor.setEnabled(false);
        txtCidade.setEnabled(false);
        //UF.setEnabled(false);
        txtCep.setEnabled(false);
        txtPai.setEnabled(false);
        txtMae.setEnabled(false);
        Salvar.setVisible(false);
        combo1.setEnabled(false);
        combo.setEnabled(false);

    }

    public void dataMat() {
        Date data = null;
        String dataTexto = (txtDataMat.getText());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            format.setLenient(false);
            data = (Date) format.parse(dataTexto);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Data da Matrícula inválida, Tente novamente! ex:(dd/mm/aaaa)",
                    "AVISO",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

    }

    public void dataNasc() {
        Date data = null;
        String dataTexto = txtDataNasc.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            format.setLenient(false);
            data = (Date) format.parse(dataTexto);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null,
                    "Data de Nascimento inválida, Tente novamente! ex:(dd/mm/aaaa)",
                    "AVISO",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

    }
    
    public void incluir(){   
        
        eAlunos = new EAlunos();
        eAlunos.setRa(txtRa.getText());
        eAlunos.setNome(txtNome.getText());
        eAlunos.setCurso(txtCurso.getText());
         /*eAlunos.setDtMatricula(txtDataMat.getText());
       // eAlunos.setDtNascimento(txtDataNasc.getText());
       // eAlunos.setCidadeNatal(txtCidadeNatal.getText());
       // eAlunos.setUfNatal(combo.getText());
        eAlunos.setPai(txtPai.getText());
        eAlunos.setMae(txtMae.getText());
        eAlunos.setRua(txtRua.getText());
        eAlunos.setSetor(txtSetor.getText());
        eAlunos.setCidade(txtCidade.getText());*/
        
        nAlunos.incluir(eAlunos);
        
        
        
}

    public static void main(String[] args) throws ParseException {
        ManterAlunos manterAlunos = new ManterAlunos();
        manterAlunos.abrirJanela();

    }

    /**
     *
     * @param e
     */
    @Override
   public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == Sair) {
            System.exit(0);
        }
        if (e.getSource() == Salvar) {
            
            //dataMat();
            //dataNasc();
            incluir();
            //desabilita();
            /*JOptionPane.showMessageDialog(null, "RA: " + txtRa.getText() + "\n"
                    + "Nome: " + txtNome.getText() + "\n"
                    + "Curso: " + txtCurso.getText() + "\n"
                    + "Data de Matrícula: " + txtDataMat.getText() + "\n"
                    + "Data de Nascimento: " + txtDataNasc.getText() + "\n"
                    + "Cidade Natal: " + txtCidadeNatal.getText() + "\n"
                    + "Rua: " + txtRua.getText() + "\n"
                    + "Setor: " + txtSetor.getText() + "\n"
                    + "Cidade: " + txtCidade.getText() + "\n"
                    + "Cep: " + txtCep.getText());
        }   catch (SQLException ex) {
                Logger.getLogger(ManterAlunos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManterAlunos.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }

        if (e.getSource() == Consultar) {
        }
        if (e.getSource() == Incluir) {
            habilita();

        }

        if (e.getSource() == Alterar) {
            habilita();
            txtRa.setEnabled(false);
        }
        if (e.getSource() == Excluir) {

        }
        if (e.getSource() == Cancelar) {
            txtRa.setText("");
            txtNome.setText("");
            txtCurso.setText("");
            txtDataMat.setText("");
            txtDataNasc.setText("");
            txtCidadeNatal.setText("");
            //UfNasc.setText("");
            txtRua.setText("");
            txtSetor.setText("");
            txtCidade.setText("");
            //UF.setText("");
            txtCep.setText("");
            txtPai.setText("");
            txtMae.setText("");
            Salvar.setVisible(false);
            combo1.setEnabled(false);
            combo.setEnabled(false);

        }

    }
    
    }
