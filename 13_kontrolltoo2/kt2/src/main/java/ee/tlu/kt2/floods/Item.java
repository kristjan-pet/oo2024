package ee.tlu.kt2.floods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    public String description;
    public String eaAreaName;
    public String eaRegionName;
    public FloodArea floodArea;
    public String floodAreaID;
    public boolean isTidal;
    public String message;
    public String severity;
    public int severityLevel;
    public Date timeMessageChanged;
    public Date timeRaised;
    public Date timeSeverityChanged;
}
