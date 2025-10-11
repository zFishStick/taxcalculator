package Class;

import java.text.DecimalFormat;

public class Formatter {
    DecimalFormat df00 = new DecimalFormat("#.00");
	DecimalFormat df = new DecimalFormat("#");
    
    public Formatter(){}

    public String format_to_df00 (Double d) {
        return df00.format(d);
    }

    public String format_to_df (Double d) {
        return df.format(d);
    }

}
