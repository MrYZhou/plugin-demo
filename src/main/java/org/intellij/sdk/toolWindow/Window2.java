package org.intellij.sdk.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.jcef.JBCefBrowser;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Window2 {

    JPanel main;
    private JButton button1;


    public Window2(ToolWindow toolWindow, Project project) {
        try {
            JPanel panel = new JPanel(new BorderLayout());
            JBCefBrowser jbCefBrowser = new JBCefBrowser();
            String path = System.getProperties().get("idea.system.path").toString().split("idea")[0];
            path += "resources/main/META-INF/2.html";
//            path = "https://www.baidu.com";
            jbCefBrowser.loadURL(path);
            panel.add(jbCefBrowser.getComponent());
            this.main = panel;

            button1.addActionListener(e -> init(project));

        } catch (Exception e) {

        }

    }

    public void init(@NotNull Project project) {
        MyNotifier.notifyError(project, "错误信息");

    }

    public JComponent getContent() {
        return this.main;
    }
}
