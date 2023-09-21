
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame {
    private final PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
//      render frame and add title
        super("Password Generator");

//      set the size of the GUI
        setSize(540, 570);

//        prevent gUI from being able to resized
        setResizable(false);

//        we  will set layout to be null to have control over the position and size of our component
        setLayout(null);

//        terminate the program when the GUI is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        center the GUI to the screen
        setLocationRelativeTo(null);

//        init password generator
        passwordGenerator = new PasswordGenerator();
//        GUI components
        addComponents();
    }
    private void addComponents(){
//        create title text
        JLabel titleLabel = new JLabel("Password Generator");

//        set font size and ,ake it bold
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

//        center the text to the screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

//        set x, y coordinates and width/height value
        titleLabel.setBounds(0, 10, 540, 39);

//        add to GUI
        add(titleLabel);

//        create result text area


        JTextArea PasswordOutput = new JTextArea();
        PasswordOutput.setFont(new Font("Dialog", Font.PLAIN, 32));
        PasswordOutput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PasswordOutput.setBounds(25, 97, 479, 70);
        add(PasswordOutput);

//        prevent editing the text area
        PasswordOutput.setEditable(false);
        PasswordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

//        add Scrollability in case become too big
//        JScrollPane PasswordOutputPane = new JScrollPane();
//        PasswordOutputPane.setBounds(25, 97, 479, 70);

//        create a black border around the text area
//        PasswordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        add(PasswordOutputPane);

//        create password length label
        JLabel passLengthLable = new JLabel("Password Length");
        passLengthLable.setFont(new Font("Dialog", Font.PLAIN, 32));
        passLengthLable.setBounds(25, 215, 272, 39);
        add(passLengthLable);

//        create password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310, 215, 192, 39);
        add(passwordLengthInputArea);

//        create toggle buttons
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
         uppercaseToggle.setBounds(25, 302, 225, 56);
         add(uppercaseToggle);

//         lowercase letter toggle
        JToggleButton lowercaseToggle =  new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282, 302, 225, 56);
        add(lowercaseToggle);

//        number toggle
        JToggleButton numberToggle = new JToggleButton("Numbers");
        numberToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numberToggle.setBounds(25, 373, 225, 56);
        add(numberToggle);

//        sysbols Toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);

//        create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                  validation: generate a password only when length > 0 and one of the toggle is pressed
                if (passwordLengthInputArea.getText().length() == 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                                            uppercaseToggle.isSelected() ||
                                            numberToggle.isSelected() ||
                                            symbolsToggle.isSelected();

//                generate password
//                converts the text to an integer value
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if(anyToggleSelected){
                    String generatePassword = passwordGenerator.generatePassword(passwordLength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numberToggle.isSelected(),
                            symbolsToggle.isSelected());

//                    display password back to the user
                    PasswordOutput.setText(generatePassword);
                }
            }
        });
        add(generateButton);

    }
}
