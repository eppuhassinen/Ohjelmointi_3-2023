
package fi.tuni.prog3.json;

/**
 * A class for representing a JSON value.
 */
public class ValueNode extends Node{
    private double number;
    private String word; //word or null
    private boolean flag;
    
    private boolean isDouble = false;
    private boolean isString = false;
    private boolean isBoolean = false;
    private boolean isNull = false;

    /**
    * Constructs a JSON value node that stores the null value.
    */
    public ValueNode() {
        isNull = true;
    }
    
    /**
     * Constructs a JSON value node that stores the given double value.
     * @param value The double value to store in the new JSON value node.
     */
    public ValueNode(double value) {
        this.number = value;
        isDouble = true;
    }
    /**
     * Constructs a JSON value node that stores the given boolean value.
     * @param value The boolean value to store in the new JSON value node.
     */
    public ValueNode(boolean value) {
        this.flag = value;
        isBoolean = true;
    }
    /**
     * Constructs a JSON value node that stores the given string.
     * @param value The string to store in the new JSON value node.
     * @throws IllegalStateException if the parameter value is null.
     */
    public ValueNode(String value) throws IllegalStateException {
        if (value == null) {
            throw new IllegalStateException("Null value!");
        }
        this.word = value;
        isString = true;
    }

    


    
    /**
     * Checks whether this value node stores a number (double).
     * @return true if this node stores a double value, otherwise false.
     */
    public Boolean isNumber(){
        return this.isDouble;
    }
    /**
     * Checks whether this value node stores a boolean value.
     * @return true if this node stores a boolean value, otherwise false.
     */
    public Boolean isBoolean(){
        return this.isBoolean;
    }
    /**
     * Checks whether this value node stores a string.
     * @return true if this node stores a string, otherwise false.
     */
    public Boolean isString(){
        return this.isString;
    }
    
    
    /**
     * Checks whether this value node stores null.
     * @return true if this node stores null, otherwise false.
     */
    public Boolean isNull(){
        return this.isNull;
    }
    
    
/**
 * Returns the stored value as a number (double).
 * @return the stored number as a double value.
 */
    public double getNumber() {
        return number;
    }
     /**
     * Returns the stored value as a boolean value.
     * @return the stored boolean value.
     * @throws IllegalStateException if the stored value is not a boolean value.
     */
    public boolean getBoolean() throws IllegalStateException{
        if (!this.isBoolean){
            throw new IllegalStateException("No boolean stored");
        }
        return flag;
    }

    /**
     * Returns the stored value as a string.
     * @return the stored string.
     * @throws IllegalStateException if the stored value is not a boolean value.
     */
    public String getString() throws IllegalStateException {
        if (!this.isString) {throw new IllegalStateException("No string stored");}
        return word;
    }

   

    /**
     * Returns the stored value as null.
     * @return null.
     * @throws IllegalStateException if the stored value is not null.
     */
    public Object getNull() throws IllegalStateException {
        if (!this.isNull){
            throw new IllegalStateException("No null value stored");
        }
        return null;
    }
    
    
    
}