module ca.georgiancollege.comp1008.comp1008thursday11amgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.georgiancollege.comp1008.comp1008thursday11amgui to javafx.fxml;
    exports ca.georgiancollege.comp1008.comp1008thursday11amgui;
}