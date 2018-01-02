/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml_create;

import static Action.Action.nba;
import NBA.ChuyenTrangThai1;
import NBA.NBA;
import NBA.State1;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author MyUniverse
 */
public class CreateXml {

    public void createXML(NBA nba) {
        try {
            ArrayList<ChuyenTrangThai1> listTransaction = new ArrayList<ChuyenTrangThai1>();
            ArrayList<State1> listState = new ArrayList<State1>();
            ArrayList<State1> startState = new ArrayList<State1>();
            ArrayList<State1> endState = new ArrayList<State1>();

            listState = nba.Q1;
            listTransaction = nba.denta1;
            startState = nba.Q01;
            endState = nba.F1;

            // Đánh index cho
            for (int i = 0; i < nba.Q1.size(); ++i) {
                nba.Q1.get(i).setIndex(i);
                System.out.println("Kich thuoc listState:= " + listState.size());
                System.out.println("Phan tu thu " + (i + 1) + " la: " + listState.get(i).getName()
                        + ", chi so " + listState.get(i).getIndex());
            }
//            
            for (int i = 0; i < nba.denta1.size(); ++i) {
                for (int j = 0; j < nba.Q1.size(); ++j) {
                    if ((nba.denta1.get(i).getOne().getName().getName().equals(nba.Q1.get(j).getName().getName()))
                            && (nba.denta1.get(i).getOne().getI() == nba.Q1.get(j).getI())) {
                        nba.denta1.get(i).getOne().setIndex(nba.Q1.get(j).getIndex());
                    }
                    if ((nba.denta1.get(i).getTwo().getName().getName().equals(nba.Q1.get(j).getName().getName()))
                            && (nba.denta1.get(i).getTwo().getI() == nba.Q1.get(j).getI())) {
                        nba.denta1.get(i).getTwo().setIndex(nba.Q1.get(j).getIndex());
                    }
                }
            }

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            // define root elements = "structure"
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("structure");

            document.appendChild(rootElement);
            // define type elements  
            Element type = document.createElement("type");
            type.appendChild(document.createTextNode("fa"));
            rootElement.appendChild(type);

            // define automaton elements  
            Element automaton = document.createElement("automaton");
            rootElement.appendChild(automaton);

            /* Define state element */
            for (int i = 0; i < listState.size(); ++i) {

                // define state elements  
                Element state = document.createElement("state");
                automaton.appendChild(state);

                // add attributes to state 
                String id = "" + i;
                Attr attribute = document.createAttribute("id");
                attribute.setValue(id);    //convert i from integer to string
                state.setAttributeNode(attribute);
                System.out.println("" + attribute.getValue());

                // add attributes to state  
                Attr attribute1 = document.createAttribute("name");
                attribute1.setValue(listState.get(i).getName().getName() + "," + listState.get(i).getI());
                state.setAttributeNode(attribute1);
                System.out.println("" + listState.get(i).getName().getName());

                // x elements  
                Element x_axis = document.createElement("x");
                String x = Integer.toString(135 + 20 * i);
                x_axis.appendChild(document.createTextNode(x));
                state.appendChild(x_axis);

                // y elements  
                Element y_axis = document.createElement("y");
                String y = Integer.toString(74 + 20 * i);
                y_axis.appendChild(document.createTextNode(y));
                state.appendChild(y_axis);

                /* property elements  */
                if ((listState.get(i).getName().equals(startState.get(0).getName()))
                        && (listState.get(i).getI() == (startState.get(0).getI()))) {
                    Element initial = document.createElement("initial");
                    state.appendChild(initial);

                }
                // extension elements  

                boolean check = false;
                for (int j = 0; j < endState.size(); ++j) {
                    if ((listState.get(i).getName().equals(endState.get(j).getName()))
                            && (listState.get(i).getI() == (endState.get(j).getI()))) {
                        check = true;
                    }
                }
                if (check) {
                    Element finale = document.createElement("final");
                    state.appendChild(finale);
                }
            }

//--------------------------------------------------------------
            for (int i = 0; i < listTransaction.size(); ++i) {
                // define transitions elements  
                Element transition = document.createElement("transition");
                automaton.appendChild(transition);

                // from elements  
                Element from = document.createElement("from");
                from.appendChild(document.createTextNode(Integer.toString(listTransaction.get(i).getOne().getIndex())));
                transition.appendChild(from);
                System.out.print("" + Integer.toString(listTransaction.get(i).getOne().getIndex()) + ";");

                // from elements  
                Element to = document.createElement("to");
                to.appendChild(document.createTextNode(Integer.toString(listTransaction.get(i).getTwo().getIndex())));
                transition.appendChild(to);
                System.out.print("" + Integer.toString(listTransaction.get(i).getTwo().getIndex()) + ";");

                // from elements  
                Element read = document.createElement("read");
                read.appendChild(document.createTextNode(listTransaction.get(i).getA().getName()));
                transition.appendChild(read);
                System.out.println("" + listTransaction.get(i).getA().getName());

//-----------------------------------------------------------------------------
            }
            /* Test tập transaction */
            for (ChuyenTrangThai1 test : nba.denta1) {
                System.out.println("From: " + test.getOne().getName().getName() + ", index: " + test.getOne().getIndex()
                        + " and To: " + test.getTwo().getName().getName() + ", index: " + test.getTwo().getIndex());
            }

//            for (ChuyenTrangThai1 ctt : nba.denta1) {
//                System.out.println("[" + ctt.getOne().getName().getName() + ";" + ctt.getOne().getI() + ";id:" + ctt.getOne().getiD() + "];"
//                        + ctt.getA().getName() + ";[" + ctt.getTwo().getName().getName() + ";" + ctt.getTwo().getI() + ";id:"
//                        + ctt.getTwo().getiD() + "]");
//            }
            // creating and writing to xml file  
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("createdFiles/createFile.xml"));

            transformer.transform(domSource, streamResult);

            System.out.println("File saved to specified path!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        CreateXml createXml = new CreateXml();
//        createXml.createXML();
//    }
}

//ArrayList<State> stateList, ArrayList<Transition> transitionList
