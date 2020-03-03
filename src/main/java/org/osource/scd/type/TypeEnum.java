package org.osource.scd.type;

/**
 * @author chengdu
 *
 */
public enum TypeEnum {

    String("java.lang.String"),
    Integer("java.lang.Integer"),
    Long("java.lang.Long"),
    Double("java.lang.Double"),
    Date("java.util.Date"),
    Boolean("java.lang.Boolean");

    private String clazz;

    TypeEnum(String clazz){
        this.clazz = clazz;
    }

    public String type(){
        return clazz;
    }
}
