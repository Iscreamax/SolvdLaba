package mobilestore.jackson;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import mobilestore.dom.RealDom;
import mobilestore.models.MobilePhone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonRun {
    private static final Logger LOGGER = LogManager.getLogger(JacksonRun.class);
    private static File f = new File(System.getProperty("user.dir") + "/src/main/resources/jackson.json");
    public static List<MobilePhone> mobilePhones=new ArrayList<>();

    public static void serialize(MobilePhone mobilePhone) {
        ObjectMapper om = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mobilePhones.add(mobilePhone);
        try {
            om.writeValue(f, mobilePhones);
            LOGGER.info("Successfully serialized to: " + f.getPath());
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    public static void deserialize() {
        ObjectMapper om = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        JavaType type = om.getTypeFactory().constructCollectionType(List.class, MobilePhone.class);
        try {
            List<MobilePhone> mobilePhones = om.readValue(f, type);
            LOGGER.info("Successfully deserialized from: " + f.getPath());
            LOGGER.info(mobilePhones);
        } catch (IOException e) {
            LOGGER.error(e);
        }

    }

    public static void main(String[] args) {
        RealDom realDom = new RealDom();
        try {
            realDom.run();
            for ( MobilePhone mobile: realDom.getMobilePhones()) {
            JacksonRun.serialize(mobile);
            }
            JacksonRun.deserialize();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
