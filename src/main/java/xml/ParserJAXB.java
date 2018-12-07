package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Created by User on 28.09.2018.
 */
public class ParserJAXB {
    public static void main(String[] args) {
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);
        try {
            JAXBContext context = JAXBContext.newInstance(Group.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Group group = (Group) unmarshaller.unmarshal(inputFile);
            group.checkAverage();
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(group, outputFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
