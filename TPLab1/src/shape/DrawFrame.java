package shape;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class DrawFrame extends GridPane {

    //buttons
    private Button clearBtn = new Button("Clear");
    private Button shape1DBtn = new Button("1D");
    private Button shape2DBtn = new Button("2D");

    //colorPicker
    private final ColorPicker colorPicker = new ColorPicker(Color.BLACK);
    //?fill
    private Label filledLabel = new Label("  Filled");
    private CheckBox filledCheckBox = new CheckBox();
    //comboBox
    private ObservableList<String> shape1DNames = FXCollections.observableArrayList( "Line", "Ray", "Line Segment", "Broken line");
    private ObservableList<String> shape2DNames = FXCollections.observableArrayList("Rectangle", "Circle", "Rhombus", "Ellipse", "Parallelogram");
    private ComboBox<String> shapesComboBox = new ComboBox<String>();
    //canvas
    DrawPanel canvas = new DrawPanel();

    DrawFrame() {

        super();
        settings();
        setHandlers();
        setLayout(this);
    }

    private void settings() {

        clearBtn.setPrefSize(100, 20);
        clearBtn.getStyleClass().add("clearBtn");
        colorPicker.setPrefSize(100, 30);
        shape1DBtn.setPrefSize(50, 30);
        shape2DBtn.setPrefSize(50, 30);
        shape1DBtn.getStyleClass().add("shapeBtn");
        shape2DBtn.getStyleClass().add("shapeBtn");

        shapesComboBox.setPrefSize(100, 20);
        shapesComboBox.setValue("Choose shape");
        shapesComboBox.getStyleClass().add("shapesComboBox");
        shapesComboBox.setDisable(true);

        filledLabel.setFont(new Font("Times New Roman", 14));

        canvas.setColor(colorPicker.getValue());

    }

    private void setHandlers(){


        shapesComboBox.setOnAction(event -> {

            canvas.setShape(shapesComboBox.getValue());
        });
        colorPicker.setOnAction(event -> {

            canvas.setColor(colorPicker.getValue());
        });
        shape1DBtn.setOnAction(event -> {

            shape1DBtn.setDisable(true);
            shape2DBtn.setDisable(false);
            shapesComboBox.setDisable(false);
            shapesComboBox.setItems(shape1DNames);
            shapesComboBox.setValue("Choose shape");
        });

        shape2DBtn.setOnAction(event -> {

            shape1DBtn.setDisable(false);
            shape2DBtn.setDisable(true);
            shapesComboBox.setDisable(false);
            shapesComboBox.setItems(shape2DNames);
            shapesComboBox.setValue("Choose shape");
        });
        clearBtn.setOnAction(event -> {

            canvas.repaint();
        });
    }
    private void setLayout(GridPane mainGridPane){

        mainGridPane.add(canvas, 0, 0);

        GridPane menu = new GridPane();

        GridPane fillPane = new GridPane();
        fillPane.add(filledCheckBox, 0, 0);
        fillPane.add(filledLabel, 1, 0);

        GridPane shapeButtons = new GridPane();
        shapeButtons.add(shape1DBtn,0,0);
        shapeButtons.add(shape2DBtn,1,0);

        menu.add(clearBtn, 0, 0);
        menu.add(shapeButtons,0,1);
        menu.add(shapesComboBox, 0, 2);
        menu.add(colorPicker, 0, 3);
        menu.add(fillPane, 0, 4);

        //this.setGridLinesVisible(true);

        mainGridPane.add(menu, 1, 0);

    }


}
