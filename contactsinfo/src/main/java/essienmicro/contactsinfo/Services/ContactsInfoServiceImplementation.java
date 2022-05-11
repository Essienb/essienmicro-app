package essienmicro.contactsinfo.Services;

import essienmicro.contactsinfo.Dao.ContactsInfoRepository;
import essienmicro.contactsinfo.Model.Contacts;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactsInfoServiceImplementation implements ContactsService{

    @Autowired
    public ContactsInfoRepository contactsInfoRepository;

    @Override
    public List<Contacts> getAllContactsInfo() {
        return this.contactsInfoRepository.findAll();
    }

    @Override
    public Optional<Contacts> getAllContactsInfoById(Long id) {
        return this.contactsInfoRepository.findById(id);
    }

    @Override
    public Contacts addContacts(Contacts contacts) {
        return this.contactsInfoRepository.save(contacts);
    }

    @Override
    public Contacts updateContacts(Contacts contacts) {
        Optional<Contacts> contactsRequiringUpdates = this.contactsInfoRepository.findById(contacts.getId());

        if(contactsRequiringUpdates.isEmpty()) return null;

        Contacts contactsInfoToUpdate = contactsRequiringUpdates.get();

        if(contacts.getFirstName() !=null) {
            contactsInfoToUpdate.setFirstName(contacts.getFirstName());
        }

        if(contacts.getLastName() !=null) {
            contactsInfoToUpdate.setLastName(contacts.getLastName());
        }

        if(contacts.getEmail() !=null) {
            contactsInfoToUpdate.setEmail(contacts.getEmail());
        }

        if(contacts.getPhone() != 0) {
            contactsInfoToUpdate.setPhone(contacts.getPhone());
        }

        Contacts contactsInfoUpdated = this.contactsInfoRepository.save(contactsInfoToUpdate);
        return contactsInfoUpdated;
    }

    @Override
    public String updateContactsByEmail(String email) {
        Optional<Contacts> contactsToBeUpdatedByEmail = this.contactsInfoRepository.findById(Long.valueOf(email));


        if(contactsToBeUpdatedByEmail.isEmpty()) return null;

        Contacts contactsInfoToUpdate = contactsToBeUpdatedByEmail.get();

        Contacts contactsUpdated = contactsToBeUpdatedByEmail.get();
        this.contactsInfoRepository.save(contactsUpdated);

        return "Contacts updated successfully";
    }

    @Override
    public String deleteContactsInfoById(Long id) {
        Optional<Contacts> contactsToBeDeleted = this.contactsInfoRepository.findById(id);

        if(contactsToBeDeleted.isEmpty()) return null;

        Contacts contactsDeleted = contactsToBeDeleted.get();
        this.contactsInfoRepository.delete(contactsDeleted);

        return "Happy to inform you your action deleted it. Oops!";
    }
}
