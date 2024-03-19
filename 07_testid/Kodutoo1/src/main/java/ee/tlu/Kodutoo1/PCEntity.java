package ee.tlu.Kodutoo1;

import lombok.Getter;

@Getter
public class PCEntity {
    String nimetus;
    String valmistaja;
    int maksumus;

    public PCEntity(String nimetus, String valmistaja, int maksumus) {
        this.nimetus = nimetus;
        this.valmistaja = valmistaja;
        this.maksumus = maksumus;
    }
}
