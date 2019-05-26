package Models;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ModButton {

    private int _FontSize = 8;
    private String _FontName = "Arial";
    private double _PercentWidth = 0;
    private double _MaxWidth = -1;
    private Button _GenericButton = new Button();
    private boolean _AutoResize = true;
    private double _ParentWidth = 0;
    private Color _PressedColor = Color.GRAY;
    private Color _HoverColor = Color.GREENYELLOW;
    private String styleSheet[] = {"", "", ""};

    //=====================Constructors===============================//
    public ModButton(Stage parent) {
        _ParentWidth = parent.getWidth();
        _PercentWidth = ((50) / parent.getWidth());
        _GenericButton.setMinWidth(parent.getWidth() * _PercentWidth);
        _GenericButton.setPrefWidth(parent.getWidth() * _PercentWidth);
        _GenericButton.autosize();

        parent.heightProperty().addListener(e -> {
        });

        parent.widthProperty().addListener(e -> {
            _ParentWidth = (parent.getWidth());
            if (_AutoResize) {
                _ResizeEvent(_ParentWidth);
            }

        });

    }

    public ModButton(Stage parent, String text) {
        _ParentWidth = parent.getWidth();
        setText(text);
        _PercentWidth = ((50) / parent.getWidth());
        _GenericButton.setMinWidth(parent.getWidth() * _PercentWidth);
        _GenericButton.setPrefWidth(parent.getWidth() * _PercentWidth);
        _GenericButton.autosize();

        parent.heightProperty().addListener(e -> {

        });

        parent.widthProperty().addListener(e -> {
            _ParentWidth = (parent.getWidth());
            if (_AutoResize) {
                _ResizeEvent(_ParentWidth);
            }

        });

        _GenericButton.setOnMouseEntered((MouseEvent event) -> {
           _GenericButton.setStyle("-fx-background-color: #" + 
                   _HoverColor.toString().substring(2, _HoverColor.toString().length() - 2) +";\n" +
"        -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
"        -fx-text-alignment: center;");
        });
        
         _GenericButton.setOnMousePressed((MouseEvent event) -> {
           _GenericButton.setStyle(" -fx-background-color:#" + 
                   _PressedColor.toString().substring(2, _PressedColor.toString().length() - 2)
                   + "; \n" + "-fx-text-alignment: center;");
        });
         
         
         _GenericButton.setOnMouseReleased((MouseEvent event) -> {
           _GenericButton.setStyle("-fx-background-color: #" + 
                   _HoverColor.toString().substring(2, _HoverColor.toString().length() - 2) +";\n" +
"        -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
"        -fx-text-alignment: center;");
        });
         
         _GenericButton.setOnMouseExited((MouseEvent event) -> {
          _SetStyle();
        });
    }
    //=====================<End> Constructors===============================//

    //=====================Private Methods===============================//
    private int _GetMaxFontSize(double parentWidth) {
        int returnValue = 0;
        int width;
        returnValue
                = (int) (parentWidth * _PercentWidth / (_GenericButton.getText().length()));

        if (returnValue < _FontSize) {
            returnValue = _FontSize;
        }
        if (returnValue * _GenericButton.getText().length() > parentWidth * _PercentWidth) {
            returnValue = _FontSize;
        }
        return returnValue;
    }

    private void _ResizeEvent(double parentWidth) {
        double newSize = _PercentWidth * parentWidth;

        _GenericButton.setPrefWidth(newSize);
        _GenericButton.setFont(new Font(_FontName, _GetMaxFontSize(parentWidth)));
        if (_AutoResize) {
            _GenericButton.autosize();
        }

    }

    private void _SetStyle() {
        _GenericButton.setStyle(styleSheet[0] + " "
                + styleSheet[1] + " " + styleSheet[2] + " " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
"        -fx-text-alignment: center;");
    }

    //====================<End> PrivateMethods===============================//
    //=====================Set Methods===============================//
    public void setText(String text) {
        _GenericButton.setText(text);
        _GenericButton.setFont(new Font(_FontName, _GetMaxFontSize(_ParentWidth)));
    }

    ;
    public int setFont(String name, int size) {
        int status = 0;
        try {
            _GenericButton.setFont(Font.font(name, size));
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

    public void setPresseColor(Color color) {_PressedColor = color;}
    public void setHoverColor(Color color) {_HoverColor = color;}
    public void setWidth(double width) {
        _MaxWidth = width;
        _PercentWidth = _MaxWidth / _ParentWidth;
        _GenericButton.setMinWidth(width);
        _GenericButton.setPrefWidth(width);

        _ResizeEvent(_ParentWidth);
    }
    //=====================<End> Set Methods===============================//

    //=====================Get Methods===============================//
    public Button getButton() {
        return _GenericButton;
    }
    //=====================<End> Get Methods===============================//
}
