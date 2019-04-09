Camel Splitting of message - Customers Example
==============================================
Component used camel-sql, customized pool osgi

To build this project use

    mvn install


to deploy on fuse:

    features:addurl mvn:biz.majorov.camel/nm-spring/1.0-SNAPSHOT/xml/features
    features:install nm-spring
    
if everything goes fine you will see the result message:

            1429 | Exchange[ExchangePattern: InOnly, BodyType: java.util.ArrayList, Body: [name=John Done;birthDate=null;address=[Giessliweg 68, 4057, Basel ];type=BUSINESS;numOrders=63;revenu
            e=5291.0;canton=BS;, name=Nikolaj Majorov;birthDate=null;address=[Rue Sautter 13, 1205 Geneve];type=PRIVATE;numOrders=49;revenue=5430.0;canton=GE;]]
