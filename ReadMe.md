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


## Migration from FUSE 6.3 to 7.4

Thanks Grzegorz!
Yup, using aries-blueprint-spring(Thanks Guillaume😃) is a way to continue to support spring in FUSE7.

But IIRC last time I asked internally, the answer is that we won't support spring officially for FUSE7 because we already have way too more flavor combinations to take care of, so customers should go with blueprint instead. TBH I don't know this situation was changed or not.

Best Regards
Freeman

On Wed, Apr 10, 2019 at 2:01 PM Grzegorz Grzybek <ggrzybek@redhat.com> wrote:

    Hello Nikolaj

    I have https://issues.jboss.org/browse/FUSEDOC-2908 to resolve for this. I asked Torsten to create this issue, so I can prepare draft documentation that describes your case.

    I helped RHPAM team to migrate their droolsjbpm-integration samples from spring-dm to aries-blueprint-sprint, but I can not offer you anything (for now) but one hint - you need "aries-blueprint-spring" feature from "spring-legacy" feature repository (available in Fuse 7, because we use spring 4).

    Here's one line that made droolsjbpm-integration test work: https://github.com/kiegroup/droolsjbpm-integration/blob/master/kie-osgi/kie-karaf-itests/src/test/java/org/kie/karaf/itest/KieSpringDependencyKarafIntegrationTest.java#L74
    This test uses unchanged spring.xml: https://github.com/kiegroup/droolsjbpm-integration/blob/master/kie-osgi/kie-karaf-itests/src/test/resources/org/kie/karaf/itest/kie-beans-dependency.xml

    regards
    Grzegorz Grzybek
