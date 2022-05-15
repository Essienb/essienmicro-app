package essienmicro.customer.Model;


import lombok.*;

import javax.persistence.*;


@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    @SequenceGenerator(name="customer_id_sequence",
    sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "customer_id_sequence")
    private Integer id;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;



}
