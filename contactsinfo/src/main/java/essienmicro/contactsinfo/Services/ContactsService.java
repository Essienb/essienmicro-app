package essienmicro.contactsinfo.Services;

import essienmicro.contactsinfo.Model.Contacts;

import java.util.List;
import java.util.Optional;

public interface ContactsService {

    List<Contacts> getAllContactsInfo();
    Optional<Contacts> getAllContactsInfoById(Long id);
    Contacts addContacts(Contacts contacts);
    Contacts updateContacts(Contacts contacts);
    String updateContactsByEmail(String email);
    String deleteContactsInfoById(Long id);



}
