/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml_parser;

/**
 *
 * @author MyUniverse
 */
public abstract class DemoAbstractParser implements DemoXmlParser {
    protected String filename = null;

    public DemoAbstractParser(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
    
    
}
