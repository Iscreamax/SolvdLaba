package mobilestore.dom;

import mobilestore.modules.*;
import mobilestore.modules.MobilePhone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RealDom implements IDOMEnum {
    private static final Logger LOGGER = LogManager.getLogger(mobilestore.dom.RealDom.class);

    public static void run() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        document = builder.parse(new File("src/main/resources/mobileStore_jdom.xml"));

        NodeList nodeList = document.getElementsByTagName(TAG_PHONE);
        int index = nodeList.getLength();
        List<MobilePhone> mobilePhones = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            MobilePhone mobilePhone = new MobilePhone();
            MobileStore mobileStore = new MobileStore();
            Specification specification = new Specification();
            Battery battery = new Battery();
            Display display = new Display();
            Processor processor = new Processor();
            Memory memory = new Memory();
            Node node = nodeList.item(i);
            Element element = (Element) node;
            mobilePhone.setName(element.getElementsByTagName(TAG_PHONE_NAME).item(0).getTextContent());
            mobilePhone.setYear(Integer.parseInt(element.getElementsByTagName(TAG_PHONE_YEAR).item(0).getTextContent()));
            mobilePhone.setImei(Long.parseLong(element.getElementsByTagName(TAG_PHONE_IMEI).item(0).getTextContent()));
            mobilePhone.setPrice(Integer.parseInt(element.getElementsByTagName(TAG_PHONE_PRICE).item(0).getTextContent()));

            Node mStoreNode = element.getElementsByTagName(TAG_PHONE_STORE).item(0);
            Element mStoreElement = (Element) mStoreNode;
            mobileStore.setName(mStoreElement.getElementsByTagName(TAG_PHONE_STORE_NAME).item(0).getTextContent());
            mobileStore.setAddress(mStoreElement.getElementsByTagName(TAG_PHONE_STORE_ADDRESS).item(0).getTextContent());
            mobilePhone.setMobileStores(mobileStore);

            Node batteryNode = element.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_BATTERY).item(0);
            Element batteryElement = (Element) batteryNode;
            battery.setName(batteryElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_BATTERY_MANUFACTURER).item(0).getTextContent());
            battery.setCapacity(Integer.parseInt(batteryElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_BATTERY_CAPACITY).item(0).getTextContent()));
            battery.setPrice(Integer.parseInt(batteryElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_BATTERY_PRICE).item(0).getTextContent()));
            specification.setBattery(battery);

            Node memoryNode = element.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_MEMORY).item(0);
            Element memoryElement = (Element) memoryNode;
            memory.setName(memoryElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_MEMORY_MANUFACTURER).item(0).getTextContent());
            memory.setCapacity(Integer.parseInt(memoryElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_MEMORY_CAPACITY).item(0).getTextContent()));
            memory.setPrice(Integer.parseInt(memoryElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_MEMORY_PRICE).item(0).getTextContent()));
            specification.setMemory(memory);

            Node displayNode = element.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_DISPLAY).item(0);
            Element displayElement = (Element) displayNode;
            display.setManufacture(displayElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_DISPLAY_MANUFACTURER).item(0).getTextContent());
            display.setType(displayElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_DISPLAY_TYPE).item(0).getTextContent());
            display.setInch(Double.parseDouble(displayElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_DISPLAY_INCH).item(0).getTextContent()));
            display.setPrice(Integer.parseInt(displayElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_DISPLAY_PRICE).item(0).getTextContent()));
            specification.setDisplay(display);

            Node processorNode = element.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_PROCESSOR).item(0);
            Element processorElement = (Element) processorNode;
            processor.setName(processorElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_PROCESSOR_MANUFACTURER).item(0).getTextContent());
            processor.setNoc(Integer.parseInt(processorElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_PROCESSOR_NOC).item(0).getTextContent()));
            processor.setFrequency(processorElement.getElementsByTagName(TAG_PHONE_STORE_SPECIFICATION_PROCESSOR_FREQUENCY).item(0).getTextContent());
            specification.setProcessor(processor);

            mobilePhone.setSpecifications(specification);
            mobilePhones.add(mobilePhone);
        }
        LOGGER.info(mobilePhones);
    }
}


