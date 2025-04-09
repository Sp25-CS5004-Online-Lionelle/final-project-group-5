

import student.view.JFrameView;

public class TestJFrameView {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            
            JFrameView view = new JFrameView();
            view.setVisible(true);
        });
    }


}

