/**
 *  Copyright 2005-2014 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package biz.majorov.camel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.camel.Body;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created from maven artifact and adapted
 * @author Nikolaj Majorov
 *
 */
public class CustomerServiceBean {

    private static Logger log = LoggerFactory.getLogger(CustomerServiceBean.class);
    static List<Customer> customers = new ArrayList<Customer>();
    Random randomGenerator = new Random();

 
    public void generateCustomers() {
       
        Customer customer = new Customer();
        customer.setName("John Done");
        customer.setNumOrders(randomGenerator.nextInt(100));
        customer.setRevenue(randomGenerator.nextInt(10000));
        customer.setType(CustomerType.BUSINESS);
        customer.setCanton("BS");
        customer.getAddress().add("Giessliweg 68, 4057, Basel ");
        
        Customer customer2 = new Customer();
        customer2.setName("Nikolaj Majorov");
        customer2.setNumOrders(randomGenerator.nextInt(100));
        customer2.setRevenue(randomGenerator.nextInt(10000));
        customer2.setType(CustomerType.PRIVATE);
        customer2.setCanton("GE");
        customer2.getAddress().add("Rue Sautter 13, 1205 Geneve");
        
        
        customers.add(customer);
        customers.add(customer2);
       
    }

    public Customer createCustomerFromName(@Body String name) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setNumOrders(randomGenerator.nextInt(100));
        customer.setRevenue(randomGenerator.nextInt(10000));
        customer.setType(CustomerType.BUSINESS);
        customer.setCanton("BS");
        customer.getAddress().add("Somestreet 123");

       
        return customer;
    }

    public Customer createCustomer(@Body String cutomerStr) {
        Customer customer = Customer.fromString(cutomerStr.toString());
        return customer;
    }
    
    
    /**
     * get back list of strings to camel splitter
     * @return
     */
    public List<String> getCustomers() {
        ArrayList<String> result = new ArrayList<String>();
        for (Iterator<Customer> iterator = CustomerServiceBean.customers.iterator(); iterator.hasNext();) {
            result.add(iterator.next().toString());
            
        }
        return result;
    }

    
    public  List<Customer> getCustomerByName(@Body String cSearched) {

        List<Customer> result = new ArrayList<Customer>();
        // Search for Customer using name as key
        for(Customer c : customers) {
            if (c.getName().equals(cSearched)) {
               result.add(c);
               log.info(">> Customer find !");
               break;
            }
        }

        
        return result;

    }

    public Customer saveCustomer(@Body Customer customer) {

       
       
        customers.add(customer);

        log.info(">> Customer created and added in the array.");

        return customer;
    }



}
