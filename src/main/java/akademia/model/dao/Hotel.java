package akademia.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @GeneratedValue(generator = "uuid2")
   @GenericGenerator(name="uuid2", strategy = "uuid2")
   @Column(length = 36)
    private String partnerCode;

   @NotNull
   private String title;
   @NotNull
   private String country;
   private String rate;

 //  @JsonIgnore
   @OneToOne(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Address address;

 //  @JsonIgnore
   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //kaskadowośc co się stanie z obiektem room kiedy operuję na obiekcie Hotel
 @JoinTable(name = "hotel_room", joinColumns = @JoinColumn(name="hotel_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
   private List <Room> rooms;

   @CreationTimestamp
   private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime uptadeDateTime;

   // todo dodać klasę z opiniami o hotelu


}
