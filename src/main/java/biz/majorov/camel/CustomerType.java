
package biz.majorov.camel;


/**
 * <p>Java class for customerType.
 *
 *
 *
 */

public enum CustomerType {

    PRIVATE,
    BUSINESS;

    public String value() {
        return name();
    }

    public static CustomerType fromValue(String v) {
        return valueOf(v);
    }

    @Override
    public String toString(){
        return this.value();
    }

}
