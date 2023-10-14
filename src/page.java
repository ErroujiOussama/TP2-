import javax.swing.*;
import java.awt.*;

public class page extends JFrame {
    JTextField tache;
    JTextArea contenu;
    JCheckBox urgence;
    JComboBox<String> type;
    ButtonGroup buttonGroup ;
    JRadioButton basseRadioButton ;
    JRadioButton moyenneRadioButton ;
    JRadioButton hauteRadioButton ;
    JButton enregistrer;
    DataSaving dataSaving = new DataSaving();
    public page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        tache = new JTextField(20);
        contenu = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(contenu);
        urgence = new JCheckBox("Urgente");
        type = new JComboBox<>(new String[]{"Travail","para-scolaire", "sport", "autre"});
        buttonGroup = new ButtonGroup();
        basseRadioButton = new JRadioButton("Basse");
        moyenneRadioButton = new JRadioButton("Moyenne");
        hauteRadioButton = new JRadioButton("Haute");
        buttonGroup.add(basseRadioButton);
        buttonGroup.add(moyenneRadioButton);
        buttonGroup.add(hauteRadioButton);
        enregistrer= new JButton("Enregistrer");

        //Panel:
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Tâche: "));
        panel.add(tache);
        panel.add(new JLabel("Contenu: "));
        panel.add(scrollPane);
        panel.add(new JLabel("Urgente: "));
        panel.add(urgence);
        panel.add(new JLabel("Type: "));
        panel.add(type);
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3, 1));
        radioPanel.add(new JLabel("Niveau de priorité: "));
        radioPanel.add(basseRadioButton);
        radioPanel.add(moyenneRadioButton);
        radioPanel.add(hauteRadioButton);
        panel.add(radioPanel);
        panel.add(enregistrer);
        enregistrer.addActionListener(e -> Message_dialog());

        this.add(panel);
        this.setVisible(true);
    }

    //Message dialog
    void Message_dialog(){
        String Tache = tache.getText();
        String Contenu = contenu.getText();
        String Priorite = "";
        if (basseRadioButton.isSelected()) {
            Priorite = "Basse";
        } else if (moyenneRadioButton.isSelected()) {
            Priorite = "Moyenne";
        } else if (hauteRadioButton.isSelected()) {
            Priorite = "Haute";
        }
        boolean estUrgente = urgence.isSelected();
        String Type = (String) type.getSelectedItem();

        String message = "Tâche: " + Tache +
                "\nContenu: " + Contenu +
                "\nUrgente: " + (estUrgente ? "Oui" : "Non") +
                "\nType: " + Type+
                "\nPriorité: " + Priorite ;
        //save data in the file:
        String html_data = "\n<table><tr><th>Tâche</th><td>"+Tache+"</td></tr><tr><th>Contenu</th><td>"+Contenu+"</td></tr><tr><th>Urgente</th><td>"+(estUrgente ? "Oui" : "Non")+"</td></tr><tr><th>Type</th><td>"+Type+"</td></tr><tr><th>Priorité</th><td>"+Priorite+"</td></tr></table>";
        dataSaving.save(html_data);
        JOptionPane.showMessageDialog(page.this, message, "Note energistrée",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
  