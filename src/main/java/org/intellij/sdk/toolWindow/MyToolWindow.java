// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MyToolWindow {

    private JButton click;
    private JButton hideToolWindowButton;
    private JPanel myToolWindowContent;


    public MyToolWindow(ToolWindow toolWindow, @NotNull Project project) {
        hideToolWindowButton.addActionListener(e -> toolWindow.hide(null));
        click.addActionListener(e -> init(project));

//        this.init();
    }

    public void init(@NotNull Project project) {
        if (new SampleDialogWrapper().showAndGet()) {
            System.out.println("确定");

        } else {
            MyNotifier.notifyError(project, "错误信息");
        }

    }

    public JPanel getContent() {
        return myToolWindowContent;
    }

}
