
package fi.tuni.prog3.json;

public class ValueNode extends Node{
    private double number;
    private String word; //word or null
    private boolean flag;
    
    private boolean isDouble = false;
    private boolean isString = false;
    private boolean isBoolean = false;
    private boolean isNull = false;

    public ValueNode(double value) {
        this.number = value;
        isDouble = true;
    }

    public ValueNode(String value) {
        this.word = value;
        isString = true;
    }

    public ValueNode(boolean value) {
        this.flag = value;
        isBoolean = true;
    }

    public ValueNode() {
        isNull = true;
    }
    
    public Boolean isNumber(){
        return this.isDouble;
    }
    
    public Boolean isString(){
        return this.isString;
    }
    
    public Boolean isBoolean(){
        return this.isBoolean;
    }
    
    public Boolean isNull(){
        return this.isNull;
    }
    
    

    public double getNumber() {
        return number;
    }

    public String getString() {
        return word;
    }

    public boolean getBoolean() {
        return flag;
    }

    public Object getNull() {
        return null;
    }
    
    
    
}