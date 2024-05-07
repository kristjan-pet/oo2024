package ee.tlu.kt2.floods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FloodArea {
    public String county;
    public String notation;
    public String polygon;
    public String riverOrSea;
}
