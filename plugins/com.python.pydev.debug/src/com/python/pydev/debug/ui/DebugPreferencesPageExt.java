/**
 * Copyright (c) 2005-2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Eclipse Public License (EPL).
 * Please see the license.txt included with this distribution for details.
 * Any modifications to this file must keep this entire header intact.
 */
package com.python.pydev.debug.ui;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.python.pydev.debug.ui.DebugPrefsPage;
import org.python.pydev.debug.ui.IDebugPreferencesPageParticipant;

import com.python.pydev.debug.DebugPluginPrefsInitializer;

public class DebugPreferencesPageExt implements IDebugPreferencesPageParticipant {

    public void createFieldEditors(DebugPrefsPage page, Composite parent) {
        page.addField(new IntegerFieldEditor(DebugPluginPrefsInitializer.PYDEV_REMOTE_DEBUGGER_PORT,
                "Port for remote debugger:", parent, 10));

        BooleanFieldEditor editor = new BooleanFieldEditor(DebugPluginPrefsInitializer.DEBUG_SERVER_ALWAYS_ON,
                "Remote debugger server always on?", BooleanFieldEditor.SEPARATE_LABEL, parent);
        page.addField(editor);
        editor.getLabelControl(parent)
                .setToolTipText(
                        "Checking this option will initialize the remote debugger on plugin activation and will restart it when it's stopped.");

        editor = new BooleanFieldEditor(DebugPluginPrefsInitializer.FORCE_SHOW_SHELL_ON_BREAKPOINT,
                "Force focus on Eclipse when hitting breakpoint?", BooleanFieldEditor.SEPARATE_LABEL, parent);
        page.addField(editor);
        editor.getLabelControl(parent)
                .setToolTipText(
                        "Checking this option will force Eclipse to have focus when a PyDev breakpoint is hit.");

    }

}
