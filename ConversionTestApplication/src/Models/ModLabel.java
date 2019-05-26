
package Models;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ModLabel {

    private int _FontSize = 8;
    private String _FontName = "Arial";
    private double _PercentWidth = 0;
    private double _MaxWidth = -1;
    private double _MaxHeight = -1;
    private double _MinWidth = -1;
    private double _MinHeight = -1;
    private Label _GenericLabel = new Label();
    private boolean _AutoResize = true;
    private double _ParentWidth = 0;

    private String styleSheet[] = {"", ""};

    //=====================Constructors===============================//
    public ModLabel(Stage parent) {
        _PercentWidth = (((_GenericLabel.getText().length()) * _FontSize) / parent.getWidth());
        _GenericLabel.setPrefWidth(parent.getWidth() * _PercentWidth);
        _GenericLabel.setFont(new Font(_FontName, _GetMaxFontSize(parent.getWidth()) - 5));
        _GenericLabel.autosize();

        parent.heightProperty().addListener(e -> {
        });

        parent.widthProperty().addListener(e -> {
            _ParentWidth = (parent.getWidth());
            if (_AutoResize) {
                _ResizeEvent(_ParentWidth);
            }

        });

    }

    public ModLabel(Stage parent, String text) {
        _ParentWidth = parent.getWidth();
        setText(text);
        _PercentWidth = ((_GenericLabel.getText().length() * _FontSize) / parent.getWidth());
        _GenericLabel.setPrefWidth(parent.getWidth() * _PercentWidth);
        _GenericLabel.autosize();

        parent.heightProperty().addListener(e -> {

        });

        parent.widthProperty().addListener(e -> {
            _ParentWidth = (parent.getWidth());
            if (_AutoResize) {
                _ResizeEvent(_ParentWidth);
            }

        });
    }
    //=====================<End> Constructors===============================//

    //=====================Private Methods===============================//
    private int _GetMaxFontSize(double parentWidth) {
        int returnValue = 0;
        int width;
        returnValue
                = (_MaxWidth != -1)
                        ? (int) (parentWidth * _PercentWidth / (_GenericLabel.getText().length() - 1))
                        : (int) (_MaxWidth / (_GenericLabel.getText().length() - 1));

        width = (_MaxWidth != -1) ? 
                (int)(parentWidth*_PercentWidth):
                (int) _MaxWidth;
        returnValue = 
                (width* _FontSize  > parentWidth * _PercentWidth) ? 
                returnValue :
                _FontSize;
      if(returnValue < _FontSize) returnValue = _FontSize;
        return returnValue;
    }

    private void _ResizeEvent(double parentWidth) {
        double newSize = _PercentWidth * parentWidth;

        _GenericLabel.setPrefWidth(newSize);
        _GenericLabel.setFont(new Font(_FontName, _GetMaxFontSize(parentWidth)));
        if (_AutoResize) {
            _GenericLabel.autosize();
        }

    }

     private void _SetStyle() {
        _GenericLabel.setStyle(styleSheet[0] + " " + styleSheet[1]);
    }
    //====================<End> PrivateMethods===============================//
    //=====================Set Methods===============================//
    public void setText(String text) {
        _GenericLabel.setText(text);
        _GenericLabel.setFont(new Font(_FontName, _GetMaxFontSize(_ParentWidth)));
    }

    ;
    public int setFont(String name, int size) {
        int status = 0;
        try {
            _GenericLabel.setFont(Font.font(name, size));
            _FontSize = size;
            _FontName = name;
        } catch (Exception e) {
            status = 1;
        }
        return status;
    }

    public void setAutoResize(boolean flag) {
        _AutoResize = flag;
    }

    

    public void setFontColor(Color color) {
        _GenericLabel.setTextFill(color);
    }

    public void setBackColor(Color color) {
        styleSheet[0] = "-fx-background-color: #" + color.toString().substring(2, color.toString().length() - 2) + ";";
        _SetStyle();
    }

    public void setBorderColor(Color color) {
        styleSheet[1] = "-fx-border-color: #" + color.toString().substring(2, color.toString().length() - 2) + ";";
        _SetStyle();
    }

    public void setMaxWidth(double width) {
        _MaxWidth = width;
    }
    //=====================<End> Set Methods===============================//

    //=====================Get Methods===============================//
    public Label getLabel() {
        return _GenericLabel;
    }
    public int getFontSize(){return _FontSize;}
    public double getWidth(){return _ParentWidth * _PercentWidth;}
    //=====================<End> Get Methods===============================//
}
