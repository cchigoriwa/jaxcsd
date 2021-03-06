package zw.co.hitrac.jaxcsd.api.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Chigoriwa
 */
public abstract class AbstractOrganization extends CsdEntity {

    protected List<OtherID> otherIDs = new ArrayList<OtherID>();
    protected String primaryName;
    protected List<OrganizationOtherName> otherNames = new ArrayList<OrganizationOtherName>();
    protected List<Address> addresses = new ArrayList<Address>();
    protected List<OrganizationContact> contacts = new ArrayList<OrganizationContact>();    
    protected List<ContactPoint> contactPoints=new ArrayList<ContactPoint>();    
    protected List<CodedType> languages=new ArrayList<CodedType>();

    public List<OtherID> getOtherIDs() {
        return otherIDs;
    }

    public void setOtherIDs(List<OtherID> otherIDs) {
        this.otherIDs = otherIDs;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public List<OrganizationOtherName> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<OrganizationOtherName> otherNames) {
        this.otherNames = otherNames;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<OrganizationContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<OrganizationContact> contacts) {
        this.contacts = contacts;
    }

    public List<ContactPoint> getContactPoints() {
        return contactPoints;
    }

    public void setContactPoints(List<ContactPoint> contactPoints) {
        this.contactPoints = contactPoints;
    }

    public List<CodedType> getLanguages() {
        return languages;
    }

    public void setLanguages(List<CodedType> languages) {
        this.languages = languages;
    }
    
    
    public AbstractOrganization addAddress(Address address){
        this.addresses.add(address);
        return this;
    }
    
    
    public AbstractOrganization addContactPerson(Person person){
        OrganizationContact contact=new OrganizationContact();
        contact.setPerson(person);
        this.contacts.add(contact);
        return this;
    }
    
    public AbstractOrganization addLanguage(String code,String codingSchema,String value){
        this.languages.add(new CodedType(code, codingSchema, value));
        return this;
    }
    
    public AbstractOrganization addContactPoint(ContactPoint contactPoint){
        this.contactPoints.add(contactPoint);
        return this;
    }
    
    
    
    
    
    
     public static class OrganizationOtherName{
        private String value;
        private String lang;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
        
        
    }
    
    public static class OrganizationContact{
        private UniqueID provider;
        private Person person;

        public UniqueID getProvider() {
            return provider;
        }

        public void setProvider(UniqueID provider) {
            this.provider = provider;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }
        
    }
}
