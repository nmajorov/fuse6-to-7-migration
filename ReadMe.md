# Fuse7-2 migration path


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


## Migration from FUSE 6.3 to 7.2 for applications using spring deployer


    there is open issue https://issues.jboss.org/browse/FUSEDOC-2908 to resolve problem with spring deployer. 

    you need "aries-blueprint-spring" feature from "spring-legacy" feature repository (available in Fuse 7, because we use spring 4).

    Here's one line that made droolsjbpm-integration test work: https://github.com/kiegroup/droolsjbpm-integration/blob/master/kie-osgi/kie-karaf-itests/src/test/java/org/kie/karaf/itest/KieSpringDependencyKarafIntegrationTest.java#L74
    This test uses unchanged spring.xml: https://github.com/kiegroup/droolsjbpm-integration/blob/master/kie-osgi/kie-karaf-itests/src/test/resources/org/kie/karaf/itest/kie-beans-dependency.xml

    From 
    Grzegorz Grzybek (RedHat Inc.)
