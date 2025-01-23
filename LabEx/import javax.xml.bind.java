import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class TaskXMLUtil {

    public static String convertToXML(Task task) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Task.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(task, writer);
        return writer.toString();
    }

    public static Task convertFromXML(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Task.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Task) unmarshaller.unmarshal(new StringReader(xml));
    }
}
