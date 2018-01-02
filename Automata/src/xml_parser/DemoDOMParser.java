/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml_parser;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author MyUniverse
 */
public class DemoDOMParser extends DemoAbstractParser {
//Constructor

    public DemoDOMParser(String filename) {
        super(filename);
    }

    @Override
    public List<State> getAllState() {
        try {
            //Tạo đối tượng builder để phân tách dữ liệu theo mô hình DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            FileInputStream fIS = new FileInputStream(filename);
            Document document = builder.parse(fIS);
            // Tạo arraylist để đựng kết quả trả về
            List<State> stateList = new ArrayList<>();
            // Lấy tất cả các elements có tag là "state", chứa vào một nodeList
            NodeList nodeList = document.getElementsByTagName("state");
            // Duyệt các node trong nodeList
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);   // Lấy ra thẻ state con thứ i trong nodeList các thẻ "state"
                if (node instanceof Element) {

                    State state = new State();
                    state.setId(node.getAttributes().getNamedItem("id").getNodeValue());
                    state.setName(node.getAttributes().getNamedItem("name").getNodeValue());

                    NodeList childNodes = node.getChildNodes(); //Lấy các thẻ con của thẻ "state"
                    for (int j = 0; j < childNodes.getLength(); j++) {  //Duyệt từng thẻ con của "state"
                        Node childNode = childNodes.item(j);
                        if (childNode instanceof Element) {
//                            String content = childNode.getLastChild().getTextContent().trim();
                            String content = childNode.getTextContent();
                            String nodeName = childNode.getNodeName();

                            if ("initial".equals(nodeName)) {
                                state.setProperty(nodeName);
                            } else if ("final".equals(nodeName)) {
                                state.setExtension(nodeName);
                            }
                            else if ("label".equals(nodeName)) {
                                state.setGroup(Integer.parseInt(content));
                            }

                        }
                    }
                    stateList.add(state);
                }
            }

            return stateList;
        } catch (Exception e) {
            System.out.println("Lỗi!");
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Transition> getAllTransition() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            FileInputStream fIS = new FileInputStream(filename);
            Document document = builder.parse(fIS);

            List<Transition> transitionList = new ArrayList<>();

            // Lấy các tất cả các element có tag là "transition" chứa vào trong một nodeList
            NodeList nodeList = document.getElementsByTagName("transition");
//            System.out.println("So luong nodeList <transition>: " + nodeList.getLength());
            // Duyệt để lấy các giá trị của từng node trong nodeList
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);   //Lấy ra node thứ i trong nodeList
                if (node instanceof Element) {  //Kiểm tra node vừa lấy ra có phải một thẻ không ?
                    Transition transition = new Transition();

                    NodeList childNodes = node.getChildNodes(); //Lấy các thẻ con (childNode) của thẻ vừa lấy bên trên
                    for (int j = 0; j < childNodes.getLength(); j++) {  //Duyệt lần lượt từng tag con vừa lấy ra
                        Node childNode = childNodes.item(j);
                        if (childNode instanceof Element) {
                            String content = childNode.getLastChild().getTextContent().trim();
                            String nodeName = childNode.getNodeName();

                            if ("from".equals(nodeName)) {
                                int startState = Integer.parseInt(content);
                                transition.setStartState(startState);
                            } else if ("to".equals(nodeName)) {
                                int endState = Integer.parseInt(content);
                                transition.setEndState(endState);
                            } else if ("read".equals(nodeName)) {
                                transition.setReadWord(content);
                            }
                        }

                    }
                    transitionList.add(transition);
                }
            }
//            System.out.println("So luong trong transitionList: " + transitionList.size());
            return transitionList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

//https://stackoverflow.com/questions/19661047/java-convert-string-to-xml-and-parse-node
//https://stackoverflow.com/questions/14743088/get-element-name-from-xml-in-java-dom
