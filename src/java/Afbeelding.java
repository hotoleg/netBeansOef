
import java.util.Calendar;
import javax.servlet.RequestDispatcher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oleg.kolokolnikov
 */
public class Afbeelding {
    private final String openGeslotenAfb;
    public Afbeelding(){
        Calendar calendar = Calendar.getInstance();
        int dag = calendar.get(Calendar.DAY_OF_WEEK);
        if (dag == Calendar.MONDAY || dag == Calendar.THURSDAY) {
            openGeslotenAfb="images/gesloten.png";
        } else {
            openGeslotenAfb="images/open.png";
        }
}
    @Override
    public String toString() {
        return openGeslotenAfb;
    }
}
