package ee.tlu.Kodutoo1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Table
@Entity
@NoArgsConstructor
public class PCEntity {
    @Id
    private String nimetus;
    private String valmistaja;
    private int maksumus;

//    public PCEntity(String nimetus, String valmistaja, int maksumus) {
//        this.nimetus = nimetus;
//        this.valmistaja = valmistaja;
//        this.maksumus = maksumus;
//    }
}
