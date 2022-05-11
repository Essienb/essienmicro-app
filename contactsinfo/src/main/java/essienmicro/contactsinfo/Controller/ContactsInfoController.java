package essienmicro.contactsinfo.Controller;


import essienmicro.contactsinfo.Model.Contacts;
import essienmicro.contactsinfo.Services.ContactsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
@Slf4j
@AllArgsConstructor
@RequestMapping("/contactsinfo")
public class ContactsInfoController {

    @Autowired
    public ContactsService contactsService;

    @GetMapping("")
    public List<Contacts> getAllContactsInfo(){
        return this.contactsService.getAllContactsInfo();
    }

    @GetMapping("/{id}")
    public Optional<Contacts> getAllContactsInfoById(@PathVariable(value="id") Long id){
        return this.contactsService.getAllContactsInfoById(id);
    }

    @PostMapping("")
    public Contacts addContacts(@RequestBody Contacts contacts){
        return this.contactsService.addContacts(contacts);
    }

    @PutMapping("")
    public Contacts updateContacts(@RequestBody Contacts contacts){
        return this.contactsService.updateContacts(contacts);
    }
    @PutMapping("/{email}")
    public String updateContactsByEmail(@PathVariable(value="email") String email){
        return this.contactsService.updateContactsByEmail(email);
    }

    @DeleteMapping("/{id}")
    public String deleteContactsInfoById(@PathVariable(value="id") Long id){
        this.contactsService.deleteContactsInfoById(id);

        return "Successfully Deleted Contact with ID: " + id;
    }
}
