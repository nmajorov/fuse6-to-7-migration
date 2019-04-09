package biz.majorov.camel;



import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CustomerTest {
  private final static Logger logger = LoggerFactory.getLogger(CustomerTest.class);

  /**
   * Test customer object creation from string.<br>
   * The example of customer representation as string:<br>
   * <code>
   *  name=Bill;birthDate=1976-05-04;address=[Rue Sautter 13 1205 Geneve, rue de la prairie 1202 Geneve];type=BUSINESS;numOrders=1;revenue=20.0;canton=GE;
   * </code>
   * @throws Exception errors
   */
  @Test
  public void testCreateCustomerFromSting() throws Exception{
    Customer customer = new Customer();
    customer.setName("Niko");
    customer.setNumOrders(1);
    customer.setRevenue(20.0);
    customer.setCanton("GE");
    XMLGregorianCalendar birthdate  = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar();
    birthdate.setDay(4);
    birthdate.setMonth(5);
    birthdate.setYear(1976);
    customer.setBirthDate(birthdate);
    customer.getAddress().add("Rue Sautter 13 1205 Geneve");

    customer.setType(CustomerType.BUSINESS);

    logger.info("create customer: " + customer.toString());

    Customer result = Customer.fromString(customer.toString());
    logger.info("customer form string: " + result);
    assertTrue(result.getName().equals(customer.getName()));
    assertTrue(result.getAddress().get(0).equals(customer.getAddress().get(0)));
    assertTrue(result.getRevenue()== customer.getRevenue());
    assertSame(result.getType(),customer.getType());

  }
}
