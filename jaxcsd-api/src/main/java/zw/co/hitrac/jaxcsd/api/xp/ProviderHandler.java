package zw.co.hitrac.jaxcsd.api.xp;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import zw.co.hitrac.jaxcsd.api.domain.Person;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.domain.ProviderFacilities;
import zw.co.hitrac.jaxcsd.api.domain.ProviderOrganizations;
import zw.co.hitrac.jaxcsd.api.domain.Record;
import zw.co.hitrac.jaxcsd.api.domain.ext.ProviderExtension;

/**
 *
 * @author charles
 */
public class ProviderHandler {

    public static void handle(Provider provider, XMLStreamReader r) throws XMLStreamException {

        while (r.hasNext()) {
            r.next();

            if (r.isStartElement()) {
                if ("otherID".equals(r.getLocalName())) {
                    OtherID otherID = HandlerUtils.getOtherID(r);
                    provider.getOtherIDs().add(otherID);
                } else if ("codedType".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    provider.getCodedTypes().add(codedType);
                } else if ("demographic".equals(r.getLocalName())) {
                    Person demographic = new Person();
                    provider.setDemographic(demographic);
                    DemographicHandler.handle(demographic, r);
                } else if ("language".equals(r.getLocalName())) {
                    CodedType codedType =HandlerUtils.getCodedType(r);
                    provider.getLanguages().add(codedType);
                } else if ("organizations".equals(r.getLocalName())) {
                    ProviderOrganizations providerOrganizations = new ProviderOrganizations();
                    provider.setProviderOrganizations(providerOrganizations);
                    ProviderOrganizationsHandler.handle(providerOrganizations, r);
                } else if ("facilities".equals(r.getLocalName())) {
                    ProviderFacilities providerFacilities = new ProviderFacilities();
                    provider.setProviderFacilities(providerFacilities);
                    ProviderFacilitiesHandler.handle(providerFacilities, r);
                } else if ("credential".equals(r.getLocalName())) {
                    Credential credential = HandlerUtils.getCredential(r);
                    provider.addCredential(credential);
                } else if ("specialty".equals(r.getLocalName())) {
                    CodedType codedType = HandlerUtils.getCodedType(r);
                    provider.getSpecialties().add(codedType);
                } else if ("extension".equals(r.getLocalName())) {
                    ProviderExtension providerExtension = new ProviderExtension();
                    provider.getExtensions().add(providerExtension);
                    ExtensionHandler.handle(providerExtension, r);
                } else if ("record".equals(r.getLocalName())) {
                    Record record = HandlerUtils.getRecord(r);
                    provider.setRecord(record);
                }


            } else if (r.isEndElement()) {
                if ("provider".equals(r.getLocalName())) {
                    break;
                }
            }
        }
    }
}
