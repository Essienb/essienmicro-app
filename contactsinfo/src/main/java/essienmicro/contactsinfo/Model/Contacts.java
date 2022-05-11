package essienmicro.contactsinfo.Model;


import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="contactsinfo")
public class Contacts {

    @Id
    @SequenceGenerator(name = " Contactsinfo_seq", sequenceName = "Contactsinfo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Contactsinfo_seq")
    private long id;
    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private long phone;





}
