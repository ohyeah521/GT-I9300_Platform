/*
 This Java source file was generated by test-to-java.xsl
 and is a derived work from the source document.
 The source document contained the following notice:



 Copyright (c) 2001 World Wide Web Consortium,
 (Massachusetts Institute of Technology, Institut National de
 Recherche en Informatique et en Automatique, Keio University).  All
 Rights Reserved.  This program is distributed under the W3C's Software
 Intellectual Property License.  This program is distributed in the
 hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 PURPOSE.

 See W3C License http://www.w3.org/Consortium/Legal/ for more details.


 */

package tests.org.w3c.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.DOMException;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;

/**
 * The method setPrefix sets the namespace prefix of this node. Note that
 * setting this attribute, when permitted, changes the nodeName attribute, which
 * holds the qualified name, as well as the tagName and name attributes of the
 * Element and Attr interfaces, when applicable.
 *
 * Create a new element node with a namespace prefix. Add it to a new
 * DocumentFragment Node without a prefix. Call setPrefix on the elemen node.
 * Check if the prefix was set correctly on the element.
 *
 * @author IBM
 * @author Neil Delima
 * @see <a
 *      href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-NodeNSPrefix</a>
 */
public final class NodeSetPrefix extends DOMTestCase {

    DOMDocumentBuilderFactory factory;

    DocumentBuilder builder;

    protected void setUp() throws Exception {
        super.setUp();
        try {
            factory = new DOMDocumentBuilderFactory(DOMDocumentBuilderFactory
                    .getConfiguration1());
            builder = factory.getBuilder();
        } catch (Exception e) {
            fail("Unexpected exception" + e.getMessage());
        }
    }

    protected void tearDown() throws Exception {
        factory = null;
        builder = null;
        super.tearDown();
    }

    /**
     * Runs the test case.
     *
     * @throws Throwable
     *             Any uncaught exception causes test to fail
     */
    public void testSetPrefix1() throws Throwable {
        Document doc;
        DocumentFragment docFragment;
        Element element;
        String elementTagName;
        String elementNodeName;

        doc = (Document) load("staff", builder);
        docFragment = doc.createDocumentFragment();
        element = doc.createElementNS("http://www.w3.org/DOM/Test",
                "emp:address");
        docFragment.appendChild(element);
        element.setPrefix("dmstc");
        elementTagName = element.getTagName();
        elementNodeName = element.getNodeName();
        assertEquals("nodesetprefix01_tagname", "dmstc:address", elementTagName);
        assertEquals("nodesetprefix01_nodeName", "dmstc:address",
                elementNodeName);
    }

// TODO Fails on JDK. Why?
//    public void testSetPrefix2() throws Throwable {
//        Document doc;
//        Element element;
//        Attr attribute;
//        Attr newAttribute;
//
//        NodeList elementList;
//        String attrName;
//        String newAttrName;
//        doc = (Document) load("staffNS", builder);
//        elementList = doc.getElementsByTagName("address");
//        element = (Element) elementList.item(1);
//        newAttribute = doc.createAttributeNS("http://www.w3.org/DOM/Test",
//                "test:address");
//        element.setAttributeNodeNS(newAttribute);
//        newAttribute.setPrefix("dom");
//        attribute = element
//                .getAttributeNodeNS("http://www.usa.com", "domestic");
//        attrName = attribute.getNodeName();
//        newAttrName = newAttribute.getNodeName();
//        assertEquals("nodesetprefix02_attrName", "dmstc:domestic", attrName);
//        assertEquals("nodesetprefix02_newAttrName", "dom:address", newAttrName);
//    }
    public void testSetPrefix3() throws Throwable {
        Document doc;
        Element element;
        doc = (Document) load("staffNS", builder);
        element = doc.createElement("address");

        {
            boolean success = false;
            try {
                element.setPrefix("test");
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NAMESPACE_ERR);
            }
            assertTrue("throw_NAMESPACE_ERR", success);
        }
    }

// Relies on validation, which we don't support.
//    public void testSetPrefix4() throws Throwable {
//        Document doc;
//        Element element;
//        Attr attribute;
//        NodeList elementList;
//        String nullNS = null;
//
//        doc = (Document) load("staffNS", builder);
//        elementList = doc.getElementsByTagName("emp:employee");
//        element = (Element) elementList.item(0);
//        assertNotNull("empEmployeeNotNull", element);
//        attribute = element.getAttributeNodeNS(nullNS, "defaultAttr");
//
//        {
//            boolean success = false;
//            try {
//                attribute.setPrefix("test");
//            } catch (DOMException ex) {
//                success = (ex.code == DOMException.NAMESPACE_ERR);
//            }
//            assertTrue("nodesetprefix04", success);
//        }
//    }
    public void testSetPrefix5() throws Throwable {
        Document doc;
        Element element;
        String prefixValue;
        List<String> prefixValues = new ArrayList<String>();
        prefixValues.add("_:");
        prefixValues.add(":0");
        prefixValues.add(":");
        prefixValues.add("_::");
        prefixValues.add("a:0:c");

        doc = (Document) load("staffNS", builder);
        element = doc.createElementNS("http://www.w3.org/DOM/Test/L2",
                "dom:elem");
        for (int indexN10050 = 0; indexN10050 < prefixValues.size(); indexN10050++) {
            prefixValue = (String) prefixValues.get(indexN10050);

            {
                boolean success = false;
                try {
                    element.setPrefix(prefixValue);
                } catch (DOMException ex) {
                    success = (ex.code == DOMException.NAMESPACE_ERR);
                }
                assertTrue("throw_NAMESPACE_ERR", success);
            }
        }
    }
    public void testSetPrefix6() throws Throwable {
        Document doc;
        Element element;
        doc = (Document) load("staffNS", builder);
        element = doc.createElementNS("http://www.w3.org/DOM/Test/L2",
                "dom:elem");

        {
            boolean success = false;
            try {
                element.setPrefix("xml");
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NAMESPACE_ERR);
            }
            assertTrue("throw_NAMESPACE_ERR", success);
        }
    }
    public void testSetPrefix7() throws Throwable {
        Document doc;
        Attr attribute;
        doc = (Document) load("staffNS", builder);
        attribute = doc.createAttributeNS("http://www.w3.org/DOM/Test/L2",
                "abc:elem");

        {
            boolean success = false;
            try {
                attribute.setPrefix("xmlns");
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NAMESPACE_ERR);
            }
            assertTrue("throw_NAMESPACE_ERR", success);
        }
    }
    public void testSetPrefix8() throws Throwable {
        Document doc;
        Element element;
        NodeList elementList;
        Attr attribute;
        doc = (Document) load("staffNS", builder);
        elementList = doc.getElementsByTagName("employee");
        element = (Element) elementList.item(0);
        attribute = element.getAttributeNode("xmlns");

        {
            boolean success = false;
            try {
                attribute.setPrefix("xml");
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NAMESPACE_ERR);
            }
            assertTrue("throw_NAMESPACE_ERR", success);
        }
    }
    public void _testSetPrefix9() throws Throwable {
        Document doc;
        String value = "#$%&'()@";
        Element element;
        doc = (Document) load("staffNS", builder);
        element = doc.createElementNS("http://www.w3.org/DOM/Test/L2",
                "dom:elem");

        {
            boolean success = false;
            try {
                element.setPrefix(value);
            } catch (DOMException ex) {
                success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
            }
            assertTrue("throw_INVALID_CHARACTER_ERR", success);
        }
    }
}