package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerAjedrez {

        @FXML Button start;
        @FXML Button move;
        @FXML TextField to;
        @FXML TextField from;
        @FXML AnchorPane tablero;
        @FXML ListView list;

                        @FXML
                        public void initialize(){
                            startP();
                        }

                int xl = 15, yl = 15;
                int xl2 = 20, yl2 = 50;

                Text[][] text = new Text[4][8];
                Rectangle[][] rectangle = new Rectangle[8][8];

                String fromT;
                String toT;
                double desdex , desdey , hastax, hastay;
                double xp , yp;

                double mDesdeX, mDesdeY, mHastaX, mHastaY;
                boolean eat = false;
                boolean color = true;
                boolean movida = true;

                int xpo = 0 , ypo = 0;

                ObservableList<String> list2 = FXCollections.observableArrayList() ;

        public void startP(){

            for(int x = 0 ;  x < 8 ;  x++){
                for( int y = 0 ; y < 8 ; y++){

                    rectangle[x][y] = new Rectangle(45,45);
                    
                    if(color){
                        rectangle[x][y].setFill(Color.WHITE);
                        color = false;
                    }
                    else{
                        rectangle[x][y].setFill(Color.LIME);
                        color = true;
                    }

                    rectangle[x][y].setLayoutX(xl);
                    rectangle[x][y].setLayoutY(yl);

                    int finalX = x;
                    int finalY = y;

                    rectangle[x][y].setOnMouseClicked(event ->{

                                if(movida){

                                    mDesdeX = 5 + rectangle[finalX][finalY].getLayoutX();
                                    mDesdeY = 35 + rectangle[finalX][finalY].getLayoutY();

                                    xpo = (int)(mDesdeX-20)/45;
                                    ypo = ((int)(mDesdeY-50)/45)+1;

                                    switch (xpo){
                                        case 0:  from.setText("h"+ypo);
                                            break;
                                        case 1: from.setText("g"+ypo);
                                            break;
                                        case 2: from.setText("f"+ypo);
                                            break;
                                        case 3: from.setText("e"+ypo);
                                            break;
                                        case 4: from.setText("d"+ypo);
                                            break;
                                        case 5: from.setText("c"+ypo);
                                            break;
                                        case 6: from.setText("b"+ypo);
                                            break;
                                        case 7: from.setText("a"+ypo);
                                            break;
                                    }

                                    movida = false;
                                }
                                else{

                                    mHastaX = 5 + rectangle[finalX][finalY].getLayoutX();
                                    mHastaY = 35 + rectangle[finalX][finalY].getLayoutY();

                                    xpo = (int)(mHastaX-20)/45;
                                    ypo = ((int)(mHastaY-50)/45)+1;

                                    switch (xpo){
                                        case 0:  to.setText("h"+ypo);
                                            break;
                                        case 1: to.setText("g"+ypo);
                                            break;
                                        case 2: to.setText("f"+ypo);
                                            break;
                                        case 3: to.setText("e"+ypo);
                                            break;
                                        case 4: to.setText("d"+ypo);
                                            break;
                                        case 5: to.setText("c"+ypo);
                                            break;
                                        case 6: to.setText("b"+ypo);
                                            break;
                                        case 7: to.setText("a"+ypo);
                                            break;
                                    }

                                    movida = true;

                                    print();

                                    moveP();

                                }//swicj

                            });

                    tablero.getChildren().add(rectangle[x][y]);
                    xl = xl + 45;
                }//for
                color = !color;
               xl = 15;
                yl = yl + 45;
            }//for

            for(int x = 0 ; x < 4 ; x++){
                for(int y = 0 ; y < 8 ; y++){

                    switch (x){
                        case 0: yl2 = 50;
                            break;
                        case 1: yl2 = 95;
                            break;
                        case 2: yl2 = 320;
                            break;
                        case 3: yl2 = 365;
                            break;
                    }//switch

                    if(x == 0){
                        switch (y){
                            case 0:  text[x][y] = new Text("♖");
                                break;
                            case 1:  text[x][y] = new Text("♘");
                                break;
                            case 2:  text[x][y] = new Text("♗");
                                break;
                            case 3: text[x][y] = new Text("♔");
                                break;
                            case 4: text[x][y] = new Text("♕");
                                break;
                            case 5:  text[x][y] = new Text("♗");
                                break;
                            case 6:  text[x][y] = new Text("♘");
                                break;
                            case 7:  text[x][y] = new Text("♖");
                                break;
                        }//switch
                    }
                    else if(x == 1){
                        text[x][y] = new Text("♙");
                    }
                    else if(x == 2){
                        text[x][y] = new Text("♟");
                    }
                    else{
                        switch (y){
                            case 0:  text[x][y] = new Text("♜");
                                break;
                            case 1:  text[x][y] = new Text("♞");
                                break;
                            case 2:  text[x][y] = new Text("♝");
                                break;
                            case 3: text[x][y] = new Text("♚");
                                break;
                            case 4: text[x][y] = new Text("♛");
                                break;
                            case 5:  text[x][y] = new Text("♝");
                                break;
                            case 6:  text[x][y] = new Text("♞");
                                break;
                            case 7:  text[x][y] = new Text("♜");
                                break;
                        }//switch
                    }

                    text[x][y].setLayoutX(xl2);
                    text[x][y].setLayoutY(yl2);

                    text[x][y].setFont(new Font("ARIAL",35));

                    int finalX = x;
                    int finalY = y;
                    text[x][y].setOnMouseClicked(event -> {

                        if(movida == true){

                            mDesdeX =text[finalX][finalY].getLayoutX();
                            mDesdeY =text[finalX][finalY].getLayoutY();

                            xpo = (int)(mDesdeX-20)/45;
                            ypo = ((int)(mDesdeY-50)/45)+1;

                            switch (xpo){
                                case 0:  from.setText("h"+ypo);
                                    break;
                                case 1: from.setText("g"+ypo);
                                    break;
                                case 2: from.setText("f"+ypo);
                                    break;
                                case 3: from.setText("e"+ypo);
                                    break;
                                case 4: from.setText("d"+ypo);
                                    break;
                                case 5: from.setText("c"+ypo);
                                    break;
                                case 6: from.setText("b"+ypo);
                                    break;
                                case 7: from.setText("a"+ypo);
                                    break;
                            }

                            movida = false;
                        }
                        else{

                            mHastaX = text[finalX][finalY].getLayoutX();
                            mHastaY = text[finalX][finalY].getLayoutY();

                            xpo = (int)(mHastaX-20)/45;
                            ypo = ((int)(mHastaY-50)/45)+1;

                            switch (xpo){
                                case 0:  to.setText("h"+ypo);
                                    break;
                                case 1: to.setText("g"+ypo);
                                    break;
                                case 2: to.setText("f"+ypo);
                                    break;
                                case 3: to.setText("e"+ypo);
                                    break;
                                case 4: to.setText("d"+ypo);
                                    break;
                                case 5: to.setText("c"+ypo);
                                    break;
                                case 6: to.setText("b"+ypo);
                                    break;
                                case 7: to.setText("a"+ypo);
                                    break;
                            }

                            movida = true;

                            print();

                            moveP();

                        }//swicj

                            });


                    tablero.getChildren().add(text[x][y]);

                    xl2 = xl2 + 45;
                }//for
                xl2 = 20;
            }//for

        }//startP

        public void moveP(){

            fromT = from.getText();

            if(fromT.equals("volver")){

                try {
                    Parent root = FXMLLoader.load(getClass().getResource("pantallaMain.fxml"));
                    Main.stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else

            toT = to.getText();

            switch (fromT.charAt(0)){
                case 'a': desdex = 7;
                    break;
                case 'b': desdex = 6;
                    break;
                case 'c': desdex = 5;
                    break;
                case 'd': desdex = 4;
                    break;
                case 'e': desdex = 3;
                    break;
                case 'f': desdex = 2;
                    break;
                case 'g': desdex = 1;
                    break;
                case 'h': desdex = 0;
                    break;
                default:
                    desdex = Double.parseDouble(fromT.charAt(0)+"");
            }//switch

            desdey = Double.parseDouble(fromT.charAt(1)+"");

            switch (toT.charAt(0)){
                case 'a': hastax = 7;
                    break;
                case 'b': hastax = 6;
                    break;
                case 'c': hastax = 5;
                    break;
                case 'd': hastax = 4;
                    break;
                case 'e': hastax = 3;
                    break;
                case 'f': hastax = 2;
                    break;
                case 'g': hastax = 1;
                    break;
                case 'h': hastax = 0;
                    break;
                default:
                    hastax = Double.parseDouble(fromT.charAt(0)+"");
            }//switch

            hastay = Double.parseDouble(toT.charAt(1)+"");

            desdey --;
            hastay --;

           for(int x = 0; x < 4 ; x++){
               for(int y = 0; y < 8 ; y++){

                   xp = text[x][y].getLayoutX();
                   yp = text[x][y].getLayoutY();

                   if(xp ==  (20 + (desdex*45)) && yp == (50 + (desdey*45))){

                       for(int j = 0; j< 4 ; j++){
                           for(int k = 0; k < 8 ; k++) {

                               if(text[j][k].getLayoutX() == ((double) 20 + (hastax*45)) && text[j][k].getLayoutY() == ((double) 50 + (hastay*45))){
                                   if(j != x && k != y){
                                       text[j][k].setLayoutY(700);
                                       text[j][k].setLayoutX(700);
                                       eat = true;
                                   }
                               }//if

                           }//for k
                       }//for j

                       text[x][y].setLayoutX((double) 20 + (hastax*45)) ;
                       text[x][y].setLayoutY((double) 50 + (hastay*45));

                       if(eat == true){
                                                list2.add(text[x][y].getText() + "x" + to.getText());
                           eat = false;
                       }
                       else{
                           list2.add(text[x][y].getText()+ to.getText());
                       }

                       list.setItems(list2);

                   }//if
               }//for
           }//for

                from.setText("");
                to.setText("");
        }//moveP

        public void print(){
            System.out.println("Desde x=" + mDesdeX + " Desde y=" + mDesdeX + " Hasta x=" + mHastaX + " Hasta y=" + mHastaY);
        }

}//Controller
