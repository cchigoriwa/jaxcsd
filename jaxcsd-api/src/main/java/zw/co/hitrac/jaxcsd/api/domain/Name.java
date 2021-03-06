package zw.co.hitrac.jaxcsd.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Chigoriwa
 */
public class Name implements Serializable{
    
    private List<String> commonNames=new ArrayList<String>();
    private String honorific;
    private String surname;
    private String suffix;
    private String forename;
    private List<CodedType> otherNames=new ArrayList<CodedType>();

    public Name() {
    }
    
    

    public Name(String honorific, String surname, String forename) {
        this.honorific = honorific;
        this.surname = surname;
        this.forename = forename;
    }
    
    

    public List<String> getCommonNames() {
        return commonNames;
    }

    public void setCommonNames(List<String> commonNames) {
        this.commonNames = commonNames;
    }

    

    public String getHonorific() {
        return honorific;
    }

    public void setHonorific(String honorific) {
        this.honorific = honorific;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public List<CodedType> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<CodedType> otherNames) {
        this.otherNames = otherNames;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }
    
    public Name addCommonName(String commonName){
        this.commonNames.add(commonName);
        return this;
    }
    
    
    
    
}
