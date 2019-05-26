package Models;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ModTextField {

    private int _FontSize = 16;
    private String _FontName = "Arial";
    private double _PercentWidth = 0;
    private double _PercentHeight = 0;
    private double _Width = -1;
    private TextField _GenericTextField = new TextField();
    private boolean _AutoResize = true;
    private double _ParentWidth = 0;
    private double _ParentHeight = 0;
    private String styleSheet[] = {"", "", ""};

    //=====================Constructors===============================//
    public ModTextField(Stage parent) {
        _ParentWidth = parent.getWidth();
        _ParentHeight = parent.getHeight();
        setText("");
       _PercentWidth = ((50) / parent.getWidth());
        
        _PercentHeight = (_FontSize*2)/ _ParentHeight;
        _GenericTextField.setMinHeight(parent.getHeight() * _PercentHeight);
       _GenericTextField.setPrefHeight(parent.getHeight() * _PercentHeight);
        _GenericTextField.setMinWidth(parent.getWidth() * _PercentWidth);
        _GenericTextField.setPrefWidth(parent.getWidth() * _PercentWidth);
        _GenericTextField.autosize();

        parent.heightProperty().addListener(e -> {
            _ParentHeight = parent.getHeight();
  
            _GenericTextField.setMinHeight(parent.getHeight() * (_PercentHeight));
        _GenericTextField.setPrefHeight(parent.getHeight() * _PercentHeight);

        });

        parent.widthProperty().addListener(e -> {
            _ParentWidth = (parent.getWidth());
            if (_AutoResize) {
                _ResizeEvent(_ParentWidth);
            }

        });

    }

    public ModTextField(Stage parent, String text) {
        _ParentWidth = parent.getWidth();
        _ParentHeight = parent.getHeight();
        setText(text);
        _PercentHeight = (_FontSize) / _ParentHeight;
        _GenericTextField.setMinHeight(parent.getHeight() * _PercentHeight);
        _GenericTextField.setPrefHeight(parent.getHeight() * _PercentHeight);
        _GenericTextField.setMinWidth(parent.getWidth() * _PercentWidth);
        _GenericTextField.setPrefWidth(parent.getWidth() * _PercentWidth);
        _GenericTextField.autosize();

        parent.heightProperty().addListener(e -> {
            _ParentHeight = parent.getHeight();
            _PercentHeight = (_FontSize) / _ParentHeight;
            _GenericTextField.setMinHeight(parent.getHeight() * _PercentHeight);
        _GenericTextField.setPrefHeight(parent.getHeight() * _PercentHeight);

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

    private void _ResizeEvent(double parentWidth) {
        double newSize = _PercentWidth * parentWidth;
        _Width = parentWidth*_PercentWidth;
        double fontSize = (_ParentHeight*_PercentHeight);
  
        if (fontSize > 29 ) fontSize = _FontSize;
        else if (fontSize<=_FontSize)fontSize = _FontSize;
         
        
        _GenericTextField.setPrefWidth(newSize);
        _GenericTextField.setFont(new Font(_FontName,(fontSize)));


        
     
        
    }

    private void _SetStyle() {
        _GenericTextField.setStyle(styleSheet[0] + " "
                + styleSheet[1] + " " + styleSheet[2]);
    }

    //====================<End> PrivateMethods===============================//
    //=====================Set Methods===============================//
    public void setText(String text) {
        _GenericTextField.setText(text);
        //_GenericTextField.setFont(new Font(_FontName, _GetMaxFontSize(_ParentWidth)));
    }

    ;
    public int setFont(String name, int size) {
        int status = 0;
        try {
            _GenericTextField.setFont(Font.font(name, size));
            _FontSize = size;
            _FontName = name;
            _GenericTextField.setPrefHeight(size*1.65);
            _GenericTextField.setMinHeight(size*1.65);
            _GenericTextField.setMaxHeight(size*1.65);
       
        } catch (Exception e) {
            status = 1;
        }
        return status;
    }

    public void setAutoResize(boolean flag) {
        _AutoResize = flag;
    }

    public void setFontColor(Color color) {
        styleSheet[2] = "-fx-fontcolor: #" + color.toString().substring(2, color.toString().length() - 2) + ";";
        _SetStyle();
    }

    public void setBackColor(Color color) {
        styleSheet[0] = "-fx-background-color: #" + color.toString().substring(2, color.toString().length() - 2) + ";";
        _SetStyle();
    }

    public void setBorderColor(Color color) {
        styleSheet[1] = "-fx-border-color: #" + color.toString().substring(2, color.toString().length() - 2) + ";";
        _SetStyle();
    }

    public void setWidth(double width) {
        _Width = width;
        _PercentWidth = _Width / _ParentWidth;
        _GenericTextField.setMinWidth(width);
        _GenericTextField.setPrefWidth(width);
        //_GenericTextField.setMaxWidth(width);
        _ResizeEvent(_ParentWidth);
    }
    //=====================<End> Set Methods===============================//

    //=====================Get Methods===============================//
    public TextField getTextField() {
        return _GenericTextField;
    }
    //=====================<End> Get Methods===============================//
}
