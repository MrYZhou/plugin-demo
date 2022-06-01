package org.intellij.sdk.toolWindow;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class SampleDialogWrapper extends DialogWrapper {
    String showText = "";
    EditorTextField editorTextField;

    public SampleDialogWrapper(String showText) {
        super(true); // use current window as parent
        setTitle("提示对话框");
        this.showText = showText;
        init();
    }

    public SampleDialogWrapper(String title, String showText) {
        super(true); // use current window as parent
        setTitle(title);
        this.showText = showText;
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(getShowText());
        label.setPreferredSize(new Dimension(100, 100));
        dialogPanel.add(label, BorderLayout.CENTER);
        EditorTextField editorTextField = new EditorTextField();
        dialogPanel.add(editorTextField, BorderLayout.SOUTH);


        this.editorTextField = editorTextField;
//        dialogPanel.add(new JBCefBrowser("https://www.jetbrains.com").getComponent());
        return dialogPanel;
    }

    public String getShowText() {
        return showText;
    }

    public EditorTextField getEditorTextField() {
        return editorTextField;
    }

    public void setEditorTextField(EditorTextField editorTextField) {
        this.editorTextField = editorTextField;
    }
}