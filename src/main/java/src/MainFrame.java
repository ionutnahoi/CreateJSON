package src;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class MainFrame extends JFrame {
    private JTextField textDbURL;
    private JTextField textApiKey;
    private JTextField textWifiName;
    private JTextField textWifiPassword;
    private JTextField textEmail;
    private JTextField textPassword;
    private JButton submitButton;
    private JPanel mainPannel;


    public MainFrame() {
        setTitle("JSON Creater");
        setSize(700, 500);

        setVisible(true);
        setContentPane(mainPannel);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("DbUrl", textDbURL.getText());
                jsonObject.put("ApiKey", textApiKey.getText());
                jsonObject.put("WiFiName", textWifiName.getText());
                jsonObject.put("WiFiPassword", textWifiPassword.getText());
                jsonObject.put("Email", textEmail.getText());
                jsonObject.put("AccountPassword", textPassword.getText());
                try {
                    FileWriter file = new FileWriter("./output.json");
                    file.write(jsonObject.toJSONString());
                    file.close();
                } catch (IOException err) {
                    // TODO Auto-generated catch block
                    err.printStackTrace();
                }
                System.out.println("JSON file created: " + jsonObject);
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }

}
