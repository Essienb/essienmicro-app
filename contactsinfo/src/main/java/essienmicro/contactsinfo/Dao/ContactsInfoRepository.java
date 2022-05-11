package essienmicro.contactsinfo.Dao;

import essienmicro.contactsinfo.Model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsInfoRepository extends JpaRepository<Contacts, Long> {

}
