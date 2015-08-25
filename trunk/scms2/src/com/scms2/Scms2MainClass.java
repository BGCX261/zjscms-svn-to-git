package com.scms2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;

/**
 * 项目主程序
 * @author Zhujing
 */
public class Scms2MainClass {
    public static void main(String... args) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                try {
                    UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Scms2MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scms2MainJFrame smj = new Scms2MainJFrame();
                smj.setLocationRelativeTo(null);
                smj.setVisible(true);
            }
        });
    }
}
