// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class MyToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {


        MyToolWindow myToolWindow = new MyToolWindow(toolWindow, project);

        Window2 myToolWindow2 = new Window2(toolWindow, project);


        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(myToolWindow.getContent(), "apiMaster", false);
        Content content2 = contentFactory.createContent(myToolWindow2.getContent(), "jsonParser", false);

        toolWindow.getContentManager().addContent(content);
        toolWindow.getContentManager().addContent(content2);
    }

}
