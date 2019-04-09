
package biz.majorov.camel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;

public class Customer {


    protected String name;

    protected List<String> address;
    protected int numOrders;
    protected double revenue;
    protected String canton;
    protected CustomerType type;
    protected XMLGregorianCalendar birthDate;
    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }


    public List<String> getAddress() {
        if (address == null) {
            address = new ArrayList<String>();
        }
        return this.address;
    }


    /**
     * Gets the value of the numOrders property.
     *
     */
    public int getNumOrders() {
        return numOrders;
    }

    /**
     * Sets the value of the numOrders property.
     *
     */
    public void setNumOrders(int value) {
        this.numOrders = value;
    }

    /**
     * Gets the value of the revenue property.
     *
     */
    public double getRevenue() {
        return revenue;
    }

    /**
     * Sets the value of the revenue property.
     *
     */
    public void setRevenue(double value) {
        this.revenue = value;
    }

    /**
     * Gets the value of the test property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public String getCanton() {
        return this.canton;
    }

    /**
     * Sets the value of the test property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     * Gets the value of the birthDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link CustomerType }
     *
     */
    public CustomerType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link CustomerType }
     *
     */
    public void setType(CustomerType value) {
        this.type = value;
    }


    @Override
     public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("name=").append(this.name).append(';');
      stringBuilder.append("birthDate=").append(this.birthDate).append(';');
      stringBuilder.append("address=").append(this.address).append(';');
      stringBuilder.append("type=").append(this.type).append(';');
      stringBuilder.append("numOrders=").append(this.numOrders).append(';');
      stringBuilder.append("revenue=").append(this.revenue).append(';');
      stringBuilder.append("canton=").append(this.canton).append(';');
      return stringBuilder.toString();
   }


    /**
     * create Customer object form string representation
     * @param str the string representing the customer
     */
    public static Customer fromString(String str){
      Customer customer = new Customer();
      String splitted [] = str.split(";",-1);
      for (String s: splitted){
          if(s.startsWith("name")){
            String name = s.substring(s.indexOf('=') + 1);
            customer.setName(name);
          }

          if (s.startsWith("birthDate")){
            String birthDateStr= s.substring(s.indexOf('=') +1 );
            try{
              XMLGregorianCalendar calender = DatatypeFactory.newInstance()
                     .newXMLGregorianCalendar(birthDateStr);
              customer.setBirthDate(calender);
            }catch(Exception ex){
              ex.printStackTrace();
            }
          }

          if(s.startsWith("address")){
            String tmp= s.substring(s.indexOf('=')+1);
           
            String[] array =  tmp.split(",",-1);
           
            String address = new String();
            if(array.length >1){
                ///we have several addresses 
                for(String a: array){
                    if (a.startsWith("[")){
                        address= a.substring(a.indexOf('[')+1);
                    }else{
                        address= a.substring(0,a.indexOf(']'));
                    }
                    customer.getAddress().add(address.trim());
                  }
            }else{
                /// we have a single address 
                String a = array[0];
                address= a.substring(a.indexOf('[')+1,a.indexOf(']'));
                customer.getAddress().add(address.trim());
            }
          }
          
          if(s.startsWith("type")){
              String type=s.substring(s.indexOf("=")+1);
              customer.setType(CustomerType.fromValue(type));
          }
          
          if(s.startsWith("numOrders")){
              String numOrdersStr= s.substring(s.indexOf("=")+1);
              customer.setNumOrders(Integer.valueOf(numOrdersStr));
          }
          
          if(s.startsWith("revenue")){
              String revenue= s.substring(s.indexOf("=")+1);
              customer.setRevenue(Double.valueOf(revenue));
          }
          
          
          if(s.startsWith("canton")){
              String canton = s.substring(s.indexOf("=")+1);
              customer.setCanton(canton);
          }
      }

      return customer;
    }
}
