package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;
//    private JTextField husyField;
//    private JTextField kraliciField;
    private JSpinner husyField;
    private JSpinner kraliciField;
    private SpinnerNumberModel husyModel;
    private SpinnerNumberModel kraliciModel;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;

    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání

        //husyField = new JTextField();
        husyModel = new SpinnerNumberModel(0,0,null,1);
        husyField = new JSpinner(husyModel);
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        //husyField.setHorizontalAlignment(JTextFielder.TRAILING);
        add(husyLabel);
        add(husyField);

        //kraliciField = new JTextField();
        kraliciModel = new SpinnerNumberModel(0,0,null,1);
        kraliciField = new JSpinner(kraliciModel);
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        //kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        add(kraliciLabel);
        add(kraliciField);

        add(createButtonBar(), "center, span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField.setEditable(false);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField.setEditable(false);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        add(pocetNohouLabel);
        add(pocetNohouField);

        pack();

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

    private void handleVypocitat(ActionEvent actionEvent) {
//        System.out.println("Počítám");
//        int pocetHus = Integer.parseInt(husyField.getText());
//        int pocetKraliku = Integer.parseInt(kraliciField.getText());
        int pocetHus = (Integer)husyField.getValue();
        int pocetKraliku = (Integer)kraliciField.getValue();
        int pocetHlav = pocetHus + pocetKraliku;
        int pocetNohou = pocetHus*2 + pocetKraliku*4;
        String pocetHlavVypis = Integer.toString(pocetHlav);
        String pocetNohouVypis = Integer.toString(pocetNohou);
        pocetHlavField.setText(pocetHlavVypis);
        pocetNohouField.setText(pocetNohouVypis);
    }
}
