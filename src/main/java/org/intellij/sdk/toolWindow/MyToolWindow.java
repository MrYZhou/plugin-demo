// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

public class MyToolWindow {

    private JButton click;
    private JButton hideToolWindowButton;
    private JPanel myToolWindowContent;


    public MyToolWindow(ToolWindow toolWindow) {
        hideToolWindowButton.addActionListener(e -> toolWindow.hide(null));
        click.addActionListener(e -> init());
//        this.init();
    }

    public void init() {
        if (new SampleDialogWrapper().showAndGet()) {
            System.out.println("确定");
        } else {
            System.out.println("取消");
        }

    }

    public JPanel getContent() {
        return myToolWindowContent;
    }

}
