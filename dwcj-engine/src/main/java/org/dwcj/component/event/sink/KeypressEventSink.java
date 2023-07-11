package org.dwcj.component.event.sink;

import com.basis.bbj.proxies.event.BBjAbstractTextKeypressEvent;
import com.basis.bbj.proxies.event.BBjEvent;
import com.basis.bbj.proxyif.SysGuiEventConstants;
import java.util.HashMap;
import org.dwcj.component.AbstractDwcComponent;
import org.dwcj.component.event.EventDispatcher;
import org.dwcj.component.event.KeypressEvent;
import org.dwcj.component.field.DwcjFieldComponent;

/**
 * An abstract class of a keypress event sink which would handle a BBjKeypressEvent and dispatch the
 * corresponding Java event.
 */
public class KeypressEventSink extends AbstractEventSink {

  public KeypressEventSink(AbstractDwcComponent component, EventDispatcher dispatcher) {
    super(component, dispatcher,
        component instanceof DwcjFieldComponent ? SysGuiEventConstants.ON_EDIT_KEYPRESS
            : SysGuiEventConstants.ON_INPUT_KEYPRESS);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleEvent(BBjEvent ev) {
    HashMap<String, Object> map = new HashMap<>();
    BBjAbstractTextKeypressEvent event = (BBjAbstractTextKeypressEvent) ev;

    map.put("keyCode", event.getKeyCode());
    map.put("altKey", event.isAltDown());
    map.put("cmdKey", event.isCmdDown());
    map.put("controlKey", event.isControlDown());
    map.put("shiftKey", event.isShiftDown());

    KeypressEvent dwcEv = new KeypressEvent(this.getComponent(), map);
    this.getEventDispatcher().dispatchEvent(dwcEv);
  }
}