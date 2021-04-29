package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {

    private String formatDesired;

    public DateParser(String formatDesired) {
        this.formatDesired = formatDesired;
    }

    public String getFormatDesired() {
        return formatDesired;
    }

    public void setFormatDesired(String formatDesired) {
        this.formatDesired = formatDesired;
    }


    public void formatDate(LocalDate date){
         date.format(DateTimeFormatter.ofPattern(this.formatDesired));
    }
}
