import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.control.Slider;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.io.*;
import javafx.scene.input.KeyCode;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class SilentRadio extends Application implements Tools
{
    GraphicsContext gc;
    Label sysErr = new Label(); //Error message label
    Label fileLabel = new Label("File Name: ");
    Label slideValLabel = new Label("NO VALUE");
    String original;
    int fileLine = 0;
    int fullRepeat = 0; // Line has been repeated
    String stringLineOfText = null;
    Label fileText = new Label();
    int speed = 0;
    
    ArrayList<String> gottenFile;
    int slideValue;
    Timeline timeline;
    
    //@Override
    public void start(Stage stg)
    {
        stg.setTitle("Silent Radio");
        fileText.setFont(new Font(20));
        fileText.setAlignment(Pos.CENTER);
        fileText.setTextOverrun(OverrunStyle.LEADING_ELLIPSIS);
        sysErr.setFont(new Font(20));
        FlowPane root = new FlowPane(10,10);
        root.setAlignment(Pos.CENTER);
        Scene s = new Scene(root, 700, 400);
        stg.setScene(s);
        Canvas con = new Canvas(0,0);
        gc = con.getGraphicsContext2D();
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction((ActionEvent t) ->
        {
            sysErr.setTextFill(colorPicker.getValue());
            fileText.setTextFill(colorPicker.getValue());
            fileLabel.setTextFill(colorPicker.getValue());
        });
        fileLabel.setFont(new Font(20));
        TextField fileGet = new TextField();
        Button fieldClear = new Button("Clear Field");
        fieldClear.setOnAction((ActionEvent t)->fileGet.clear());
        HBox fileBox = new HBox();
        fileBox.getChildren().addAll(fileLabel, fileGet, fieldClear);
        fileBox.setSpacing(5);
        fileGet.setOnKeyPressed((event) -> 
        { 
            if(event.getCode().equals(KeyCode.ENTER)) 
            {
                if(timeline!=null)
                timeline.stop();
                
                if(fileGet.getText()!= null) // Get the file
                {
                    File requestedFile = new File(fileGet.getText().trim());
                    if(requestedFile.exists() && !requestedFile.isDirectory()
                            && requestedFile.canRead())
                    {
                        try{
                            gottenFile = new ArrayList<>(); // Clean AL
                            Scanner fileRead = new Scanner(requestedFile);
                            fileRead.useDelimiter("\n");
                            while(fileRead.hasNext())
                            {
                                gottenFile.add(fileRead.next());
                            }
                            fileRead.close();
                        }catch(FileNotFoundException e){sysErr.setText(e.toString());}
                    }
                } 
                if(timeline!=null)
                timeline.play();
            } 
        });
        gc.setFont(new Font(20));
        Slider slide = new Slider(-100,100,0);
        slide.setShowTickLabels(true);
        slide.setMinorTickCount(40);
        slide.setBlockIncrement(5);
        slide.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val)
            {
                slideValue = new_val.intValue();
                slideValLabel.setText(String.valueOf(slideValue));
                stopTicker();
                beginTicker();
            }
        });
        HBox textOut = new HBox();
        textOut.getChildren().addAll(fileText, sysErr);
        VBox everything = new VBox();
        everything.getChildren().addAll(fileBox, colorPicker,
                                  slide, slideValLabel, textOut);
        everything.setSpacing(5);
        
        root.getChildren().add(everything);
        beginTicker();
        stg.show();
    }
    public boolean checkRepeat()
    {
        if(fullRepeat >= 2) // Repeat same line twice
        {
            fullRepeat = 0;
            if(fileLine == gottenFile.size() - 1)
                fileLine = 0;
            else
                fileLine++;
            stringLineOfText = gottenFile.get(fileLine);
            return true;
        }
        return false;
    }
    public void flash()
    {
        fileText.setText("");// Blink
        fileText.setText(stringLineOfText);
        fileText.setText("");
        fileText.setText(stringLineOfText);
    }
    public String goBackwards()
    {
        return (stringLineOfText.substring(1 , stringLineOfText.length()) + 
                stringLineOfText.charAt(0));
    }
    public String goForward()
    {
        return(stringLineOfText.charAt(stringLineOfText.length() - 1) +
            stringLineOfText.substring(0 , stringLineOfText.length() - 1));
    }
    
    public void stopTicker()
    {
        timeline.stop();
    }
    
    public int speedControl()
    {
        speed = Math.abs(slideValue);
        if(speed > 90)
            return (speed * 2);
        if(speed > 80)
            return (speed * 5);
        if(speed > 70)
            return (speed * 8);
        if(speed > 80)
            return (speed * 11);
        if(speed > 60)
            return (speed * 14);
        if(speed > 40)
            return (speed * 17);
        if(speed > 20)
            return (speed * 25);
        return (speed * 70);
    }
    public void beginTicker()
    {
        
        timeline = new Timeline(new KeyFrame(
                Duration.millis(speedControl()),
                ae ->
                {
                    if(gottenFile != null)
                    {
                        if (stringLineOfText == null) // first run
                            stringLineOfText = gottenFile.get(fileLine);
                        checkRepeat();
                        original = gottenFile.get(fileLine);
                        if(slideValue > 0)
                        {
                            if(stringLineOfText.length() > 1)
                            {
                                stringLineOfText = goForward();
                            }
                            fileText.setText(stringLineOfText);
                            if(stringLineOfText.equals(original))
                            {
                                fullRepeat++;
                                flash();
                            }
                        }
                        else if(slideValue < 0)
                        {
                            if(stringLineOfText.length() > 1)
                            {
                                stringLineOfText = goBackwards();
                                fileText.setText(stringLineOfText);
                            }
                            if(stringLineOfText.equals(original))
                            {
                                fullRepeat++;
                                flash();
                            }
                          //  Tools.sleep(slideValue*100*-1);
                        }
                        else if(slideValue == 0) // stay
                        {
                            fileText.setText(stringLineOfText);
                        }
                    }
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
   
}