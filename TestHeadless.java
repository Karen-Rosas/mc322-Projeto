// TestHeadless.java
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane; // Adicionado para um teste visual, se não for headless

public class TestHeadless {
    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("O ambiente Java está em modo headless. GUIs não podem ser exibidas.");
        } else {
            System.out.println("O ambiente Java NÃO está em modo headless. GUIs DEVEM ser exibidas.");
            // Tenta exibir uma janela Swing simples para confirmar
            try {
                JOptionPane.showMessageDialog(null, "Olá do Swing! Se você vê esta caixa, a GUI está funcionando.");
            } catch (java.awt.HeadlessException e) {
                System.out.println("Erro inesperado ao tentar exibir JOptionPane, mas isHeadless() retornou false.");
                e.printStackTrace();
            }
        }
    }
}