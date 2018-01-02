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
public class Transition {

    int startState;
    int endState;
    String readWord;

    public Transition() {
    }

    public Transition(int startState, int endState, String readWord) {
        this.startState = startState;
        this.endState = endState;
        this.readWord = readWord;
    }

    public int getStartState() {
        return startState;
    }

    public void setStartState(int startState) {
        this.startState = startState;
    }

    public int getEndState() {
        return endState;
    }

    public void setEndState(int endState) {
        this.endState = endState;
    }

    public String getReadWord() {
        return readWord;
    }

    public void setReadWord(String readWord) {
        this.readWord = readWord;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("startState:").append("\"").append(startState).append("\"").append(",");
        sb.append("endState:").append("\"").append(endState).append("\"").append(",");
        sb.append("readWord:").append("\"").append(readWord).append("\"");
        sb.append("}");
        return sb.toString();
    }
}
