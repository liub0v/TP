package shape;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;


public class DrawFrame extends GridPane {

    //buttons
    private ToggleButton moveBtn = new ToggleButton("Move");
    private Button clearBtn = new Button("Clear");
    private Button shape1DBtn = new Button("1D");
    private Button shape2DBtn = new Button("2D");

    //colorPicker
    private final ColorPicker borderColorPicker = new ColorPicker(Color.BLACK);
    private final ColorPicker fillColorPicker = new ColorPicker(Color.WHITE);

    private ObservableList<String> shape1DNames = FXCollections.observableArrayList( "Line", "Ray", "Line Segment", "Broken line");
    private ObservableList<String> shape2DNames = FXCollections.observableArrayList("Rectangle", "Circle", "Rhombus", "Ellipse", "Parallelogram", "Regular Polygon","Polygon");
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
        moveBtn.setPrefSize(100, 20);
        moveBtn.getStyleClass().add("moveButton");

        borderColorPicker.setPrefSize(70, 30);
        //borderColorPicker.getStyleClass().add("colorPicker");

        fillColorPicker.setPrefSize(70, 30);
        //fillColorPicker.getStyleClass().add("colorPicker");

        shape1DBtn.setPrefSize(50, 30);
        shape2DBtn.setPrefSize(50, 30);
        shape1DBtn.getStyleClass().add("shapeBtn1");
        shape2DBtn.getStyleClass().add("shapeBtn2");

        shapesComboBox.setPrefSize(100, 20);
        shapesComboBox.setValue("Choose shape");
        shapesComboBox.getStyleClass().add("shapesComboBox");
        shapesComboBox.setDisable(true);



        // filledLabel.setFont(new Font("Times New Roman", 14));

        canvas.moving(false);
        canvas.setBorderColor(borderColorPicker.getValue());
        canvas.setFillColor(fillColorPicker.getValue());
        canvas.getStyleClass().add("canvas");
        //canvas.moving(canvas.getLetsMove());



    }



    private void setHandlers(){

        moveBtn.setOnAction(event -> {
            if (moveBtn.isSelected()) {
                canvas.moving(true);
            }
            else canvas.moving(false);
        });

        shapesComboBox.setOnAction(event -> {

            canvas.setShape(shapesComboBox.getValue());
        });
        borderColorPicker.setOnAction(event -> {
            canvas.setBorderColor(borderColorPicker.getValue());
        });
        fillColorPicker.setOnAction(event -> {
            canvas.setFillColor(fillColorPicker.getValue());
        });
        shape1DBtn.setOnAction(event -> {

            shape1DBtn.setDisable(true);
            shape2DBtn.setDisable(false);
            shapesComboBox.setDisable(false);
            fillColorPicker.setDisable(true);
            shapesComboBox.setItems(shape1DNames);
            shapesComboBox.setValue("Choose shape");
        });

        shape2DBtn.setOnAction(event -> {

            shape1DBtn.setDisable(false);
            shape2DBtn.setDisable(true);
            shapesComboBox.setDisable(false);
            fillColorPicker.setDisable(false);
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
        menu.getStyleClass().add("menu-pane");

        GridPane shapePane = new GridPane();
        shapePane.getRowConstraints().addAll(new RowConstraints(20),
                new RowConstraints(40),
                new RowConstraints(40));
        shapePane.add(new Label(" S H A P E"),0,0);

        GridPane shapeDimBtns=new GridPane();
        shapeDimBtns.getRowConstraints().addAll(new RowConstraints(40));
        shapeDimBtns.add(shape1DBtn,0,0);
        shapeDimBtns.add(shape2DBtn,1,0);

        shapePane.add(shapeDimBtns,0,1);
        shapePane.add(shapesComboBox,0,2);

        GridPane colorPane = new GridPane();

        colorPane.getRowConstraints().addAll(new RowConstraints(30),
                new RowConstraints(40),
                new RowConstraints(40));
        colorPane.add(new Label("C O L O R"),0,0);

        GridPane borderColorPane = new GridPane();
        borderColorPane.add(borderColorPicker,0,0);
        ImageView borderImage=new ImageView("https://icons.iconarchive.com/icons/icons8/ios7/256/Editing-Border-Color-icon.png");
        borderImage.setFitWidth(20.0);
        borderImage.setFitHeight(20.0);
        borderColorPane.add(borderImage,1,0);

        GridPane fillColorPane = new GridPane();
        fillColorPane.add(fillColorPicker,0,0);
        ImageView fillImage=new ImageView("https://img.icons8.com/ios/452/fill-color.png");
        fillImage.setFitWidth(20.0);
        fillImage.setFitHeight(20.0);
        fillColorPane.add(fillImage,1,0);


        colorPane.add(borderColorPane,0,1);
        colorPane.add(fillColorPane,0,2);

        GridPane functionsPane = new GridPane();
        functionsPane.getRowConstraints().addAll(new RowConstraints(20),
                new RowConstraints(40),
                new RowConstraints(40));
        functionsPane.add(new Label(" T O O L S"),0,0);
        functionsPane.add(clearBtn,0,1);
        functionsPane.add(moveBtn,0,2);
        int menuRowHeight=110;
        RowConstraints menuRow = new RowConstraints(menuRowHeight);
        menu.getRowConstraints().addAll(menuRow,menuRow,menuRow);
        menu.add(shapePane,0,0);
        menu.add(colorPane,0,1);
        menu.add(functionsPane,0,2);

        //this.setGridLinesVisible(true);

        mainGridPane.add(menu, 1, 0);

    }


}
