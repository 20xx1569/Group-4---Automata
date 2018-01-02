/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml_parser;

import java.util.List;

/**
 *
 * @author MyUniverse
 */
public interface DemoXmlParser {
    List<State> getAllState();
    List<Transition> getAllTransition();
}
