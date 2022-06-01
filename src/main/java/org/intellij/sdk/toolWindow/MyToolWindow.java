// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MyToolWindow {

    private JButton click;
    private JButton hideToolWindowButton;
    private JPanel myToolWindowContent;
    private JButton textBtn;


    public MyToolWindow(ToolWindow toolWindow, @NotNull Project project) {
        hideToolWindowButton.addActionListener(e -> toolWindow.hide(null));
        click.addActionListener(e -> init(project));
        textBtn.addActionListener(e -> textDo(project));
        this.beforeCreate(project);
    }

    public void beforeCreate(@NotNull Project project) {

    }

    public void init(@NotNull Project project) {
        SampleDialogWrapper dialog = new SampleDialogWrapper("文件选择器");
        if (dialog.showAndGet()) {
//          文件选择
            FileChooserDescriptor fileChooserDescriptor = new FileChooserDescriptor(true, false, false, false, false, false);
            VirtualFile[] virtualFiles = FileChooser.chooseFiles(fileChooserDescriptor, project, null);
            System.out.println(virtualFiles);

        } else {

            MyNotifier.notifyError(project, "错误信息");
        }

    }

    public void textDo(@NotNull Project project) {
        SampleDialogWrapper dialog = new SampleDialogWrapper("信息输入");
        if (dialog.showAndGet()) {
            String text = dialog.getEditorTextField().getText();
            System.out.println(text);

        }

    }


    public JPanel getContent() {
        return myToolWindowContent;
    }

}
