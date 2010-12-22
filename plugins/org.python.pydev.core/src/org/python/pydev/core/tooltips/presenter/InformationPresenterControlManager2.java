package org.python.pydev.core.tooltips.presenter;

import org.eclipse.jface.text.AbstractHoverInformationControlManager;
import org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;


/**
 * This class is an attempt to have an information control that has a replacer, but it doesn't work because the 
 * methods to do the replace are 'default' methods (and not public ones), as are the replacers we'd need, so,
 * unfortunately, there's no API to make it work for now (so, this class is currently useless, but kept
 * so that this attempt is remembered).
 */
public class InformationPresenterControlManager2 extends AbstractHoverInformationControlManager implements IInformationPresenterControlManager{

    public InformationPresenterControlManager2(IInformationPresenter presenter) {
        super(new InformationPresenterHelpers.TooltipInformationControlCreator(presenter));
        if(presenter instanceof IInformationPresenterAsTooltip){
            IInformationPresenterAsTooltip presenterAsTooltip = (IInformationPresenterAsTooltip) presenter;
            presenterAsTooltip.setInformationPresenterControlManager(this);
        }
    }



    private Control fControl;
    private ITooltipInformationProvider fProvider;

    public void setInformationProvider(ITooltipInformationProvider provider) {
        this.fProvider = provider;
    }

    /*
     * @see IInformationPresenter#getInformationProvider(String)
     */
    public ITooltipInformationProvider getInformationProvider() {
        return fProvider;
    }

    /*
     * @see AbstractInformationControlManager#computeInformation()
     */
    protected void computeInformation() {
        if (fProvider == null)
            return;

        Object info = fProvider.getInformation(this.fControl);
        Point point = fProvider.getPosition(this.fControl);
        //the width and height are later calculated base on the size of the information to be shown.
        setInformation(info, new Rectangle(point.x, point.y, 0, 0));
    }
    
    
    @Override
    public void hideInformationControl() {
        super.hideInformationControl();
    }

}
