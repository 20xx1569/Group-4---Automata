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
public class State {

    String id;
    String name;
    String property;
    String extension;
    int group;

    public State(String id, String name, String property, String extension, int group) {
        this.id = id;
        this.name = name;
        this.property = property;
        this.extension = extension;
        this.group = group;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public State() {
    }
  
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("id:").append("\"").append(id).append("\"").append(",");
        sb.append("name:").append("\"").append(name).append("\"").append(",");
        sb.append("property: ").append("\"").append(property).append("\"").append(",");
        sb.append("extension: ").append("\"").append(extension).append("\"").append(",");
        sb.append("group: ").append("\"").append(group).append("\"").append(",");
        sb.append("}");
        return sb.toString();
    }

}
