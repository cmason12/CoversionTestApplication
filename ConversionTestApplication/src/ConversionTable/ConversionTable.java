
package ConversionTable;

import Models.ModLabel;
import Models.ModTextField;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ConversionTable {

    //================== Conversion Methods ========================//
    private static String _BinaryToHex(TextField input) {
        String returnString = "";

        try {
            int decimal = Integer.parseInt(input.getText(), 2);
            returnString = Integer.toString(decimal, 16);
        } catch (Exception e) {
            returnString = "#N/A";
        }
        return returnString;
    }

    private static String _BinaryToDec(TextField input) {
        String returnString = "";

        try {
            returnString = Integer.parseInt(input.getText(), 2) + "";

        } catch (Exception e) {
            returnString = "#N/A";
        }
        return returnString;
    }

    private static String _BinaryToASCII(TextField input) {
        String returnString = "";

        try {
            int charCode = Integer.parseInt(input.getText(), 2);
            returnString = (char) charCode + " ";
        } catch (Exception e) {
            returnString = "#N/A";
        }
        return returnString;
    }

    private static String _HexToBinary(TextField input) {
        String returnString = "";

        try {
            int hex = Integer.parseInt(input.getText(), 16);
            returnString = Integer.toString(hex, 2);
        } catch (Exception e) {
            returnString = "#N/A";
        }
        return returnString;
    }

    private static String _HexToDecimal(TextField input) {
        String returnString = "";

        try {
            int hex = Integer.parseInt(input.getText(), 16);
            returnString = Integer.toString(hex, 10);
        } catch (Exception e) {
            returnString = "#N/A";
        }
        return returnString;
    }

    private static String _HexToASCII(TextField input) {
        String returnString = "";

        try {
            String bin = Integer.toString(Integer.parseInt(input.getText(), 16), 2);
            System.out.println(bin);
            int charCode = Integer.parseInt(bin, 2);
            returnString = (char) charCode + " ";

        } catch (Exception e) {
            returnString = "#N/A";
        }
        return returnString;
    }

    private static String _DecimalToBinary(TextField input) {
        String returnString = "";

        try {
            int dec = Integer.parseInt(input.getText(), 16);
            returnString = Integer.toString(dec, 2);
        } catch (Exception e) {
            returnString = "#N/A";
        }
        return returnString;
    }

    private static String _DecimalToHex(TextField input) {
        String returnString = "";

        try {
            int dec = Integer.parseInt(input.getText(), 10);
            returnString = Integer.toString(dec, 16);
        } catch (Exception e) {
            returnString = "#N/A";
        }
        return returnString;
    }

    private static String _DecimalToASCII(TextField input) {
        String returnString = "";

        try {
            String bin = Integer.toString(Integer.parseInt(input.getText(),
                    10), 2);
            System.out.println(bin);
            int charCode = Integer.parseInt(bin, 2);
            returnString = (char) charCode + " ";

        } catch (Exception e) {
            returnString = "#N/A";
        }
        return returnString;
    }
 //==================<END> Conversion Methods ========================//
    
    
 //================== Type Check  ========================//
    private static String _BinaryCheck(ModTextField input, ModTextField cell) {
        String returnString = "";

        try {
            int bin = Integer.parseInt(input.getTextField().getText(), 2);
            returnString = input.getTextField().getText() + "";
            cell.setBackColor(Color.GREEN);

        } catch (Exception e) {
            returnString = "#N/A";
            cell.setBackColor(Color.RED);
        }
        return returnString;
    }

    private static String _HexCheck(ModTextField input, ModTextField cell) {
        String returnString = "";

        try {
            int bin = Integer.parseInt(input.getTextField().getText(), 16);
            returnString = input.getTextField().getText() + "";
            cell.setBackColor(Color.GREEN);

        } catch (Exception e) {
            returnString = "#N/A";
            cell.setBackColor(Color.RED);
        }
        return returnString;
    }

    private static String _DecimalCheck(ModTextField input, ModTextField cell) {
        String returnString = "";

        try {
            int bin = Integer.parseInt(input.getTextField().getText(), 10);
            returnString = bin + "";
            cell.setBackColor(Color.GREEN);

        } catch (Exception e) {
            returnString = "#N/A";
            cell.setBackColor(Color.RED);
        }
        return returnString;
    }

    //==================<END> Type Check  ========================//
    
    
    //================== StageBuilder ========================//
    public static Scene getTable(Stage parent) {
        Scene scene;

        /*
        Bieng built row by row
        0. Enter
        1. Column Headers: Binary, Hex, Dec, ASCII
        2. BinaryTo
        3. HexTo
        4. Dec To
        */
        
        //------------Row0 -------------------------//
        HBox enterBox = new HBox();
        enterBox.setStyle("-fx-background-color: #" 
                + Color.LIGHTGREEN.toString().substring(2, 
                        Color.LIGHTGREEN.toString().length() - 2) + ";");
        ModLabel lblEnter = new ModLabel(parent, "Enter Value:");
        lblEnter.setFont("Arial", 24);
        lblEnter.setFontColor(Color.DARKGREEN);
        lblEnter.setMaxWidth(50);

        ModTextField txtEnter = new ModTextField(parent);
        txtEnter.setWidth(300);
        txtEnter.setFont("Arial", 16);
        txtEnter.setBorderColor(Color.BLACK);
        enterBox.getChildren().addAll(lblEnter.getLabel(), 
                txtEnter.getTextField());
        //------------<END> Row0 -------------------------//

        //------------Row1 -------------------------//
        HBox row1Box = new HBox();
        ModLabel lblSpacer = new ModLabel(parent, "       ");
        lblSpacer.setFont("Arial", 25);
        lblSpacer.setBackColor(Color.DARKGREY);
        lblSpacer.setFontColor(Color.DARKGREY);
        lblSpacer.setBorderColor(Color.BLACK);
        lblSpacer.setMaxWidth(150);

        ModLabel lblBin = new ModLabel(parent, " BINARY  ");
        lblBin.setFont("Arial", 25);
        lblBin.setBackColor(Color.CORAL);
        lblBin.setFontColor(Color.BLACK);
        lblBin.setBorderColor(Color.BLACK);
        lblBin.setMaxWidth(150);

        ModLabel lblHex = new ModLabel(parent, "   HEX   ");
        lblHex.setFont("Arial", 25);
        lblHex.setBackColor(Color.LIGHTGRAY);
        lblHex.setFontColor(Color.BLACK);
        lblHex.setBorderColor(Color.BLACK);
        lblHex.setMaxWidth(150);

        ModLabel lblDec = new ModLabel(parent, " DECIMAL");
        lblDec.setFont("Arial", 25);
        lblDec.setBackColor(Color.CORAL);
        lblDec.setFontColor(Color.BLACK);
        lblDec.setBorderColor(Color.BLACK);
        lblDec.setMaxWidth(150);

        ModLabel lblASCII = new ModLabel(parent, "  ASCII  ");
        lblASCII.setFont("Arial", 25);
        lblASCII.setBackColor(Color.LIGHTGRAY);
        lblASCII.setFontColor(Color.BLACK);
        lblASCII.setBorderColor(Color.BLACK);
        lblASCII.setMaxWidth(150);

        row1Box.getChildren().addAll(lblSpacer.getLabel(), lblBin.getLabel(),
                lblHex.getLabel(), lblDec.getLabel(), lblASCII.getLabel());

        //------------<END> Row1 -------------------------//
        
        //------------Row2 -------------------------//
        HBox row2Box = new HBox();
        ModTextField cell_1_1 = new ModTextField(parent);
        cell_1_1.setWidth(lblSpacer.getWidth());
        cell_1_1.setText("Binary To:");
        cell_1_1.setBackColor(Color.CORAL);
        cell_1_1.setBorderColor(Color.BLACK);
        cell_1_1.setBorderColor(Color.BLACK);
        ModTextField cell_1_2 = new ModTextField(parent);
        cell_1_2.setWidth(lblBin.getWidth());
        cell_1_2.setBorderColor(Color.BLACK);
        ModTextField cell_1_3 = new ModTextField(parent);
        cell_1_3.setWidth(lblHex.getWidth());
        cell_1_3.setBorderColor(Color.BLACK);
        ModTextField cell_1_4 = new ModTextField(parent);
        cell_1_4.setWidth(lblDec.getWidth());
        cell_1_4.setBorderColor(Color.BLACK);
        ModTextField cell_1_5 = new ModTextField(parent);
        cell_1_5.setWidth(lblASCII.getWidth());
        cell_1_5.setBorderColor(Color.BLACK);
        row2Box.getChildren().addAll(cell_1_1.getTextField(),
                cell_1_2.getTextField(), cell_1_3.getTextField(),
                cell_1_4.getTextField(), cell_1_5.getTextField());
         //------------<END> Row2 -------------------------//
         
          //------------Row3 -------------------------//
        HBox row3Box = new HBox();
        ModTextField cell_2_1 = new ModTextField(parent);
        cell_2_1.setWidth(lblSpacer.getWidth());
        cell_2_1.setBorderColor(Color.BLACK);
        cell_2_1.setText("Hex To:");
        cell_2_1.setBackColor(Color.LIGHTGRAY);
        cell_2_1.setBorderColor(Color.BLACK);
        ModTextField cell_2_2 = new ModTextField(parent);
        cell_2_2.setWidth(lblBin.getWidth());
        cell_2_2.setBorderColor(Color.BLACK);
        ModTextField cell_2_3 = new ModTextField(parent);
        cell_2_3.setWidth(lblHex.getWidth());
        cell_2_3.setBorderColor(Color.BLACK);
        ModTextField cell_2_4 = new ModTextField(parent);
        cell_2_4.setWidth(lblDec.getWidth());
        ModTextField cell_2_5 = new ModTextField(parent);
        cell_2_4.setBorderColor(Color.BLACK);
        cell_2_5.setWidth(lblASCII.getWidth());
        cell_2_5.setBorderColor(Color.BLACK);
        row3Box.getChildren().addAll(cell_2_1.getTextField(),
                cell_2_2.getTextField(), cell_2_3.getTextField(),
                cell_2_4.getTextField(), cell_2_5.getTextField());
         //------------<END> Row3 -------------------------//
         
        //------------Row4 -------------------------//
        HBox row4Box = new HBox();
        ModTextField cell_3_1 = new ModTextField(parent);
        cell_3_1.setWidth(lblSpacer.getWidth());
        cell_3_1.setText("Decimal To:");
        cell_3_1.setBackColor(Color.CORAL);
        cell_3_1.setBorderColor(Color.BLACK);
        ModTextField cell_3_2 = new ModTextField(parent);
        cell_3_2.setWidth(lblBin.getWidth());
        cell_3_2.setBorderColor(Color.BLACK);
        ModTextField cell_3_3 = new ModTextField(parent);
        cell_3_3.setWidth(lblHex.getWidth());
        cell_3_3.setBorderColor(Color.BLACK);
        ModTextField cell_3_4 = new ModTextField(parent);
        cell_3_4.setWidth(lblDec.getWidth());
        cell_3_4.setBorderColor(Color.BLACK);
        ModTextField cell_3_5 = new ModTextField(parent);
        cell_3_5.setWidth(lblASCII.getWidth());
        cell_3_5.setBorderColor(Color.BLACK);
        row4Box.getChildren().addAll(cell_3_1.getTextField(),
                cell_3_2.getTextField(), cell_3_3.getTextField(),
                cell_3_4.getTextField(), cell_3_5.getTextField());
        //------------<END> Row4 -------------------------//
         
        //------------Row5 -------------------------//
        HBox row5Box = new HBox();
        ModTextField cell_4_1 = new ModTextField(parent);
        cell_4_1.setWidth(lblSpacer.getWidth());
        cell_4_1.setText("ASCII To:");
        cell_4_1.setBackColor(Color.LIGHTGRAY);
        cell_4_1.setBorderColor(Color.BLACK);
        ModTextField cell_4_2 = new ModTextField(parent);
        cell_4_2.setWidth(lblBin.getWidth());
        ModTextField cell_4_3 = new ModTextField(parent);
        cell_4_3.setWidth(lblHex.getWidth());
        ModTextField cell_4_4 = new ModTextField(parent);
        cell_4_4.setWidth(lblDec.getWidth());
        ModTextField cell_4_5 = new ModTextField(parent);
        cell_4_5.setWidth(lblASCII.getWidth());
        cell_4_5.getTextField().setDisable(true);
        row5Box.getChildren().addAll(cell_4_1.getTextField(),
                cell_4_2.getTextField(), cell_4_3.getTextField(),
                cell_4_4.getTextField(), cell_4_5.getTextField());
        //------------<END> Row5 -------------------------//
         
         
        //Scene Assembly
        VBox tableBox = new VBox();
        tableBox.getChildren().addAll(enterBox, row1Box, row2Box, 
                row3Box, row4Box);
        Pane root = new Pane();
        root.getChildren().addAll(tableBox);
        root.setStyle("-fx-background-color: #" 
                + Color.LIGHTBLUE.toString().substring(2, 
                        Color.LIGHTBLUE.toString().length() - 2) + ";");
        scene = new Scene(root, 650, 250);
        tableBox.setTranslateY(+45);
        
        
        //Listeners and Event Handlers 
        parent.heightProperty().addListener(e -> {

        });

        parent.widthProperty().addListener(e -> {
            cell_1_1.setWidth(lblSpacer.getWidth());
            cell_1_2.setWidth(lblBin.getWidth());
            cell_1_3.setWidth(lblHex.getWidth());
            cell_1_4.setWidth(lblDec.getWidth());
            cell_1_5.setWidth(lblASCII.getWidth());
        });

        txtEnter.getTextField().setOnKeyReleased((KeyEvent event) -> {
            System.out.println("Here");
            //BinaryToHex
            cell_1_3.getTextField().setText(
                    _BinaryToHex(txtEnter.getTextField()));
            //BinaryToDec
            cell_1_4.getTextField().setText(
                    _BinaryToDec(txtEnter.getTextField()));
            //BinaryToASCII
            cell_1_5.getTextField().setText(
                    _BinaryToASCII(txtEnter.getTextField()));
            //HexToBinary
            cell_2_2.getTextField().setText(
                    _HexToBinary(txtEnter.getTextField()));
            //HexToDecimal
            cell_2_4.getTextField().setText(
                    _HexToDecimal(txtEnter.getTextField()));
            //HexToASCII
            cell_2_5.getTextField().setText(
                    _HexToASCII(txtEnter.getTextField()));
            //DecimalToBinary 
            cell_3_2.getTextField().setText(
                    _DecimalToBinary(txtEnter.getTextField()));
            //DecimalToHex
            cell_3_3.getTextField().setText(
                    _DecimalToHex(txtEnter.getTextField()));
            //DecimalToASCII
            cell_3_5.getTextField().setText(
                    _DecimalToASCII(txtEnter.getTextField()));

            //BinaryCheck
            cell_1_2.getTextField().setText(
                    _BinaryCheck(txtEnter, cell_1_2));
            //HexCheck
            cell_2_3.getTextField().setText(
                    _HexCheck(txtEnter, cell_2_3));
            //DecimalCheck
            cell_3_4.getTextField().setText(
                    _DecimalCheck(txtEnter, cell_3_4));
        });

        return scene;
    }
        //==================<End> StageBuilder ========================//
}
