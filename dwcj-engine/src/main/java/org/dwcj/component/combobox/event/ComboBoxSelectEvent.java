package org.dwcj.component.combobox.event;

import org.dwcj.component.ComponentEvent;
import org.dwcj.component.combobox.ComboBox;

public class ComboBoxSelectEvent implements ComponentEvent {
    private final ComboBox control;

    private Object key;

    public ComboBoxSelectEvent(ComboBox tComboBox) {
        this.control = tComboBox;
        this.key = control.getSelectedItem().getKey();
    }

    public void setKey(Object key) { this.key = key; }

    public Object getKey() { return key; }

    @Override
    public ComboBox getControl() { return control; }

}